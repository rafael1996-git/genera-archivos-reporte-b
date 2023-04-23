/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.constructores;

import com.eglobal.genera.archivos.reporte.b.constructores.excepctions.GeneraArchivosReporteBException;
import com.eglobal.genera.archivos.reporte.b.entities.ArchivosReporteB;
import com.eglobal.genera.archivos.reporte.b.entities.CEstatusArchivos;
import com.eglobal.genera.archivos.reporte.b.entities.EmisoresAdeudo;
import com.eglobal.reporte.b.commons.beans.EmisoresConsultaBean;
import com.eglobal.reporte.b.commons.beans.exceptions.GeneraResumenReporteBException;
import com.eglobal.reporte.b.commons.providers.PathsProjectProvider;
import com.eglobal.reporte.b.commons.providers.ProveedorProperties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author egldt1134
 */
public abstract class ConstructorArchivosReporteB extends Thread {

    private static final Logger LOG = LogManager.getLogger(ConstructorArchivosReporteB.class);

    EntityManager emP;
    EntityManager emI;

    public ConstructorArchivosReporteB() {
        ProveedorProperties pp = ProveedorProperties.GETINSTANCE();

        EntityManagerFactory emfI;
        EntityManagerFactory emfP;
        try {
            emfI = Persistence.createEntityManagerFactory("informix_PU", pp.getPropsI());
            emfP = Persistence.createEntityManagerFactory("postgreSQL_PU", pp.getPropsP());
            emI = emfI.createEntityManager();
            emP = emfP.createEntityManager();
        } catch (IOException ex) {
            LOG.error("No fue posible crear el manejador de entidades. ", ex);
            System.exit(-1);
        }
    }

    public void construir() {
        emP.getTransaction().begin();
        List<ArchivosReporteB> archivosPendientes = this.obtenerArchivosPendientes();
        if (archivosPendientes == null || archivosPendientes.isEmpty()) {
            LOG.info("No se encontraron Archivos Pendientes Para el Proceso.");
            System.exit(0);
        }
        Connection connection = null;
        emI.getTransaction().begin();
        connection = emI.unwrap(Connection.class);
        PreparedStatement statement;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String rutaProductos = PathsProjectProvider.getConf().getHomeProductosBatch();
        File archivo;
        Writer writer = null;
        try {
            Map<Integer, List<EmisoresConsultaBean>> emisoresListConsultas = this.obtenerConsultasPorEmisor();
            for (ArchivosReporteB a : archivosPendientes) {
                a.setIdEstatus(emP.getReference(CEstatusArchivos.class, 2));
                emP.merge(a);
                LOG.info("Archivo obtenido:  " + a.getNombreArchivo());
            }
            emP.getTransaction().commit();
            emP.getTransaction().begin();
            for (ArchivosReporteB archivoReporteB : archivosPendientes) {
                Collection<EmisoresAdeudo> emisoresAdeudo = archivoReporteB.getEmisoresAdeudoCollection();
                Date fechaIni = archivoReporteB.getFechaInicialRango();
                Date fechaFin = archivoReporteB.getFechaFinalRango();
                String nombreArchivo = archivoReporteB.getNombreArchivo();

                LOG.info("Procesando archivo: " + archivoReporteB.getNombreArchivo());

                archivoReporteB.setFechaInicioProceso(new Date());
                emP.merge(archivoReporteB);
                emP.getTransaction().commit();
                emP.getTransaction().begin();
                String vsOrMc = nombreArchivo.contains("vs") ? "V" : "M";
                archivo = new File(rutaProductos + File.separator + nombreArchivo);
                writer = new OutputStreamWriter(new FileOutputStream(archivo));
                for (EmisoresAdeudo emisorAdeudo : emisoresAdeudo) {
                    List<EmisoresConsultaBean> lstEmisoresConsultaBean
                            = emisoresListConsultas.get(emisorAdeudo.getEmisoresAdeudoPK().getIdEmisor());
                    for (EmisoresConsultaBean ecb : lstEmisoresConsultaBean) {
                        String q = ecb.getQuery();
                        if (ecb.isSubAfiliados()) {
                            if (emisorAdeudo.getEmisoresAdeudoPK().getIdEmisor() == emisorAdeudo.getEmisoresAdeudoPK().getIdInstitucionBm()) {
                                q = ecb.getQuery().trim().replaceAll("and b.bin = \\?", " ");
                            }
                        }
                        statement = connection.prepareStatement(q);
                        statement.setString(1, sdf.format(fechaIni));
                        statement.setString(2, sdf.format(fechaFin));
                        statement.setString(3, vsOrMc);
                        if (ecb.isSubAfiliados()) {
                            if (emisorAdeudo.getEmisoresAdeudoPK().getIdEmisor() != emisorAdeudo.getEmisoresAdeudoPK().getIdInstitucionBm()) {
                                statement.setString(4, emisorAdeudo.getEmisoresAdeudoPK().getIdInstitucionBm() + "");
                            }
                        }
                        ResultSet rs = statement.executeQuery();

                        List<String> registrosArchivo = null;
                        if (ecb.isSubAfiliados()) {
                            registrosArchivo = emisorAdeudo.getEmisoresAdeudoPK().getIdEmisor()
                                    == emisorAdeudo.getEmisoresAdeudoPK().getIdInstitucionBm()
                                    ? this.generarRegistrosSubArchivo(rs)
                                    : this.generarRegistrosArchivo(rs);
                        } else {
                            registrosArchivo = this.generarRegistrosArchivo(rs);
                        }
                        for (String reg : registrosArchivo) {
                            writer.write(reg);
                        }
                        writer.flush();
                    }
                }
                archivoReporteB.setFechaFinProceso(new Date());
                archivoReporteB.setIdEstatus(emP.getReference(CEstatusArchivos.class, 3));
                emP.merge(archivoReporteB);
                emP.getTransaction().commit();
                emP.getTransaction().begin();
                LOG.info("Finaliza proceso de archivo: " + archivoReporteB.getNombreArchivo());
            }
            emP.getTransaction().commit();
        } catch (SQLException ex) {
            LOG.info("Ha ocurrido un error en Base de Datos");
            emP.getTransaction().rollback();
        } catch (FileNotFoundException ex) {
            LOG.info("No se encontró el archivo en ruta para comenzar escritura.");
            emP.getTransaction().rollback();
        } catch (IOException ex) {
            LOG.info("OCurrió un error al intentar escribir en archivo.");
            emP.getTransaction().rollback();
        } catch (GeneraResumenReporteBException ex) {
            LOG.info(ex.getMessage());
            emP.getTransaction().rollback();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOG.info("Ocurrió un error al cerrar la conexión.", ex);
                }
            }
            if (this.emI.isOpen()) {
                this.emI.close();
            }
            if (this.emP.isOpen()) {
                this.emP.close();
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    LOG.error("Imposible cerrar archivo");
                }
            }
        }

    }
    
    public abstract List<ArchivosReporteB> obtenerArchivosPendientes();

    public abstract Map<Integer, List<EmisoresConsultaBean>> obtenerConsultasPorEmisor() throws GeneraResumenReporteBException;

    public abstract List<String> generarRegistrosArchivo(ResultSet rs) throws SQLException;

    public abstract List<String> generarRegistrosSubArchivo(ResultSet rs) throws SQLException;

    @Override
    public void run() throws GeneraArchivosReporteBException {
        this.construir();
    }
}

/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.constructores;

import com.eglobal.beans.ConsultaSimpleResponseData;
import com.eglobal.genera.archivos.reporte.b.entities.ArchivosReporteB;
import com.eglobal.reporte.b.commons.beans.EmisoresConsultaBean;
import com.eglobal.reporte.b.commons.beans.exceptions.GeneraResumenReporteBException;
import com.eglobal.reporte.b.commons.beans.insumos.impl.LeerEmisoresConsultasPOS;
import com.eglobal.reporte.b.commons.providers.ProveedorBinesBUB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author egldt1134
 */
public class ConstructorArchivosReporteBPOS extends ConstructorArchivosReporteB {

    private static final Logger LOG = LogManager.getLogger(ConstructorArchivosReporteBPOS.class);

    public ConstructorArchivosReporteBPOS() {
        super();
    }

    @Override
    public List<ArchivosReporteB> obtenerArchivosPendientes() {
        String query = "SELECT a FROM ArchivosReporteB a "
                + "where a.idEstatus.idEstatus=1 "
                + "and a.idProceso.idProceso=1";
        Query q = emP.createQuery(query, ArchivosReporteB.class);

        return q.getResultList();
    }

    @Override
    public Map<Integer, List<EmisoresConsultaBean>> obtenerConsultasPorEmisor() throws GeneraResumenReporteBException {
        LeerEmisoresConsultasPOS lecp = new LeerEmisoresConsultasPOS();
        Map<Integer, List<EmisoresConsultaBean>> mapaEmisores = lecp.obtenerEmisores("consultasEmisoresDetallePOSProperties.xml");
        return mapaEmisores;
    }

    @Override
    public List<String> generarRegistrosArchivo(ResultSet rs) throws SQLException {
        List<String> registros = new ArrayList<>();
        StringBuilder sb;
        while (rs.next()) {
            String cod_txn = rs.getString(1);
            String fecha_txn = rs.getString(2);
            String fecha_proceso = rs.getString(3);
            String tipo_prod = rs.getString(4);
            String no_tarjeta = rs.getString(5);
            String emisor = rs.getString(6);
            String adquirente = rs.getString(7);
            String giro = rs.getString(8);
            String ubicacion = rs.getString(9);
            String importe_txn = rs.getString(10);
            String contracargo = rs.getString(11);
            String autorizacion = rs.getString(12);

            sb = new StringBuilder("");
            sb.append(cod_txn)
                    .append("|")
                    .append(fecha_txn)
                    .append("|")
                    .append(fecha_proceso)
                    .append("|")
                    .append(tipo_prod)
                    .append("|")
                    .append(no_tarjeta)
                    .append("|")
                    .append(emisor)
                    .append("|")
                    .append(adquirente)
                    .append("|")
                    .append(giro)
                    .append("|")
                    .append(ubicacion)
                    .append("|")
                    .append(importe_txn)
                    .append("|")
                    .append(contracargo)
                    .append("|")
                    .append(autorizacion)
                    .append("\n");//SAlto de línea para el final del registro
            registros.add(sb.toString());
        }
        return registros;
    }

    @Override
    public List<String> generarRegistrosSubArchivo(ResultSet rs) throws SQLException {
        List<String> registros = new ArrayList<>();
        StringBuilder sb;
        while (rs.next()) {
            String bin = rs.getString(13) != null ? rs.getString(13).trim() : "";
            ConsultaSimpleResponseData consultaSimpleResponseData = ProveedorBinesBUB.GETINSTANCE().getMapaBinesEv().get(bin);
            if (consultaSimpleResponseData != null) {
                continue;
            }
            String cod_txn = rs.getString(1);
            String fecha_txn = rs.getString(2);
            String fecha_proceso = rs.getString(3);
            String tipo_prod = rs.getString(4);
            String no_tarjeta = rs.getString(5);
            String emisor = rs.getString(6);
            String adquirente = rs.getString(7);
            String giro = rs.getString(8);
            String ubicacion = rs.getString(9);
            String importe_txn = rs.getString(10);
            String contracargo = rs.getString(11);
            String autorizacion = rs.getString(12);

            sb = new StringBuilder("");
            sb.append(cod_txn)
                    .append("|")
                    .append(fecha_txn)
                    .append("|")
                    .append(fecha_proceso)
                    .append("|")
                    .append(tipo_prod)
                    .append("|")
                    .append(no_tarjeta)
                    .append("|")
                    .append(emisor)
                    .append("|")
                    .append(adquirente)
                    .append("|")
                    .append(giro)
                    .append("|")
                    .append(ubicacion)
                    .append("|")
                    .append(importe_txn)
                    .append("|")
                    .append(contracargo)
                    .append("|")
                    .append(autorizacion)
                    .append("\n");//SAlto de línea para el final del registro
            registros.add(sb.toString());
        }
        return registros;
    }
}

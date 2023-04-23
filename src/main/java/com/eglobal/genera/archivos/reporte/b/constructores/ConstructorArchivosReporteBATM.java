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
import com.eglobal.reporte.b.commons.beans.insumos.impl.LeerEmisoresConsultasATMS;
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
 * @author egldbo1920
 */
public class ConstructorArchivosReporteBATM extends ConstructorArchivosReporteB {

    private static final Logger LOG = LogManager.getLogger(ConstructorArchivosReporteBATM.class);

    public ConstructorArchivosReporteBATM() {
        super();
    }

    @Override
    public List<ArchivosReporteB> obtenerArchivosPendientes() {
        String query = "SELECT a FROM ArchivosReporteB a "
                + "where a.idEstatus.idEstatus=1 "
                + "and a.idProceso.idProceso=2";
        Query q = emP.createQuery(query, ArchivosReporteB.class);

        return q.getResultList();
    }

    @Override
    public Map<Integer, List<EmisoresConsultaBean>> obtenerConsultasPorEmisor() throws GeneraResumenReporteBException {
        LeerEmisoresConsultasATMS lecp = new LeerEmisoresConsultasATMS();
        Map<Integer, List<EmisoresConsultaBean>> mapaEmisores = lecp.obtenerEmisores("consultasEmisoresDetalleATMProperties.xml");
        return mapaEmisores;
    }

    @Override
    public List<String> generarRegistrosArchivo(ResultSet rs) throws SQLException {
        List<String> registros = new ArrayList<>();
        StringBuilder sb;
        while (rs.next()) {
            String tipo_txn = rs.getString(1);
            String fecha_txn = rs.getString(2);
            String hora_txn = rs.getString(3);
            String fecha_stratus = rs.getString(4);
            String tipo_prod = rs.getString(5);
            String num_tarjeta = rs.getString(6);
            String emisor = rs.getString(7);
            String adq = rs.getString(8);
            String monto_txn = rs.getString(9);
            String rrn = rs.getString(10);
            String no_autorizacion = rs.getString(11);

            sb = new StringBuilder("");
            sb.append(tipo_txn)
                    .append("|")
                    .append(fecha_txn)
                    .append("|")
                    .append(hora_txn)
                    .append("|")
                    .append(fecha_stratus)
                    .append("|")
                    .append(tipo_prod)
                    .append("|")
                    .append(num_tarjeta)
                    .append("|")
                    .append(emisor)
                    .append("|")
                    .append(adq)
                    .append("|")
                    .append(monto_txn)
                    .append("|")
                    .append(rrn)
                    .append("|")
                    .append(no_autorizacion)
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
            String bin = rs.getString(12)!= null? rs.getString(12).trim():"";
            ConsultaSimpleResponseData consultaSimpleResponseData = ProveedorBinesBUB.GETINSTANCE().getMapaBinesEv().get(bin);
            if(consultaSimpleResponseData != null){
                continue;
            }
            String tipo_txn = rs.getString(1);
            String fecha_txn = rs.getString(2);
            String hora_txn = rs.getString(3);
            String fecha_stratus = rs.getString(4);
            String tipo_prod = rs.getString(5);
            String num_tarjeta = rs.getString(6);
            String emisor = rs.getString(7);
            String adq = rs.getString(8);
            String monto_txn = rs.getString(9);
            String rrn = rs.getString(10);
            String no_autorizacion = rs.getString(11);

            sb = new StringBuilder("");
            sb.append(tipo_txn)
                    .append("|")
                    .append(fecha_txn)
                    .append("|")
                    .append(hora_txn)
                    .append("|")
                    .append(fecha_stratus)
                    .append("|")
                    .append(tipo_prod)
                    .append("|")
                    .append(num_tarjeta)
                    .append("|")
                    .append(emisor)
                    .append("|")
                    .append(adq)
                    .append("|")
                    .append(monto_txn)
                    .append("|")
                    .append(rrn)
                    .append("|")
                    .append(no_autorizacion)
                    .append("\n");//SAlto de línea para el final del registro
            registros.add(sb.toString());
        }
        return registros;
    }
}

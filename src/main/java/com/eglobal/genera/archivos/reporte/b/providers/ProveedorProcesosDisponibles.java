/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.providers;


import com.eglobal.genera.archivos.reporte.b.constructores.ConstructorArchivosReporteB;
import com.eglobal.genera.archivos.reporte.b.constructores.ConstructorArchivosReporteBATM;
import com.eglobal.genera.archivos.reporte.b.constructores.ConstructorArchivosReporteBPOS;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author egldt1134
 */
public class ProveedorProcesosDisponibles {
    public Map<Integer,ConstructorArchivosReporteB> provide(){
        Map<Integer,ConstructorArchivosReporteB> map = new HashMap<>();
        ConstructorArchivosReporteB archivoPOS = new ConstructorArchivosReporteBPOS();
        map.put(1, archivoPOS);
        
        ConstructorArchivosReporteB archivoATM = new ConstructorArchivosReporteBATM();
        map.put(2, archivoATM);

        return map;
    }
}

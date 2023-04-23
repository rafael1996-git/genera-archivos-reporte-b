/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.constructores.excepctions;

/**
 *
 * @author egldt1134
 */
public class GeneraArchivosReporteBException extends RuntimeException{
    
    public GeneraArchivosReporteBException() {
        super();
    }

    public GeneraArchivosReporteBException(String arg0, Throwable arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    public GeneraArchivosReporteBException(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    public GeneraArchivosReporteBException(Throwable arg0) {
        super(arg0);
    }
    
}
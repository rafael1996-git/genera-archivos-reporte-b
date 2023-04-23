/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.providers;

import com.eglobal.genera.archivos.reporte.b.constructores.excepctions.GeneraArchivosReporteBException;

/**
 *
 * @author egldt1134
 * @param <T>
 * @param <U>
 */
public interface Provider <T,U>{
    public T provide(U param) throws GeneraArchivosReporteBException;
}

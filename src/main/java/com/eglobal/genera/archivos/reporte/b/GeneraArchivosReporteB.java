/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b;

import com.eglobal.genera.archivos.reporte.b.constructores.ConstructorArchivosReporteB;
import com.eglobal.genera.archivos.reporte.b.providers.ProveedorProcesosDisponibles;
import com.eglobal.reporte.b.commons.providers.PathsProjectProvider;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

/**
 *
 * @author egldt1134
 */
public class GeneraArchivosReporteB {

    static {
        Configurator.initialize(null, PathsProjectProvider.getConf().getHomeConfBatch() + "log4j2.properties");
    }
    private static final Logger LOG = LogManager.getLogger(GeneraArchivosReporteB.class);

    public static void main(String... args) {
        if (args == null || args.length < 1) {
            LOG.error("No se han especificado parametros o estan incompletos, ");
        }

        Integer proceso = null;
        proceso = new Integer(args[0]);

        Map<Integer, ConstructorArchivosReporteB> map = new ProveedorProcesosDisponibles().provide();
        ConstructorArchivosReporteB cra = map.get(proceso);

        if (cra == null) {
            LOG.info("El proceso solicitado no está disponible");
            LOG.info("Los códigos de procesos disponibles son los siguientes: ");
            for (Integer i : map.keySet()) {
                LOG.info("Código: " + i);
            }
            System.exit(-1);
        }
        ExecutorService executor = Executors.newFixedThreadPool(6);
        executor.execute(cra);
        executor.shutdown();

    }

}

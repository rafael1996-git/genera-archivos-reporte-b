/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author egldt1134
 */
@Embeddable
public class EmisoresAdeudoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_emisor")
    private int idEmisor;
    @Basic(optional = false)
    @Column(name = "id_institucion_bm")
    private int idInstitucionBm;
    @Basic(optional = false)
    @Column(name = "id_archivo")
    private int idArchivo;

    public EmisoresAdeudoPK() {
    }

    public EmisoresAdeudoPK(int idEmisor, int idInstitucionBm, int idArchivo) {
        this.idEmisor = idEmisor;
        this.idInstitucionBm = idInstitucionBm;
        this.idArchivo = idArchivo;
    }

    public int getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(int idEmisor) {
        this.idEmisor = idEmisor;
    }

    public int getIdInstitucionBm() {
        return idInstitucionBm;
    }

    public void setIdInstitucionBm(int idInstitucionBm) {
        this.idInstitucionBm = idInstitucionBm;
    }

    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEmisor;
        hash += (int) idInstitucionBm;
        hash += (int) idArchivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmisoresAdeudoPK)) {
            return false;
        }
        EmisoresAdeudoPK other = (EmisoresAdeudoPK) object;
        if (this.idEmisor != other.idEmisor) {
            return false;
        }
        if (this.idInstitucionBm != other.idInstitucionBm) {
            return false;
        }
        if (this.idArchivo != other.idArchivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.EmisoresAdeudoPK[ idEmisor=" + idEmisor + ", idInstitucionBm=" + idInstitucionBm + ", idArchivo=" + idArchivo + " ]";
    }
    
}

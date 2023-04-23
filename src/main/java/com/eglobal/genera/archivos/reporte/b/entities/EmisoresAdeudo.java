/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egldt1134
 */
@Entity
@Table(name = "eglobal_sicrsch.emisores_adeudo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmisoresAdeudo.findAll", query = "SELECT e FROM EmisoresAdeudo e"),
    @NamedQuery(name = "EmisoresAdeudo.findByIdEmisor", query = "SELECT e FROM EmisoresAdeudo e WHERE e.emisoresAdeudoPK.idEmisor = :idEmisor"),
    @NamedQuery(name = "EmisoresAdeudo.findByIdInstitucionBm", query = "SELECT e FROM EmisoresAdeudo e WHERE e.emisoresAdeudoPK.idInstitucionBm = :idInstitucionBm"),
    @NamedQuery(name = "EmisoresAdeudo.findByIdArchivo", query = "SELECT e FROM EmisoresAdeudo e WHERE e.emisoresAdeudoPK.idArchivo = :idArchivo")})
public class EmisoresAdeudo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmisoresAdeudoPK emisoresAdeudoPK;
    @JoinColumn(name = "id_archivo", referencedColumnName = "id_archivo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ArchivosReporteB archivosReporteB;

    public EmisoresAdeudo() {
    }

    public EmisoresAdeudo(EmisoresAdeudoPK emisoresAdeudoPK) {
        this.emisoresAdeudoPK = emisoresAdeudoPK;
    }

    public EmisoresAdeudo(int idEmisor, int idInstitucionBm, int idArchivo) {
        this.emisoresAdeudoPK = new EmisoresAdeudoPK(idEmisor, idInstitucionBm, idArchivo);
    }

    public EmisoresAdeudoPK getEmisoresAdeudoPK() {
        return emisoresAdeudoPK;
    }

    public void setEmisoresAdeudoPK(EmisoresAdeudoPK emisoresAdeudoPK) {
        this.emisoresAdeudoPK = emisoresAdeudoPK;
    }

    public ArchivosReporteB getArchivosReporteB() {
        return archivosReporteB;
    }

    public void setArchivosReporteB(ArchivosReporteB archivosReporteB) {
        this.archivosReporteB = archivosReporteB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emisoresAdeudoPK != null ? emisoresAdeudoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmisoresAdeudo)) {
            return false;
        }
        EmisoresAdeudo other = (EmisoresAdeudo) object;
        if ((this.emisoresAdeudoPK == null && other.emisoresAdeudoPK != null) || (this.emisoresAdeudoPK != null && !this.emisoresAdeudoPK.equals(other.emisoresAdeudoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.EmisoresAdeudo[ emisoresAdeudoPK=" + emisoresAdeudoPK + " ]";
    }
    
}

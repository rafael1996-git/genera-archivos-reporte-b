/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author egldt1134
 */
@Entity
@Table(name = "eglobal_sicrsch.c_estatus_archivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CEstatusArchivos.findAll", query = "SELECT c FROM CEstatusArchivos c"),
    @NamedQuery(name = "CEstatusArchivos.findByIdEstatus", query = "SELECT c FROM CEstatusArchivos c WHERE c.idEstatus = :idEstatus"),
    @NamedQuery(name = "CEstatusArchivos.findByDescripcionEstatus", query = "SELECT c FROM CEstatusArchivos c WHERE c.descripcionEstatus = :descripcionEstatus")})
public class CEstatusArchivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estatus")
    private Integer idEstatus;
    @Column(name = "descripcion_estatus")
    private String descripcionEstatus;
    @OneToMany(mappedBy = "idEstatus")
    private Collection<ArchivosReporteB> archivosReporteBCollection;

    public CEstatusArchivos() {
    }

    public CEstatusArchivos(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getDescripcionEstatus() {
        return descripcionEstatus;
    }

    public void setDescripcionEstatus(String descripcionEstatus) {
        this.descripcionEstatus = descripcionEstatus;
    }

    @XmlTransient
    public Collection<ArchivosReporteB> getArchivosReporteBCollection() {
        return archivosReporteBCollection;
    }

    public void setArchivosReporteBCollection(Collection<ArchivosReporteB> archivosReporteBCollection) {
        this.archivosReporteBCollection = archivosReporteBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatus != null ? idEstatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEstatusArchivos)) {
            return false;
        }
        CEstatusArchivos other = (CEstatusArchivos) object;
        if ((this.idEstatus == null && other.idEstatus != null) || (this.idEstatus != null && !this.idEstatus.equals(other.idEstatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.CEstatusArchivos[ idEstatus=" + idEstatus + " ]";
    }
    
}

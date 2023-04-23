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
@Table(name = "eglobal_sicrsch.c_procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProcesos.findAll", query = "SELECT c FROM CProcesos c"),
    @NamedQuery(name = "CProcesos.findByIdProceso", query = "SELECT c FROM CProcesos c WHERE c.idProceso = :idProceso"),
    @NamedQuery(name = "CProcesos.findByNombreProceso", query = "SELECT c FROM CProcesos c WHERE c.nombreProceso = :nombreProceso")})
public class CProcesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_proceso")
    private Integer idProceso;
    @Column(name = "nombre_proceso")
    private String nombreProceso;
    @OneToMany(mappedBy = "idProceso")
    private Collection<ResumenReporteB> resumenReporteBCollection;
    @OneToMany(mappedBy = "idProceso")
    private Collection<ArchivosReporteB> archivosReporteBCollection;

    public CProcesos() {
    }

    public CProcesos(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    @XmlTransient
    public Collection<ResumenReporteB> getResumenReporteBCollection() {
        return resumenReporteBCollection;
    }

    public void setResumenReporteBCollection(Collection<ResumenReporteB> resumenReporteBCollection) {
        this.resumenReporteBCollection = resumenReporteBCollection;
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
        hash += (idProceso != null ? idProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProcesos)) {
            return false;
        }
        CProcesos other = (CProcesos) object;
        if ((this.idProceso == null && other.idProceso != null) || (this.idProceso != null && !this.idProceso.equals(other.idProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.CProcesos[ idProceso=" + idProceso + " ]";
    }
    
}

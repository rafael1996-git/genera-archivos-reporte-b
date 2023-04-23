/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "eglobal_sicrsch.c_marcas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CMarcas.findAll", query = "SELECT c FROM CMarcas c"),
    @NamedQuery(name = "CMarcas.findByIdMarca", query = "SELECT c FROM CMarcas c WHERE c.idMarca = :idMarca"),
    @NamedQuery(name = "CMarcas.findByNombreMarca", query = "SELECT c FROM CMarcas c WHERE c.nombreMarca = :nombreMarca"),
    @NamedQuery(name = "CMarcas.findByAcronimoArchivo", query = "SELECT c FROM CMarcas c WHERE c.acronimoArchivo = :acronimoArchivo")})
public class CMarcas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_marca")
    private Integer idMarca;
    @Column(name = "nombre_marca")
    private String nombreMarca;
    @Column(name = "acronimo_archivo")
    private String acronimoArchivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private Collection<ResumenReporteBXMarcas> resumenReporteBXMarcasCollection;

    public CMarcas() {
    }

    public CMarcas(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getAcronimoArchivo() {
        return acronimoArchivo;
    }

    public void setAcronimoArchivo(String acronimoArchivo) {
        this.acronimoArchivo = acronimoArchivo;
    }

    @XmlTransient
    public Collection<ResumenReporteBXMarcas> getResumenReporteBXMarcasCollection() {
        return resumenReporteBXMarcasCollection;
    }

    public void setResumenReporteBXMarcasCollection(Collection<ResumenReporteBXMarcas> resumenReporteBXMarcasCollection) {
        this.resumenReporteBXMarcasCollection = resumenReporteBXMarcasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CMarcas)) {
            return false;
        }
        CMarcas other = (CMarcas) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.CMarcas[ idMarca=" + idMarca + " ]";
    }
    
}

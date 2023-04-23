/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "eglobal_sicrsch.resumen_reporte_b_x_marcas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResumenReporteBXMarcas.findAll", query = "SELECT r FROM ResumenReporteBXMarcas r"),
    @NamedQuery(name = "ResumenReporteBXMarcas.findByIdReporteBXMarca", query = "SELECT r FROM ResumenReporteBXMarcas r WHERE r.idReporteBXMarca = :idReporteBXMarca"),
    @NamedQuery(name = "ResumenReporteBXMarcas.findByTotalTxnInt", query = "SELECT r FROM ResumenReporteBXMarcas r WHERE r.totalTxnInt = :totalTxnInt"),
    @NamedQuery(name = "ResumenReporteBXMarcas.findByMontoTotalTxnInt", query = "SELECT r FROM ResumenReporteBXMarcas r WHERE r.montoTotalTxnInt = :montoTotalTxnInt")})
public class ResumenReporteBXMarcas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reporte_b_x_marca")
    private Integer idReporteBXMarca;
    @Column(name = "total_txn_int")
    private Integer totalTxnInt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_total_txn_int")
    private BigDecimal montoTotalTxnInt;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private CMarcas idMarca;
    @JoinColumn(name = "id_registro", referencedColumnName = "id_registro")
    @ManyToOne(optional = false)
    private ResumenReporteB idRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resumenReporteBXMarcas")
    private Collection<ResumenReporteBXAdquirente> resumenReporteBXAdquirenteCollection;

    public ResumenReporteBXMarcas() {
    }

    public ResumenReporteBXMarcas(Integer idReporteBXMarca) {
        this.idReporteBXMarca = idReporteBXMarca;
    }

    public Integer getIdReporteBXMarca() {
        return idReporteBXMarca;
    }

    public void setIdReporteBXMarca(Integer idReporteBXMarca) {
        this.idReporteBXMarca = idReporteBXMarca;
    }

    public Integer getTotalTxnInt() {
        return totalTxnInt;
    }

    public void setTotalTxnInt(Integer totalTxnInt) {
        this.totalTxnInt = totalTxnInt;
    }

    public BigDecimal getMontoTotalTxnInt() {
        return montoTotalTxnInt;
    }

    public void setMontoTotalTxnInt(BigDecimal montoTotalTxnInt) {
        this.montoTotalTxnInt = montoTotalTxnInt;
    }

    public CMarcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(CMarcas idMarca) {
        this.idMarca = idMarca;
    }

    public ResumenReporteB getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(ResumenReporteB idRegistro) {
        this.idRegistro = idRegistro;
    }

    @XmlTransient
    public Collection<ResumenReporteBXAdquirente> getResumenReporteBXAdquirenteCollection() {
        return resumenReporteBXAdquirenteCollection;
    }

    public void setResumenReporteBXAdquirenteCollection(Collection<ResumenReporteBXAdquirente> resumenReporteBXAdquirenteCollection) {
        this.resumenReporteBXAdquirenteCollection = resumenReporteBXAdquirenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporteBXMarca != null ? idReporteBXMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenReporteBXMarcas)) {
            return false;
        }
        ResumenReporteBXMarcas other = (ResumenReporteBXMarcas) object;
        if ((this.idReporteBXMarca == null && other.idReporteBXMarca != null) || (this.idReporteBXMarca != null && !this.idReporteBXMarca.equals(other.idReporteBXMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.ResumenReporteBXMarcas[ idReporteBXMarca=" + idReporteBXMarca + " ]";
    }
    
}

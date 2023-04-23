/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
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
@Table(name = "eglobal_sicrsch.resumen_reporte_b_x_adquirente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResumenReporteBXAdquirente.findAll", query = "SELECT r FROM ResumenReporteBXAdquirente r"),
    @NamedQuery(name = "ResumenReporteBXAdquirente.findByIdReporteBXMarca", query = "SELECT r FROM ResumenReporteBXAdquirente r WHERE r.resumenReporteBXAdquirentePK.idReporteBXMarca = :idReporteBXMarca"),
    @NamedQuery(name = "ResumenReporteBXAdquirente.findByIdAdquirente", query = "SELECT r FROM ResumenReporteBXAdquirente r WHERE r.resumenReporteBXAdquirentePK.idAdquirente = :idAdquirente"),
    @NamedQuery(name = "ResumenReporteBXAdquirente.findByNombreAdquirente", query = "SELECT r FROM ResumenReporteBXAdquirente r WHERE r.nombreAdquirente = :nombreAdquirente"),
    @NamedQuery(name = "ResumenReporteBXAdquirente.findByTotalTxnInt", query = "SELECT r FROM ResumenReporteBXAdquirente r WHERE r.totalTxnInt = :totalTxnInt"),
    @NamedQuery(name = "ResumenReporteBXAdquirente.findByMontoTotalTxnInt", query = "SELECT r FROM ResumenReporteBXAdquirente r WHERE r.montoTotalTxnInt = :montoTotalTxnInt")})
public class ResumenReporteBXAdquirente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResumenReporteBXAdquirentePK resumenReporteBXAdquirentePK;
    @Column(name = "nombre_adquirente")
    private String nombreAdquirente;
    @Column(name = "total_txn_int")
    private Integer totalTxnInt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_total_txn_int")
    private BigDecimal montoTotalTxnInt;
    @JoinColumn(name = "id_reporte_b_x_marca", referencedColumnName = "id_reporte_b_x_marca", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ResumenReporteBXMarcas resumenReporteBXMarcas;

    public ResumenReporteBXAdquirente() {
    }

    public ResumenReporteBXAdquirente(ResumenReporteBXAdquirentePK resumenReporteBXAdquirentePK) {
        this.resumenReporteBXAdquirentePK = resumenReporteBXAdquirentePK;
    }

    public ResumenReporteBXAdquirente(int idReporteBXMarca, int idAdquirente) {
        this.resumenReporteBXAdquirentePK = new ResumenReporteBXAdquirentePK(idReporteBXMarca, idAdquirente);
    }

    public ResumenReporteBXAdquirentePK getResumenReporteBXAdquirentePK() {
        return resumenReporteBXAdquirentePK;
    }

    public void setResumenReporteBXAdquirentePK(ResumenReporteBXAdquirentePK resumenReporteBXAdquirentePK) {
        this.resumenReporteBXAdquirentePK = resumenReporteBXAdquirentePK;
    }

    public String getNombreAdquirente() {
        return nombreAdquirente;
    }

    public void setNombreAdquirente(String nombreAdquirente) {
        this.nombreAdquirente = nombreAdquirente;
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

    public ResumenReporteBXMarcas getResumenReporteBXMarcas() {
        return resumenReporteBXMarcas;
    }

    public void setResumenReporteBXMarcas(ResumenReporteBXMarcas resumenReporteBXMarcas) {
        this.resumenReporteBXMarcas = resumenReporteBXMarcas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resumenReporteBXAdquirentePK != null ? resumenReporteBXAdquirentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenReporteBXAdquirente)) {
            return false;
        }
        ResumenReporteBXAdquirente other = (ResumenReporteBXAdquirente) object;
        if ((this.resumenReporteBXAdquirentePK == null && other.resumenReporteBXAdquirentePK != null) || (this.resumenReporteBXAdquirentePK != null && !this.resumenReporteBXAdquirentePK.equals(other.resumenReporteBXAdquirentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.ResumenReporteBXAdquirente[ resumenReporteBXAdquirentePK=" + resumenReporteBXAdquirentePK + " ]";
    }
    
}

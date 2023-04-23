/*
 * Este código fuente es Confidencial y también puede contener información privilegiada, es para uso exclusivo de E-Global.
 * Tenga en cuenta que cualquier distribución, copia o uso de esta información sin autorización está estrictamente prohibida.
 * Si ha identificado algún mal uso de este código fuente por favor notifiquelo a la dirección de correo seginfo@eglobal.com.mx
 */
package com.eglobal.genera.archivos.reporte.b.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author egldt1134
 */
@Entity
@Table(name = "eglobal_sicrsch.resumen_reporte_b")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResumenReporteB.findAll", query = "SELECT r FROM ResumenReporteB r"),
    @NamedQuery(name = "ResumenReporteB.findByIdRegistro", query = "SELECT r FROM ResumenReporteB r WHERE r.idRegistro = :idRegistro"),
    @NamedQuery(name = "ResumenReporteB.findByFechaProceso", query = "SELECT r FROM ResumenReporteB r WHERE r.fechaProceso = :fechaProceso"),
    @NamedQuery(name = "ResumenReporteB.findByIdEmisor", query = "SELECT r FROM ResumenReporteB r WHERE r.idEmisor = :idEmisor"),
    @NamedQuery(name = "ResumenReporteB.findByDescEmisor", query = "SELECT r FROM ResumenReporteB r WHERE r.descEmisor = :descEmisor"),
    @NamedQuery(name = "ResumenReporteB.findByIdInstitucionBm", query = "SELECT r FROM ResumenReporteB r WHERE r.idInstitucionBm = :idInstitucionBm"),
    @NamedQuery(name = "ResumenReporteB.findByDescIntitucionBm", query = "SELECT r FROM ResumenReporteB r WHERE r.descIntitucionBm = :descIntitucionBm"),
    @NamedQuery(name = "ResumenReporteB.findByTotalTxnInt", query = "SELECT r FROM ResumenReporteB r WHERE r.totalTxnInt = :totalTxnInt"),
    @NamedQuery(name = "ResumenReporteB.findByMontoTotalTxnInt", query = "SELECT r FROM ResumenReporteB r WHERE r.montoTotalTxnInt = :montoTotalTxnInt"),
    @NamedQuery(name = "ResumenReporteB.findByTotalTxnCaratula", query = "SELECT r FROM ResumenReporteB r WHERE r.totalTxnCaratula = :totalTxnCaratula"),
    @NamedQuery(name = "ResumenReporteB.findByMontoTotalTxnCaratula", query = "SELECT r FROM ResumenReporteB r WHERE r.montoTotalTxnCaratula = :montoTotalTxnCaratula"),
    @NamedQuery(name = "ResumenReporteB.findByTxnIntVsCarat", query = "SELECT r FROM ResumenReporteB r WHERE r.txnIntVsCarat = :txnIntVsCarat"),
    @NamedQuery(name = "ResumenReporteB.findByMontoIntVsCarat", query = "SELECT r FROM ResumenReporteB r WHERE r.montoIntVsCarat = :montoIntVsCarat"),
    @NamedQuery(name = "ResumenReporteB.findBySubafiliado", query = "SELECT r FROM ResumenReporteB r WHERE r.subafiliado = :subafiliado"),
    @NamedQuery(name = "ResumenReporteB.findByDisponible", query = "SELECT r FROM ResumenReporteB r WHERE r.disponible = :disponible"),
    @NamedQuery(name = "ResumenReporteB.findByFechaProcesoAndProceso", query = "SELECT r FROM ResumenReporteB r WHERE r.fechaProceso = :fechaProceso and r.idProceso.idProceso = :idProceso")})
public class ResumenReporteB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_registro")
    private Integer idRegistro;
    @Column(name = "fecha_proceso")
    @Temporal(TemporalType.DATE)
    private Date fechaProceso;
    @Column(name = "id_emisor")
    private Integer idEmisor;
    @Column(name = "desc_emisor")
    private String descEmisor;
    @Column(name = "id_institucion_bm")
    private Integer idInstitucionBm;
    @Column(name = "desc_intitucion_bm")
    private String descIntitucionBm;
    @Column(name = "total_txn_int")
    private Integer totalTxnInt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_total_txn_int")
    private BigDecimal montoTotalTxnInt;
    @Column(name = "total_txn_caratula")
    private Integer totalTxnCaratula;
    @Column(name = "monto_total_txn_caratula")
    private BigDecimal montoTotalTxnCaratula;
    @Column(name = "txn_int_vs_carat")
    private Integer txnIntVsCarat;
    @Column(name = "monto_int_vs_carat")
    private BigDecimal montoIntVsCarat;
    @Column(name = "subafiliado")
    private Boolean subafiliado;
    @Column(name = "disponible")
    private Boolean disponible;
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    @ManyToOne
    private CProcesos idProceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegistro")
    private Collection<ResumenReporteBXMarcas> resumenReporteBXMarcasCollection;

    public ResumenReporteB() {
    }

    public ResumenReporteB(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public Integer getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(Integer idEmisor) {
        this.idEmisor = idEmisor;
    }

    public String getDescEmisor() {
        return descEmisor;
    }

    public void setDescEmisor(String descEmisor) {
        this.descEmisor = descEmisor;
    }

    public Integer getIdInstitucionBm() {
        return idInstitucionBm;
    }

    public void setIdInstitucionBm(Integer idInstitucionBm) {
        this.idInstitucionBm = idInstitucionBm;
    }

    public String getDescIntitucionBm() {
        return descIntitucionBm;
    }

    public void setDescIntitucionBm(String descIntitucionBm) {
        this.descIntitucionBm = descIntitucionBm;
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

    public Integer getTotalTxnCaratula() {
        return totalTxnCaratula;
    }

    public void setTotalTxnCaratula(Integer totalTxnCaratula) {
        this.totalTxnCaratula = totalTxnCaratula;
    }

    public BigDecimal getMontoTotalTxnCaratula() {
        return montoTotalTxnCaratula;
    }

    public void setMontoTotalTxnCaratula(BigDecimal montoTotalTxnCaratula) {
        this.montoTotalTxnCaratula = montoTotalTxnCaratula;
    }

    public Integer getTxnIntVsCarat() {
        return txnIntVsCarat;
    }

    public void setTxnIntVsCarat(Integer txnIntVsCarat) {
        this.txnIntVsCarat = txnIntVsCarat;
    }

    public BigDecimal getMontoIntVsCarat() {
        return montoIntVsCarat;
    }

    public void setMontoIntVsCarat(BigDecimal montoIntVsCarat) {
        this.montoIntVsCarat = montoIntVsCarat;
    }

    public Boolean getSubafiliado() {
        return subafiliado;
    }

    public void setSubafiliado(Boolean subafiliado) {
        this.subafiliado = subafiliado;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public CProcesos getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(CProcesos idProceso) {
        this.idProceso = idProceso;
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
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenReporteB)) {
            return false;
        }
        ResumenReporteB other = (ResumenReporteB) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.ResumenReporteB[ idRegistro=" + idRegistro + " ]";
    }
    
}

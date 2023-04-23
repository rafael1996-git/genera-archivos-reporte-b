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
@Table(name = "eglobal_sicrsch.archivos_reporte_b")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivosReporteB.findAll", query = "SELECT a FROM ArchivosReporteB a"),
    @NamedQuery(name = "ArchivosReporteB.findByIdArchivo", query = "SELECT a FROM ArchivosReporteB a WHERE a.idArchivo = :idArchivo"),
    @NamedQuery(name = "ArchivosReporteB.findByFechaInicialRango", query = "SELECT a FROM ArchivosReporteB a WHERE a.fechaInicialRango = :fechaInicialRango"),
    @NamedQuery(name = "ArchivosReporteB.findByFechaFinalRango", query = "SELECT a FROM ArchivosReporteB a WHERE a.fechaFinalRango = :fechaFinalRango"),
    @NamedQuery(name = "ArchivosReporteB.findByFechaGeneracion", query = "SELECT a FROM ArchivosReporteB a WHERE a.fechaGeneracion = :fechaGeneracion"),
    @NamedQuery(name = "ArchivosReporteB.findByFechaInicioProceso", query = "SELECT a FROM ArchivosReporteB a WHERE a.fechaInicioProceso = :fechaInicioProceso"),
    @NamedQuery(name = "ArchivosReporteB.findByFechaFinProceso", query = "SELECT a FROM ArchivosReporteB a WHERE a.fechaFinProceso = :fechaFinProceso"),
    @NamedQuery(name = "ArchivosReporteB.findByNombreArchivo", query = "SELECT a FROM ArchivosReporteB a WHERE a.nombreArchivo = :nombreArchivo"),
    @NamedQuery(name = "ArchivosReporteB.findByTotalTxnInt", query = "SELECT a FROM ArchivosReporteB a WHERE a.totalTxnInt = :totalTxnInt"),
    @NamedQuery(name = "ArchivosReporteB.findByMontoTotalTxn", query = "SELECT a FROM ArchivosReporteB a WHERE a.montoTotalTxn = :montoTotalTxn")})
public class ArchivosReporteB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_archivo")
    private Integer idArchivo;
    @Column(name = "fecha_inicial_rango")
    @Temporal(TemporalType.DATE)
    private Date fechaInicialRango;
    @Column(name = "fecha_final_rango")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalRango;
    @Column(name = "fecha_generacion")
    @Temporal(TemporalType.DATE)
    private Date fechaGeneracion;
    @Column(name = "fecha_inicio_proceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioProceso;
    @Column(name = "fecha_fin_proceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinProceso;
    @Column(name = "nombre_archivo")
    private String nombreArchivo;
    @Column(name = "total_txn_int")
    private Integer totalTxnInt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_total_txn")
    private BigDecimal montoTotalTxn;
    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
    @ManyToOne
    private CEstatusArchivos idEstatus;
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    @ManyToOne
    private CProcesos idProceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "archivosReporteB")
    private Collection<EmisoresAdeudo> emisoresAdeudoCollection;

    public ArchivosReporteB() {
    }

    public ArchivosReporteB(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Date getFechaInicialRango() {
        return fechaInicialRango;
    }

    public void setFechaInicialRango(Date fechaInicialRango) {
        this.fechaInicialRango = fechaInicialRango;
    }

    public Date getFechaFinalRango() {
        return fechaFinalRango;
    }

    public void setFechaFinalRango(Date fechaFinalRango) {
        this.fechaFinalRango = fechaFinalRango;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Date getFechaInicioProceso() {
        return fechaInicioProceso;
    }

    public void setFechaInicioProceso(Date fechaInicioProceso) {
        this.fechaInicioProceso = fechaInicioProceso;
    }

    public Date getFechaFinProceso() {
        return fechaFinProceso;
    }

    public void setFechaFinProceso(Date fechaFinProceso) {
        this.fechaFinProceso = fechaFinProceso;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Integer getTotalTxnInt() {
        return totalTxnInt;
    }

    public void setTotalTxnInt(Integer totalTxnInt) {
        this.totalTxnInt = totalTxnInt;
    }

    public BigDecimal getMontoTotalTxn() {
        return montoTotalTxn;
    }

    public void setMontoTotalTxn(BigDecimal montoTotalTxn) {
        this.montoTotalTxn = montoTotalTxn;
    }

    public CEstatusArchivos getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(CEstatusArchivos idEstatus) {
        this.idEstatus = idEstatus;
    }

    public CProcesos getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(CProcesos idProceso) {
        this.idProceso = idProceso;
    }

    @XmlTransient
    public Collection<EmisoresAdeudo> getEmisoresAdeudoCollection() {
        return emisoresAdeudoCollection;
    }

    public void setEmisoresAdeudoCollection(Collection<EmisoresAdeudo> emisoresAdeudoCollection) {
        this.emisoresAdeudoCollection = emisoresAdeudoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchivo != null ? idArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivosReporteB)) {
            return false;
        }
        ArchivosReporteB other = (ArchivosReporteB) object;
        if ((this.idArchivo == null && other.idArchivo != null) || (this.idArchivo != null && !this.idArchivo.equals(other.idArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.ArchivosReporteB[ idArchivo=" + idArchivo + " ]";
    }
    
}

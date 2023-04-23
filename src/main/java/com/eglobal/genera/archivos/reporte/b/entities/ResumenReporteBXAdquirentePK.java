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
public class ResumenReporteBXAdquirentePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_reporte_b_x_marca")
    private int idReporteBXMarca;
    @Basic(optional = false)
    @Column(name = "id_adquirente")
    private int idAdquirente;

    public ResumenReporteBXAdquirentePK() {
    }

    public ResumenReporteBXAdquirentePK(int idReporteBXMarca, int idAdquirente) {
        this.idReporteBXMarca = idReporteBXMarca;
        this.idAdquirente = idAdquirente;
    }

    public int getIdReporteBXMarca() {
        return idReporteBXMarca;
    }

    public void setIdReporteBXMarca(int idReporteBXMarca) {
        this.idReporteBXMarca = idReporteBXMarca;
    }

    public int getIdAdquirente() {
        return idAdquirente;
    }

    public void setIdAdquirente(int idAdquirente) {
        this.idAdquirente = idAdquirente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idReporteBXMarca;
        hash += (int) idAdquirente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenReporteBXAdquirentePK)) {
            return false;
        }
        ResumenReporteBXAdquirentePK other = (ResumenReporteBXAdquirentePK) object;
        if (this.idReporteBXMarca != other.idReporteBXMarca) {
            return false;
        }
        if (this.idAdquirente != other.idAdquirente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eglobal.genera.resumen.reporte.b.entities.ResumenReporteBXAdquirentePK[ idReporteBXMarca=" + idReporteBXMarca + ", idAdquirente=" + idAdquirente + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario 9
 */
@Entity
@Table(name = "detalle_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByIddetalleFactura", query = "SELECT d FROM DetalleFactura d WHERE d.iddetalleFactura = :iddetalleFactura"),
    @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle_factura")
    private Integer iddetalleFactura;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "servicios_idservicios", referencedColumnName = "idservicios")
    @ManyToOne(optional = false)
    private Servicios serviciosIdservicios;
    @JoinColumn(name = "reservacion_idreservacion", referencedColumnName = "idreservacion")
    @ManyToOne(optional = false)
    private Reservacion reservacionIdreservacion;
    @JoinColumn(name = "cabecera_factura_idcabecera_factura", referencedColumnName = "idcabecera_factura")
    @ManyToOne
    private CabeceraFactura cabeceraFacturaIdcabeceraFactura;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer iddetalleFactura) {
        this.iddetalleFactura = iddetalleFactura;
    }

    public Integer getIddetalleFactura() {
        return iddetalleFactura;
    }

    public void setIddetalleFactura(Integer iddetalleFactura) {
        this.iddetalleFactura = iddetalleFactura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Servicios getServiciosIdservicios() {
        return serviciosIdservicios;
    }

    public void setServiciosIdservicios(Servicios serviciosIdservicios) {
        this.serviciosIdservicios = serviciosIdservicios;
    }

    public Reservacion getReservacionIdreservacion() {
        return reservacionIdreservacion;
    }

    public void setReservacionIdreservacion(Reservacion reservacionIdreservacion) {
        this.reservacionIdreservacion = reservacionIdreservacion;
    }

    public CabeceraFactura getCabeceraFacturaIdcabeceraFactura() {
        return cabeceraFacturaIdcabeceraFactura;
    }

    public void setCabeceraFacturaIdcabeceraFactura(CabeceraFactura cabeceraFacturaIdcabeceraFactura) {
        this.cabeceraFacturaIdcabeceraFactura = cabeceraFacturaIdcabeceraFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleFactura != null ? iddetalleFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.iddetalleFactura == null && other.iddetalleFactura != null) || (this.iddetalleFactura != null && !this.iddetalleFactura.equals(other.iddetalleFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleFactura[ iddetalleFactura=" + iddetalleFactura + " ]";
    }
    
}

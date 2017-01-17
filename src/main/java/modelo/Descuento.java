/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario 9
 */
@Entity
@Table(name = "descuento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d"),
    @NamedQuery(name = "Descuento.findByIddescuento", query = "SELECT d FROM Descuento d WHERE d.iddescuento = :iddescuento"),
    @NamedQuery(name = "Descuento.findByNombre", query = "SELECT d FROM Descuento d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Descuento.findByPorcentaje", query = "SELECT d FROM Descuento d WHERE d.porcentaje = :porcentaje")})
public class Descuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddescuento")
    private Integer iddescuento;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Float porcentaje;
    @OneToMany(mappedBy = "descuentoIddescuento")
    private List<CabeceraFactura> cabeceraFacturaList;

    public Descuento() {
    }

    public Descuento(Integer iddescuento) {
        this.iddescuento = iddescuento;
    }

    public Integer getIddescuento() {
        return iddescuento;
    }

    public void setIddescuento(Integer iddescuento) {
        this.iddescuento = iddescuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    @XmlTransient
    public List<CabeceraFactura> getCabeceraFacturaList() {
        return cabeceraFacturaList;
    }

    public void setCabeceraFacturaList(List<CabeceraFactura> cabeceraFacturaList) {
        this.cabeceraFacturaList = cabeceraFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddescuento != null ? iddescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.iddescuento == null && other.iddescuento != null) || (this.iddescuento != null && !this.iddescuento.equals(other.iddescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Descuento[ iddescuento=" + iddescuento + " ]";
    }
    
}

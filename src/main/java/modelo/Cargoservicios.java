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
@Table(name = "cargoservicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargoservicios.findAll", query = "SELECT c FROM Cargoservicios c"),
    @NamedQuery(name = "Cargoservicios.findByIdcargoservicios", query = "SELECT c FROM Cargoservicios c WHERE c.idcargoservicios = :idcargoservicios"),
    @NamedQuery(name = "Cargoservicios.findByNombre", query = "SELECT c FROM Cargoservicios c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cargoservicios.findByPorcentaje", query = "SELECT c FROM Cargoservicios c WHERE c.porcentaje = :porcentaje")})
public class Cargoservicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcargoservicios")
    private Integer idcargoservicios;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Float porcentaje;
    @OneToMany(mappedBy = "cargoserviciosIdcargoservicios")
    private List<CabeceraFactura> cabeceraFacturaList;

    public Cargoservicios() {
    }

    public Cargoservicios(Integer idcargoservicios) {
        this.idcargoservicios = idcargoservicios;
    }

    public Integer getIdcargoservicios() {
        return idcargoservicios;
    }

    public void setIdcargoservicios(Integer idcargoservicios) {
        this.idcargoservicios = idcargoservicios;
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
        hash += (idcargoservicios != null ? idcargoservicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargoservicios)) {
            return false;
        }
        Cargoservicios other = (Cargoservicios) object;
        if ((this.idcargoservicios == null && other.idcargoservicios != null) || (this.idcargoservicios != null && !this.idcargoservicios.equals(other.idcargoservicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cargoservicios[ idcargoservicios=" + idcargoservicios + " ]";
    }
    
}

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
@Table(name = "impuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impuesto.findAll", query = "SELECT i FROM Impuesto i"),
    @NamedQuery(name = "Impuesto.findByIdimpuesto", query = "SELECT i FROM Impuesto i WHERE i.idimpuesto = :idimpuesto"),
    @NamedQuery(name = "Impuesto.findByNombre", query = "SELECT i FROM Impuesto i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Impuesto.findByPorcentaje", query = "SELECT i FROM Impuesto i WHERE i.porcentaje = :porcentaje")})
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idimpuesto")
    private Integer idimpuesto;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Float porcentaje;
    @OneToMany(mappedBy = "impuestoIdimpuesto")
    private List<CabeceraFactura> cabeceraFacturaList;

    public Impuesto() {
    }

    public Impuesto(Integer idimpuesto) {
        this.idimpuesto = idimpuesto;
    }

    public Integer getIdimpuesto() {
        return idimpuesto;
    }

    public void setIdimpuesto(Integer idimpuesto) {
        this.idimpuesto = idimpuesto;
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
        hash += (idimpuesto != null ? idimpuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impuesto)) {
            return false;
        }
        Impuesto other = (Impuesto) object;
        if ((this.idimpuesto == null && other.idimpuesto != null) || (this.idimpuesto != null && !this.idimpuesto.equals(other.idimpuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Impuesto[ idimpuesto=" + idimpuesto + " ]";
    }
    
}

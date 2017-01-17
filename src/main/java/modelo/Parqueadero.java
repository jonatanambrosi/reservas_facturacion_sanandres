/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario 9
 */
@Entity
@Table(name = "parqueadero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parqueadero.findAll", query = "SELECT p FROM Parqueadero p"),
    @NamedQuery(name = "Parqueadero.findByIdparqueadero", query = "SELECT p FROM Parqueadero p WHERE p.idparqueadero = :idparqueadero"),
    @NamedQuery(name = "Parqueadero.findByNombre", query = "SELECT p FROM Parqueadero p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Parqueadero.findByDescripcion", query = "SELECT p FROM Parqueadero p WHERE p.descripcion = :descripcion")})
public class Parqueadero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idparqueadero")
    private Integer idparqueadero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parqueaderoIdparqueadero")
    private List<Reservacion> reservacionList;

    public Parqueadero() {
    }

    public Parqueadero(Integer idparqueadero) {
        this.idparqueadero = idparqueadero;
    }

    public Parqueadero(Integer idparqueadero, String nombre) {
        this.idparqueadero = idparqueadero;
        this.nombre = nombre;
    }

    public Integer getIdparqueadero() {
        return idparqueadero;
    }

    public void setIdparqueadero(Integer idparqueadero) {
        this.idparqueadero = idparqueadero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparqueadero != null ? idparqueadero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parqueadero)) {
            return false;
        }
        Parqueadero other = (Parqueadero) object;
        if ((this.idparqueadero == null && other.idparqueadero != null) || (this.idparqueadero != null && !this.idparqueadero.equals(other.idparqueadero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Parqueadero[ idparqueadero=" + idparqueadero + " ]";
    }
    
}

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
@Table(name = "estadoreservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoreservacion.findAll", query = "SELECT e FROM Estadoreservacion e"),
    @NamedQuery(name = "Estadoreservacion.findByIdestadoreservacion", query = "SELECT e FROM Estadoreservacion e WHERE e.idestadoreservacion = :idestadoreservacion"),
    @NamedQuery(name = "Estadoreservacion.findByNombre", query = "SELECT e FROM Estadoreservacion e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estadoreservacion.findByDescripcion", query = "SELECT e FROM Estadoreservacion e WHERE e.descripcion = :descripcion")})
public class Estadoreservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadoreservacion")
    private Integer idestadoreservacion;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoreservacionIdestadoreservacion")
    private List<Reservacion> reservacionList;

    public Estadoreservacion() {
    }

    public Estadoreservacion(Integer idestadoreservacion) {
        this.idestadoreservacion = idestadoreservacion;
    }

    public Integer getIdestadoreservacion() {
        return idestadoreservacion;
    }

    public void setIdestadoreservacion(Integer idestadoreservacion) {
        this.idestadoreservacion = idestadoreservacion;
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
        hash += (idestadoreservacion != null ? idestadoreservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoreservacion)) {
            return false;
        }
        Estadoreservacion other = (Estadoreservacion) object;
        if ((this.idestadoreservacion == null && other.idestadoreservacion != null) || (this.idestadoreservacion != null && !this.idestadoreservacion.equals(other.idestadoreservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estadoreservacion[ idestadoreservacion=" + idestadoreservacion + " ]";
    }
    
}

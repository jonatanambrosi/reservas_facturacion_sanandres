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
@Table(name = "estado_habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoHabitacion.findAll", query = "SELECT e FROM EstadoHabitacion e"),
    @NamedQuery(name = "EstadoHabitacion.findByIdestadoHabitacion", query = "SELECT e FROM EstadoHabitacion e WHERE e.idestadoHabitacion = :idestadoHabitacion"),
    @NamedQuery(name = "EstadoHabitacion.findByEstado", query = "SELECT e FROM EstadoHabitacion e WHERE e.estado = :estado"),
    @NamedQuery(name = "EstadoHabitacion.findByDescripcion", query = "SELECT e FROM EstadoHabitacion e WHERE e.descripcion = :descripcion")})
public class EstadoHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestado_habitacion")
    private Integer idestadoHabitacion;
    @Size(max = 50)
    @Column(name = "estado")
    private String estado;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "estadoHabitacionIdestadoHabitacion")
    private List<Habitacion> habitacionList;

    public EstadoHabitacion() {
    }

    public EstadoHabitacion(Integer idestadoHabitacion) {
        this.idestadoHabitacion = idestadoHabitacion;
    }

    public Integer getIdestadoHabitacion() {
        return idestadoHabitacion;
    }

    public void setIdestadoHabitacion(Integer idestadoHabitacion) {
        this.idestadoHabitacion = idestadoHabitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Habitacion> getHabitacionList() {
        return habitacionList;
    }

    public void setHabitacionList(List<Habitacion> habitacionList) {
        this.habitacionList = habitacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoHabitacion != null ? idestadoHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoHabitacion)) {
            return false;
        }
        EstadoHabitacion other = (EstadoHabitacion) object;
        if ((this.idestadoHabitacion == null && other.idestadoHabitacion != null) || (this.idestadoHabitacion != null && !this.idestadoHabitacion.equals(other.idestadoHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstadoHabitacion[ idestadoHabitacion=" + idestadoHabitacion + " ]";
    }
    
}

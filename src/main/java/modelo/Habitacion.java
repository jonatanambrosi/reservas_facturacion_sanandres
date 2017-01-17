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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h"),
    @NamedQuery(name = "Habitacion.findByIdhabitacion", query = "SELECT h FROM Habitacion h WHERE h.idhabitacion = :idhabitacion"),
    @NamedQuery(name = "Habitacion.findByNumero", query = "SELECT h FROM Habitacion h WHERE h.numero = :numero"),
    @NamedQuery(name = "Habitacion.findByDescripcion", query = "SELECT h FROM Habitacion h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "Habitacion.findByEstado", query = "SELECT h FROM Habitacion h WHERE h.estado = :estado"),
    @NamedQuery(name = "Habitacion.findByPrecio", query = "SELECT h FROM Habitacion h WHERE h.precio = :precio")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhabitacion")
    private Integer idhabitacion;
    @Size(max = 50)
    @Column(name = "numero")
    private String numero;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitacion")
    private List<HabitacionHasReservacion> habitacionHasReservacionList;
    @JoinColumn(name = "tipo_habitacion_idtipo_habitacion", referencedColumnName = "idtipo_habitacion")
    @ManyToOne
    private TipoHabitacion tipoHabitacionIdtipoHabitacion;
    @JoinColumn(name = "estado_habitacion_idestado_habitacion", referencedColumnName = "idestado_habitacion")
    @ManyToOne
    private EstadoHabitacion estadoHabitacionIdestadoHabitacion;

    public Habitacion() {
    }

    public Habitacion(Integer idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public Integer getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(Integer idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<HabitacionHasReservacion> getHabitacionHasReservacionList() {
        return habitacionHasReservacionList;
    }

    public void setHabitacionHasReservacionList(List<HabitacionHasReservacion> habitacionHasReservacionList) {
        this.habitacionHasReservacionList = habitacionHasReservacionList;
    }

    public TipoHabitacion getTipoHabitacionIdtipoHabitacion() {
        return tipoHabitacionIdtipoHabitacion;
    }

    public void setTipoHabitacionIdtipoHabitacion(TipoHabitacion tipoHabitacionIdtipoHabitacion) {
        this.tipoHabitacionIdtipoHabitacion = tipoHabitacionIdtipoHabitacion;
    }

    public EstadoHabitacion getEstadoHabitacionIdestadoHabitacion() {
        return estadoHabitacionIdestadoHabitacion;
    }

    public void setEstadoHabitacionIdestadoHabitacion(EstadoHabitacion estadoHabitacionIdestadoHabitacion) {
        this.estadoHabitacionIdestadoHabitacion = estadoHabitacionIdestadoHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhabitacion != null ? idhabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.idhabitacion == null && other.idhabitacion != null) || (this.idhabitacion != null && !this.idhabitacion.equals(other.idhabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Habitacion[ idhabitacion=" + idhabitacion + " ]";
    }
    
}

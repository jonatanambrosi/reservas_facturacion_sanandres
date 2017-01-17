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
@Table(name = "tipo_habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoHabitacion.findAll", query = "SELECT t FROM TipoHabitacion t"),
    @NamedQuery(name = "TipoHabitacion.findByIdtipoHabitacion", query = "SELECT t FROM TipoHabitacion t WHERE t.idtipoHabitacion = :idtipoHabitacion"),
    @NamedQuery(name = "TipoHabitacion.findByDescripcion", query = "SELECT t FROM TipoHabitacion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoHabitacion.findByTipo", query = "SELECT t FROM TipoHabitacion t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TipoHabitacion.findByMinimo", query = "SELECT t FROM TipoHabitacion t WHERE t.minimo = :minimo"),
    @NamedQuery(name = "TipoHabitacion.findByMaximo", query = "SELECT t FROM TipoHabitacion t WHERE t.maximo = :maximo")})
public class TipoHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_habitacion")
    private Integer idtipoHabitacion;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "minimo")
    private String minimo;
    @Size(max = 45)
    @Column(name = "maximo")
    private String maximo;
    @OneToMany(mappedBy = "tipoHabitacionIdtipoHabitacion")
    private List<Habitacion> habitacionList;

    public TipoHabitacion() {
    }

    public TipoHabitacion(Integer idtipoHabitacion) {
        this.idtipoHabitacion = idtipoHabitacion;
    }

    public Integer getIdtipoHabitacion() {
        return idtipoHabitacion;
    }

    public void setIdtipoHabitacion(Integer idtipoHabitacion) {
        this.idtipoHabitacion = idtipoHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMinimo() {
        return minimo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }

    public String getMaximo() {
        return maximo;
    }

    public void setMaximo(String maximo) {
        this.maximo = maximo;
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
        hash += (idtipoHabitacion != null ? idtipoHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHabitacion)) {
            return false;
        }
        TipoHabitacion other = (TipoHabitacion) object;
        if ((this.idtipoHabitacion == null && other.idtipoHabitacion != null) || (this.idtipoHabitacion != null && !this.idtipoHabitacion.equals(other.idtipoHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoHabitacion[ idtipoHabitacion=" + idtipoHabitacion + " ]";
    }
    
}

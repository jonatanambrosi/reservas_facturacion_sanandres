/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "habitacion_has_reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HabitacionHasReservacion.findAll", query = "SELECT h FROM HabitacionHasReservacion h"),
    @NamedQuery(name = "HabitacionHasReservacion.findByHabitacionIdhabitacion", query = "SELECT h FROM HabitacionHasReservacion h WHERE h.habitacionHasReservacionPK.habitacionIdhabitacion = :habitacionIdhabitacion"),
    @NamedQuery(name = "HabitacionHasReservacion.findByReservacionIdreservacion", query = "SELECT h FROM HabitacionHasReservacion h WHERE h.habitacionHasReservacionPK.reservacionIdreservacion = :reservacionIdreservacion"),
    @NamedQuery(name = "HabitacionHasReservacion.findByValorAcordado", query = "SELECT h FROM HabitacionHasReservacion h WHERE h.valorAcordado = :valorAcordado")})
public class HabitacionHasReservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HabitacionHasReservacionPK habitacionHasReservacionPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_acordado")
    private Float valorAcordado;
    @JoinColumn(name = "reservacion_idreservacion", referencedColumnName = "idreservacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reservacion reservacion;
    @JoinColumn(name = "habitacion_idhabitacion", referencedColumnName = "idhabitacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Habitacion habitacion;

    public HabitacionHasReservacion() {
    }

    public HabitacionHasReservacion(HabitacionHasReservacionPK habitacionHasReservacionPK) {
        this.habitacionHasReservacionPK = habitacionHasReservacionPK;
    }

    public HabitacionHasReservacion(int habitacionIdhabitacion, int reservacionIdreservacion) {
        this.habitacionHasReservacionPK = new HabitacionHasReservacionPK(habitacionIdhabitacion, reservacionIdreservacion);
    }

    public HabitacionHasReservacionPK getHabitacionHasReservacionPK() {
        return habitacionHasReservacionPK;
    }

    public void setHabitacionHasReservacionPK(HabitacionHasReservacionPK habitacionHasReservacionPK) {
        this.habitacionHasReservacionPK = habitacionHasReservacionPK;
    }

    public Float getValorAcordado() {
        return valorAcordado;
    }

    public void setValorAcordado(Float valorAcordado) {
        this.valorAcordado = valorAcordado;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (habitacionHasReservacionPK != null ? habitacionHasReservacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabitacionHasReservacion)) {
            return false;
        }
        HabitacionHasReservacion other = (HabitacionHasReservacion) object;
        if ((this.habitacionHasReservacionPK == null && other.habitacionHasReservacionPK != null) || (this.habitacionHasReservacionPK != null && !this.habitacionHasReservacionPK.equals(other.habitacionHasReservacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.HabitacionHasReservacion[ habitacionHasReservacionPK=" + habitacionHasReservacionPK + " ]";
    }
    
}

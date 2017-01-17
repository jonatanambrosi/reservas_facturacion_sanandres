/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario 9
 */
@Embeddable
public class HabitacionHasReservacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "habitacion_idhabitacion")
    private int habitacionIdhabitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reservacion_idreservacion")
    private int reservacionIdreservacion;

    public HabitacionHasReservacionPK() {
    }

    public HabitacionHasReservacionPK(int habitacionIdhabitacion, int reservacionIdreservacion) {
        this.habitacionIdhabitacion = habitacionIdhabitacion;
        this.reservacionIdreservacion = reservacionIdreservacion;
    }

    public int getHabitacionIdhabitacion() {
        return habitacionIdhabitacion;
    }

    public void setHabitacionIdhabitacion(int habitacionIdhabitacion) {
        this.habitacionIdhabitacion = habitacionIdhabitacion;
    }

    public int getReservacionIdreservacion() {
        return reservacionIdreservacion;
    }

    public void setReservacionIdreservacion(int reservacionIdreservacion) {
        this.reservacionIdreservacion = reservacionIdreservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) habitacionIdhabitacion;
        hash += (int) reservacionIdreservacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabitacionHasReservacionPK)) {
            return false;
        }
        HabitacionHasReservacionPK other = (HabitacionHasReservacionPK) object;
        if (this.habitacionIdhabitacion != other.habitacionIdhabitacion) {
            return false;
        }
        if (this.reservacionIdreservacion != other.reservacionIdreservacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.HabitacionHasReservacionPK[ habitacionIdhabitacion=" + habitacionIdhabitacion + ", reservacionIdreservacion=" + reservacionIdreservacion + " ]";
    }
    
}

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
@Table(name = "formadepago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formadepago.findAll", query = "SELECT f FROM Formadepago f"),
    @NamedQuery(name = "Formadepago.findByIdformadepago", query = "SELECT f FROM Formadepago f WHERE f.idformadepago = :idformadepago"),
    @NamedQuery(name = "Formadepago.findByDescripcion", query = "SELECT f FROM Formadepago f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "Formadepago.findByNombre", query = "SELECT f FROM Formadepago f WHERE f.nombre = :nombre")})
public class Formadepago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformadepago")
    private Integer idformadepago;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formadepagoIdformadepago")
    private List<Reservacion> reservacionList;

    public Formadepago() {
    }

    public Formadepago(Integer idformadepago) {
        this.idformadepago = idformadepago;
    }

    public Integer getIdformadepago() {
        return idformadepago;
    }

    public void setIdformadepago(Integer idformadepago) {
        this.idformadepago = idformadepago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idformadepago != null ? idformadepago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formadepago)) {
            return false;
        }
        Formadepago other = (Formadepago) object;
        if ((this.idformadepago == null && other.idformadepago != null) || (this.idformadepago != null && !this.idformadepago.equals(other.idformadepago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Formadepago[ idformadepago=" + idformadepago + " ]";
    }
    
}

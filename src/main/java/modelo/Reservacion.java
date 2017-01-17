/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario 9
 */
@Entity
@Table(name = "reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r"),
    @NamedQuery(name = "Reservacion.findByIdreservacion", query = "SELECT r FROM Reservacion r WHERE r.idreservacion = :idreservacion"),
    @NamedQuery(name = "Reservacion.findByFechaReserva", query = "SELECT r FROM Reservacion r WHERE r.fechaReserva = :fechaReserva"),
    @NamedQuery(name = "Reservacion.findByFechaEntrada", query = "SELECT r FROM Reservacion r WHERE r.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "Reservacion.findByFechaSalida", query = "SELECT r FROM Reservacion r WHERE r.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Reservacion.findByValor", query = "SELECT r FROM Reservacion r WHERE r.valor = :valor"),
    @NamedQuery(name = "Reservacion.findByObservacion", query = "SELECT r FROM Reservacion r WHERE r.observacion = :observacion"),
    @NamedQuery(name = "Reservacion.findByNumeroHuespedes", query = "SELECT r FROM Reservacion r WHERE r.numeroHuespedes = :numeroHuespedes"),
    @NamedQuery(name = "Reservacion.findByCodigoreserva", query = "SELECT r FROM Reservacion r WHERE r.codigoreserva = :codigoreserva")})
public class Reservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreservacion")
    private Integer idreservacion;
    @Column(name = "fecha_reserva")
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "numero_huespedes")
    private Integer numeroHuespedes;
    @Size(max = 50)
    @Column(name = "codigoreserva")
    private String codigoreserva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservacionIdreservacion")
    private List<DetalleFactura> detalleFacturaList;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;
    @JoinColumn(name = "parqueadero_idparqueadero", referencedColumnName = "idparqueadero")
    @ManyToOne(optional = false)
    private Parqueadero parqueaderoIdparqueadero;
    @JoinColumn(name = "formadepago_idformadepago", referencedColumnName = "idformadepago")
    @ManyToOne(optional = false)
    private Formadepago formadepagoIdformadepago;
    @JoinColumn(name = "estadoreservacion_idestadoreservacion", referencedColumnName = "idestadoreservacion")
    @ManyToOne(optional = false)
    private Estadoreservacion estadoreservacionIdestadoreservacion;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresaIdempresa;
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservacion")
    private List<HabitacionHasReservacion> habitacionHasReservacionList;

    public Reservacion() {
    }

    public Reservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Integer getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getNumeroHuespedes() {
        return numeroHuespedes;
    }

    public void setNumeroHuespedes(Integer numeroHuespedes) {
        this.numeroHuespedes = numeroHuespedes;
    }

    public String getCodigoreserva() {
        return codigoreserva;
    }

    public void setCodigoreserva(String codigoreserva) {
        this.codigoreserva = codigoreserva;
    }

    @XmlTransient
    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public Parqueadero getParqueaderoIdparqueadero() {
        return parqueaderoIdparqueadero;
    }

    public void setParqueaderoIdparqueadero(Parqueadero parqueaderoIdparqueadero) {
        this.parqueaderoIdparqueadero = parqueaderoIdparqueadero;
    }

    public Formadepago getFormadepagoIdformadepago() {
        return formadepagoIdformadepago;
    }

    public void setFormadepagoIdformadepago(Formadepago formadepagoIdformadepago) {
        this.formadepagoIdformadepago = formadepagoIdformadepago;
    }

    public Estadoreservacion getEstadoreservacionIdestadoreservacion() {
        return estadoreservacionIdestadoreservacion;
    }

    public void setEstadoreservacionIdestadoreservacion(Estadoreservacion estadoreservacionIdestadoreservacion) {
        this.estadoreservacionIdestadoreservacion = estadoreservacionIdestadoreservacion;
    }

    public Empresa getEmpresaIdempresa() {
        return empresaIdempresa;
    }

    public void setEmpresaIdempresa(Empresa empresaIdempresa) {
        this.empresaIdempresa = empresaIdempresa;
    }

    public Cliente getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(Cliente clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    @XmlTransient
    public List<HabitacionHasReservacion> getHabitacionHasReservacionList() {
        return habitacionHasReservacionList;
    }

    public void setHabitacionHasReservacionList(List<HabitacionHasReservacion> habitacionHasReservacionList) {
        this.habitacionHasReservacionList = habitacionHasReservacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservacion != null ? idreservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.idreservacion == null && other.idreservacion != null) || (this.idreservacion != null && !this.idreservacion.equals(other.idreservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Reservacion[ idreservacion=" + idreservacion + " ]";
    }
    
}

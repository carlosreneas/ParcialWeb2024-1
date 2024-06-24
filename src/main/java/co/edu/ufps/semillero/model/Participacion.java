package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the participacion database table.
 * 
 */
@Entity
@NamedQuery(name="Participacion.findAll", query="SELECT p FROM Participacion p")
public class Participacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Lob
	private String observacion;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	private Evento evento;

	//bi-directional many-to-one association to Integrante
	@ManyToOne
	private Integrante integrante;

	//bi-directional many-to-one association to Modalidad
	@ManyToOne
	private Modalidad modalidad;

	//bi-directional many-to-one association to ProductoTipo
	@ManyToOne
	@JoinColumn(name="producto_tipo_id")
	private ProductoTipo productoTipo;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	private Proyecto proyecto;

	public Participacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Integrante getIntegrante() {
		return this.integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	public Modalidad getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public ProductoTipo getProductoTipo() {
		return this.productoTipo;
	}

	public void setProductoTipo(ProductoTipo productoTipo) {
		this.productoTipo = productoTipo;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
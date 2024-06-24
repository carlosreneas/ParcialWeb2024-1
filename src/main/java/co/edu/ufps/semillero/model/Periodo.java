package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the periodo database table.
 * 
 */
@Entity
@NamedQuery(name="Periodo.findAll", query="SELECT p FROM Periodo p")
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	//bi-directional many-to-one association to Capacitacion
	@OneToMany(mappedBy="periodo")
	private List<Capacitacion> capacitacions;

	//bi-directional many-to-many association to Integrante
	@ManyToMany
	@JoinTable(
		name="inscrito"
		, joinColumns={
			@JoinColumn(name="periodo_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="integrante_id")
			}
		)
	private List<Integrante> integrantes;

	public Periodo() {
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

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<Capacitacion> getCapacitacions() {
		return this.capacitacions;
	}

	public void setCapacitacions(List<Capacitacion> capacitacions) {
		this.capacitacions = capacitacions;
	}

	public Capacitacion addCapacitacion(Capacitacion capacitacion) {
		getCapacitacions().add(capacitacion);
		capacitacion.setPeriodo(this);

		return capacitacion;
	}

	public Capacitacion removeCapacitacion(Capacitacion capacitacion) {
		getCapacitacions().remove(capacitacion);
		capacitacion.setPeriodo(null);

		return capacitacion;
	}

	public List<Integrante> getIntegrantes() {
		return this.integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

}
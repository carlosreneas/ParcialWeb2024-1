package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the capacitacion database table.
 * 
 */
@Entity
@NamedQuery(name="Capacitacion.findAll", query="SELECT c FROM Capacitacion c")
public class Capacitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="asistentes_esperados")
	private int asistentesEsperados;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_plan")
	private Date fechaFinPlan;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_realizada")
	private Date fechaFinRealizada;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_plan")
	private Date fechaInicioPlan;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_realizada")
	private Date fechaInicioRealizada;

	private String nombre;

	private String objetivo;

	@Lob
	private String observaciones;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="capacitacion")
	private List<Asistencia> asistencias;

	//bi-directional many-to-one association to Integrante
	@ManyToOne
	private Integrante integrante;

	//bi-directional many-to-one association to Periodo
	@ManyToOne
	private Periodo periodo;

	//bi-directional many-to-one association to Semillero
	@ManyToOne
	private Semillero semillero;

	public Capacitacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAsistentesEsperados() {
		return this.asistentesEsperados;
	}

	public void setAsistentesEsperados(int asistentesEsperados) {
		this.asistentesEsperados = asistentesEsperados;
	}

	public Date getFechaFinPlan() {
		return this.fechaFinPlan;
	}

	public void setFechaFinPlan(Date fechaFinPlan) {
		this.fechaFinPlan = fechaFinPlan;
	}

	public Date getFechaFinRealizada() {
		return this.fechaFinRealizada;
	}

	public void setFechaFinRealizada(Date fechaFinRealizada) {
		this.fechaFinRealizada = fechaFinRealizada;
	}

	public Date getFechaInicioPlan() {
		return this.fechaInicioPlan;
	}

	public void setFechaInicioPlan(Date fechaInicioPlan) {
		this.fechaInicioPlan = fechaInicioPlan;
	}

	public Date getFechaInicioRealizada() {
		return this.fechaInicioRealizada;
	}

	public void setFechaInicioRealizada(Date fechaInicioRealizada) {
		this.fechaInicioRealizada = fechaInicioRealizada;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Asistencia addAsistencia(Asistencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setCapacitacion(this);

		return asistencia;
	}

	public Asistencia removeAsistencia(Asistencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setCapacitacion(null);

		return asistencia;
	}

	public Integrante getIntegrante() {
		return this.integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Semillero getSemillero() {
		return this.semillero;
	}

	public void setSemillero(Semillero semillero) {
		this.semillero = semillero;
	}

}
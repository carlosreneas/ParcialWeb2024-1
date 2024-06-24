package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the semillero database table.
 * 
 */
@Entity
@NamedQuery(name="Semillero.findAll", query="SELECT s FROM Semillero s")
public class Semillero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	@Column(name="estrategia_trabajo")
	private String estrategiaTrabajo;

	@Lob
	private String mision;

	private String nombre;

	@Lob
	@Column(name="objetivo_especifico")
	private String objetivoEspecifico;

	@Lob
	@Column(name="objetivo_general")
	private String objetivoGeneral;

	private String sigla;

	@Lob
	private String vision;

	//bi-directional many-to-one association to Capacitacion
	@JsonIgnore
	@OneToMany(mappedBy="semillero")
	private List<Capacitacion> capacitacions;

	//bi-directional many-to-one association to Integrante
	@JsonIgnore
	@OneToMany(mappedBy="semillero")
	private List<Integrante> integrantes;

	//bi-directional many-to-one association to Linea
	@JsonIgnore
	@OneToMany(mappedBy="semillero")
	private List<Linea> lineas;

	//bi-directional many-to-one association to Area
	@ManyToOne
	private Area area;

	//bi-directional many-to-one association to Director
	@ManyToOne
	private Director director;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	private Grupo grupo;

	public Semillero() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstrategiaTrabajo() {
		return this.estrategiaTrabajo;
	}

	public void setEstrategiaTrabajo(String estrategiaTrabajo) {
		this.estrategiaTrabajo = estrategiaTrabajo;
	}

	public String getMision() {
		return this.mision;
	}

	public void setMision(String mision) {
		this.mision = mision;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObjetivoEspecifico() {
		return this.objetivoEspecifico;
	}

	public void setObjetivoEspecifico(String objetivoEspecifico) {
		this.objetivoEspecifico = objetivoEspecifico;
	}

	public String getObjetivoGeneral() {
		return this.objetivoGeneral;
	}

	public void setObjetivoGeneral(String objetivoGeneral) {
		this.objetivoGeneral = objetivoGeneral;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getVision() {
		return this.vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public List<Capacitacion> getCapacitacions() {
		return this.capacitacions;
	}

	public void setCapacitacions(List<Capacitacion> capacitacions) {
		this.capacitacions = capacitacions;
	}

	public Capacitacion addCapacitacion(Capacitacion capacitacion) {
		getCapacitacions().add(capacitacion);
		capacitacion.setSemillero(this);

		return capacitacion;
	}

	public Capacitacion removeCapacitacion(Capacitacion capacitacion) {
		getCapacitacions().remove(capacitacion);
		capacitacion.setSemillero(null);

		return capacitacion;
	}

	public List<Integrante> getIntegrantes() {
		return this.integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

	public Integrante addIntegrante(Integrante integrante) {
		getIntegrantes().add(integrante);
		integrante.setSemillero(this);

		return integrante;
	}

	public Integrante removeIntegrante(Integrante integrante) {
		getIntegrantes().remove(integrante);
		integrante.setSemillero(null);

		return integrante;
	}

	public List<Linea> getLineas() {
		return this.lineas;
	}

	public void setLineas(List<Linea> lineas) {
		this.lineas = lineas;
	}

	public Linea addLinea(Linea linea) {
		getLineas().add(linea);
		linea.setSemillero(this);

		return linea;
	}

	public Linea removeLinea(Linea linea) {
		getLineas().remove(linea);
		linea.setSemillero(null);

		return linea;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Director getDirector() {
		return this.director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
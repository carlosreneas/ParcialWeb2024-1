package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the linea database table.
 * 
 */
@Entity
@NamedQuery(name="Linea.findAll", query="SELECT l FROM Linea l")
public class Linea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String descripcion;

	private byte estado;

	private String nombre;

	//bi-directional many-to-one association to Semillero
	@ManyToOne
	private Semillero semillero;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="linea")
	private List<Proyecto> proyectos;

	public Linea() {
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

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semillero getSemillero() {
		return this.semillero;
	}

	public void setSemillero(Semillero semillero) {
		this.semillero = semillero;
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyectos().add(proyecto);
		proyecto.setLinea(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyectos().remove(proyecto);
		proyecto.setLinea(null);

		return proyecto;
	}

}
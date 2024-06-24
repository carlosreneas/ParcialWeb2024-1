package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Semillero
	@OneToMany(mappedBy="area")
	private List<Semillero> semilleros;

	public Area() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Semillero> getSemilleros() {
		return this.semilleros;
	}

	public void setSemilleros(List<Semillero> semilleros) {
		this.semilleros = semilleros;
	}

	public Semillero addSemillero(Semillero semillero) {
		getSemilleros().add(semillero);
		semillero.setArea(this);

		return semillero;
	}

	public Semillero removeSemillero(Semillero semillero) {
		getSemilleros().remove(semillero);
		semillero.setArea(null);

		return semillero;
	}

}
package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Director
	@OneToMany(mappedBy="departamento")
	@JsonIgnore
	private List<Director> directors;

	public Departamento() {
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

	public List<Director> getDirectors() {
		return this.directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public Director addDirector(Director director) {
		getDirectors().add(director);
		director.setDepartamento(this);

		return director;
	}

	public Director removeDirector(Director director) {
		getDirectors().remove(director);
		director.setDepartamento(null);

		return director;
	}

}
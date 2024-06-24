package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel_formacion database table.
 * 
 */
@Entity
@Table(name="nivel_formacion")
@NamedQuery(name="NivelFormacion.findAll", query="SELECT n FROM NivelFormacion n")
public class NivelFormacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Director
	@OneToMany(mappedBy="nivelFormacion")
	private List<Director> directors;

	public NivelFormacion() {
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
		director.setNivelFormacion(this);

		return director;
	}

	public Director removeDirector(Director director) {
		getDirectors().remove(director);
		director.setNivelFormacion(null);

		return director;
	}

}
package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;

	private String sigla;

	//bi-directional many-to-one association to Semillero
	@OneToMany(mappedBy="grupo")
	@JsonIgnore
	private List<Semillero> semilleros;

	public Grupo() {
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

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Semillero> getSemilleros() {
		return this.semilleros;
	}

	public void setSemilleros(List<Semillero> semilleros) {
		this.semilleros = semilleros;
	}

	public Semillero addSemillero(Semillero semillero) {
		getSemilleros().add(semillero);
		semillero.setGrupo(this);

		return semillero;
	}

	public Semillero removeSemillero(Semillero semillero) {
		getSemilleros().remove(semillero);
		semillero.setGrupo(null);

		return semillero;
	}

}
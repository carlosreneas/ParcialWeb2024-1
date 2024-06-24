package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="rol")
	private List<Integrante> integrantes;

	public Rol() {
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

	public List<Integrante> getIntegrantes() {
		return this.integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

	public Integrante addIntegrante(Integrante integrante) {
		getIntegrantes().add(integrante);
		integrante.setRol(this);

		return integrante;
	}

	public Integrante removeIntegrante(Integrante integrante) {
		getIntegrantes().remove(integrante);
		integrante.setRol(null);

		return integrante;
	}

}
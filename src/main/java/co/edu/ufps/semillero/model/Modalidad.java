package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the modalidad database table.
 * 
 */
@Entity
@NamedQuery(name="Modalidad.findAll", query="SELECT m FROM Modalidad m")
public class Modalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Participacion
	@OneToMany(mappedBy="modalidad")
	@JsonIgnore
	private List<Participacion> participacions;

	public Modalidad() {
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

	public List<Participacion> getParticipacions() {
		return this.participacions;
	}

	public void setParticipacions(List<Participacion> participacions) {
		this.participacions = participacions;
	}

	public Participacion addParticipacion(Participacion participacion) {
		getParticipacions().add(participacion);
		participacion.setModalidad(this);

		return participacion;
	}

	public Participacion removeParticipacion(Participacion participacion) {
		getParticipacions().remove(participacion);
		participacion.setModalidad(null);

		return participacion;
	}

}
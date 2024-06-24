package co.edu.ufps.semillero.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the producto_tipo database table.
 * 
 */
@Entity
@Table(name="producto_tipo")
@NamedQuery(name="ProductoTipo.findAll", query="SELECT p FROM ProductoTipo p")
public class ProductoTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Participacion
	@OneToMany(mappedBy="productoTipo")
	@JsonIgnore
	private List<Participacion> participacions;

	public ProductoTipo() {
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
		participacion.setProductoTipo(this);

		return participacion;
	}

	public Participacion removeParticipacion(Participacion participacion) {
		getParticipacions().remove(participacion);
		participacion.setProductoTipo(null);

		return participacion;
	}

}
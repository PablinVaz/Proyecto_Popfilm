package com.entidades.jee;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author PopFilm Development Team
 * Entidad del objeto director
 */
@Entity
@Table(name="director")
@NamedQuery(name="Director.findAll", query="SELECT d FROM Director d")
public class Director implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_director")
	private Long id_director;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_de_nacimiento")
	private Date fechaDeNacimiento;
	
	@Column(name = "numero_de_premios")
	private int numPremios;
	
	@OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
	List<Pelicula> peliculas = new ArrayList<>();
	
	
	// Constructor vacio
	
	public Director() {
	}
	
	// Constructor sobrecargado

	public Director(Long id_director, String nombre, Date fechaDeNacimiento, int numPremios,  List<Pelicula> peliculas) {
		super();
		this.id_director = id_director;
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.numPremios = numPremios;
		this.peliculas = peliculas;
	}
	
	// Getter and Setter

	public Long getId() {
		return id_director;
	}

	public void setId(Long id_director) {
		this.id_director = id_director;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public int getNumPremios() {
		return numPremios;
	}

	public void setNumPremios(int numPremios) {
		this.numPremios = numPremios;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// To String

	@Override
	public String toString() {
		return "Director [id=" + id_director + ", nombre=" + nombre + ", fechaDeNacimiento=" + fechaDeNacimiento
				+ ", numPremios=" + numPremios + ", peliculas=" + peliculas + "]";
	}
	
	
	
	
	
	

	
}

package com.entidades.jee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 * 
 * @author PopFilm Development Team
 * Entidad genero para la respectiva tabla en la Base de Datos
 *
 */
@Entity
@Table(name="genero")
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")

public class Genero implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_genero")
	private Long id_genero;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	// ASOCIACIONES
	@ManyToMany(mappedBy = "generos")
	private List<Pelicula> peliculas = new ArrayList<>();
	
	// Constructor Vacio
	
	public Genero() {
	}
	
	// Constructor sobrecargado

	public Genero(Long id_genero, String nombre, String descripcion, List<Pelicula> peliculas) {
		super();
		this.id_genero = id_genero;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peliculas = peliculas;
	}
	
	// Creamos los getters and setters

	public Long getId() {
		return id_genero;
	}

	public void setId(Long id_genero) {
		this.id_genero = id_genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "Genero [id=" + id_genero + ", nombre=" + nombre + ", descripcion=" + descripcion + ", peliculas=" + peliculas.size()
				+ "]";
	}
	
}

package com.entidades.jee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
 * Clase para la entidad productora
 */
@Entity
@Table(name="productora")
@NamedQuery(name="Productora.findAll", query="SELECT p FROM Productora p")

public class Productora implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_productora;
	private String nombre;
	private double inversionInicial;
	private double ganancias;
	private double gananciasTotales;
	
	// Asociaciones
	
	@OneToMany(mappedBy = "productora", cascade = CascadeType.ALL)
	List<Pelicula> peliculas = new ArrayList<>();
	
	// Constructor Vacio
	
	public Productora() {
	}
	
	// Constructor Sobrecargado

	public Productora(Long id_productora, String nombre, double inversionInicial, double ganancias, double gananciasTotales, List<Pelicula> peliculas) {
		super();
		this.id_productora = id_productora;
		this.nombre = nombre;
		this.inversionInicial = inversionInicial;
		this.ganancias = ganancias;
		this.gananciasTotales = gananciasTotales;
		this.peliculas = peliculas;
	}
	
	// GETTER AND SETTER

	public Long getId() {
		return id_productora;
	}

	public void setId(Long id_productora) {
		this.id_productora = id_productora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getInversionInicial() {
		return inversionInicial;
	}

	public void setInversionInicial(double inversionInicial) {
		this.inversionInicial = inversionInicial;
	}

	public double getGanancias() {
		return ganancias;
	}

	public void setGanancias(double ganancias) {
		this.ganancias = ganancias;
	}

	public double getGananciasTotales() {
		return gananciasTotales;
	}

	public void setGananciasTotales(double gananciasTotales) {
		this.gananciasTotales = gananciasTotales;
	}
	
	public List<Pelicula> getPeliculas(){
		return peliculas;
	}
	
	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// TO STRING
	
	@Override
	public String toString() {
		return "Productora [id=" + id_productora + ", nombre=" + nombre + ", inversionInicial=" + inversionInicial + ", ganancias="
				+ ganancias + ", gananciasTotales=" + gananciasTotales + ", peliculas=" + peliculas + "]";
	}
	

}

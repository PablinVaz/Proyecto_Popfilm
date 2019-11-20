package com.entidades.jee;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




/**
 * @author PopFilm Development Team
 * Entidad pel�cula para la respectiva tabla en la Base de Datos
 * 
 */
@Entity
@Table(name="pelicula")
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")

public class Pelicula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pelicula")
	private Long id_pelicula;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="reparto")
	private String reparto;
	
	@Column(name="fecha_de_estreno")
	private Date fechaEstreno;
	
	@Column(name="edad_recomendada")
	private String edadRecomendada;
	
	@Column(name="sinopsis")
	private String sinopsis;
	
	//ASOCIACIONES
	
	@ManyToOne(fetch = FetchType.LAZY) // The attribute type for a collection mapping must be java.util.Collection, java.util.Set, java.util.List or java.util.Map
	@JoinColumn(name = "id_director") // Con esto indicamos que en la tabla de la DB para pelicula habr� una columna para el id del director
	private Director director;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_productora")
	private Productora productora;
	
	@ManyToMany
	@JoinTable(name = "pelicula_genero",
	joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula"),
	inverseJoinColumns = @JoinColumn(name = "id_genero", referencedColumnName = "id_genero"))
	private List<Genero> generos = new ArrayList<>();
	// private Genero genero;
	
	// Constructor vacio de la entidad
	
	public Pelicula() {
	}
	
	// Constructor Sobrecargado de la entidad
	
	public Pelicula(Long id_pelicula, String titulo, String reparto, Date fechaEstreno, String edadRecomendada, String sinopsis,
			Director director, Productora productora, List<Genero> generos) {
	super();
	this.id_pelicula = id_pelicula;
	this.titulo = titulo;
	this.reparto = reparto; //�puede ser un array?
	this.fechaEstreno = fechaEstreno;
	this.edadRecomendada = edadRecomendada;
	this.sinopsis = sinopsis;
	this.director = director;
	this.productora = productora;
	this.generos = generos;
	}
	
	// GETTER AND SETTER

	public Long getId() {
		return id_pelicula;
	}

	public void setId(Long id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	
	public String getEdadRecomendada() {
		return edadRecomendada;
	}
	
	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
	
	public String getSinopsis() {
		return sinopsis;
	}
	
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
	
	public Productora getProductora() {
		return productora;
	}
	
	public void setProductora(Productora productora) {
		this.productora = productora;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGenero(List<Genero> generos) {
		this.generos = generos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// TO STRING

	@Override
	public String toString() {
		return "Pelicula [id=" + id_pelicula + ", titulo=" + titulo + ", reparto=" + reparto + ", fechaEstreno=" + fechaEstreno + ", edadRecomendada=" + edadRecomendada
				+ ", sinopsis=" + sinopsis + ", director=" + director + ", productora=" + productora + ", generos=" + generos.size() + "]";
	}
	
	
	
	
	
	
}





package com.entidades.jee;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author PopFilm Development Team
 * Clase para la entidad Usuario
 *
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id_usuario;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nickName")
	private String nickName;
	
	@Column(name="password")
	private String password;
	
	// Constructor vacio
	
	public Usuario() {
	}
	
	// Constructor sobrecargado

	public Usuario(Long id_usuario, String nombre, String apellido, String email, String nickName, String password) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nickName = nickName;
		this.password = password;
	}
	
	// GETTERS AND SETTERS

	public Long getId() {
		return id_usuario;
	}

	public void setId(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// TO STRING

	@Override
	public String toString() {
		return "Usuario [id=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", nickName=" + nickName + ", password=" + password + "]";
	}
		

}

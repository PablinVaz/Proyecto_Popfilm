/**
 * @author PopFilm Development Team
 * Main con los metodos a implementar en las entidades.
 */


package com.MainPopFilm.jee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entidades.dao.impl.jee.UsuarioDaoImpl;
import com.entidades.jee.Usuario;

public class MainPopFilm {
	

	public static void main(String[] args) {
		System.out.println("Hello World!!");
		
		
		
		UsuarioDaoImpl usuarioDatabase = new UsuarioDaoImpl();
		System.out.println(usuarioDatabase.login("manuelcortina2018@gmail.com", "PopFilm"));
		System.out.println(usuarioDatabase.login("manuelcortina2019@gmail.com", "PopFilm2"));
	}
	
	
	
	

	
	
}
package com.entidades.dao.jee;

import java.util.List;

import com.entidades.jee.Pelicula;

public interface PeliculaDao {

	public Pelicula findById(Long id);
	
	public List<Pelicula> findAll();
	
	public boolean save(Pelicula pelicula);
	
	public boolean update (Pelicula pelicula);
	
	public boolean delete(Long id);
	

}

package com.entidades.dao.jee;

import java.util.List;

import com.entidades.jee.Genero;

public interface GeneroDao {
	
	public Genero findById(Long id);
	
	public List<Genero> findAll();
	
	public boolean save(Genero genero);
	
	public boolean update(Genero genero);
	
	public boolean delete (Long id);

}

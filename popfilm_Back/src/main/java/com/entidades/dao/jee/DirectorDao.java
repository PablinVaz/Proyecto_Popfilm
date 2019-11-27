package com.entidades.dao.jee;

import java.util.List;

import com.entidades.jee.Director;

public interface DirectorDao {
	
	public Director findById(Long id);
	
	public List<Director> findAll();
	
	public boolean save(Director director);
	
	public boolean update(Director director);
	
	public boolean delete(Long id);


}

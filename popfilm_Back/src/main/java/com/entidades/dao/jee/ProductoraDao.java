package com.entidades.dao.jee;

import java.util.List;

import com.entidades.jee.Productora;

public interface ProductoraDao {
	
	public Productora findById(Long id);
	
	public List<Productora> findAll();
	
	public boolean save(Productora productora);
	
	public boolean update (Productora productora);
	
	public boolean delete (Long id);

}

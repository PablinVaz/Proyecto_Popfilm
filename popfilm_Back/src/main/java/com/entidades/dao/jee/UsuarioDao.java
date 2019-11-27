package com.entidades.dao.jee;

import java.util.List;

import com.entidades.jee.Usuario;


public interface UsuarioDao {
	
	public boolean login(String email, String password);
	
	public Usuario findById(Long id);
	
	public List<Usuario> findAll();
	
	public boolean save(Usuario usuario);
	
	public boolean update (Usuario usuario);
	
	public boolean delete (Long id);
	
	public Usuario findByEmail (String email);
	

}

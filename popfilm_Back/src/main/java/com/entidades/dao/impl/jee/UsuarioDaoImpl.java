package com.entidades.dao.impl.jee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.entidades.dao.jee.UsuarioDao;
import com.entidades.jee.Usuario;



public class UsuarioDaoImpl implements UsuarioDao {
	
	private static final String USER_COUNT = "SELECT COUNT(u) FROM Usuario u "
			+ "WHERE u.email = :email AND u.password = :password";
	private static final String USER_FIND_ALL = "SELECT u FROM Usuario u";
	
	
	// manager(gestor de persistencia)
	private EntityManagerFactory managerFactory;
	private EntityManager manager;
	
	
	
	public UsuarioDaoImpl() {
		managerFactory= Persistence.createEntityManagerFactory("popfilm");
		manager = managerFactory.createEntityManager();
	}
	
	
	
	/**
	 * Metodo login usuario
	 */
	
	@Override
	public boolean login(String email, String password) {
		
		TypedQuery<Long> query = manager.createQuery(USER_COUNT, Long.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		Long numUsuario = query.getSingleResult();
		
		System.out.println("Numero de usuarios con email y password: " + numUsuario);
		
		if(numUsuario == 0) {
			
			return false;
			
		}else {
			
			return true;
		}
	}
	
	/**
	 * Metodo findById
	 */

	@Override
	public Usuario findById(Long id) {
		
		if(id==null) {
			return null;
		}
		return manager.find(Usuario.class,id);
	
	}
	
	/**
	 * Metodo findAll
	 */

	@Override
	public List<Usuario> findAll() {
		
		TypedQuery<Usuario> query = manager.createQuery(USER_FIND_ALL, Usuario.class);
		List<Usuario>listaUsers=query.getResultList();
		return listaUsers;
	}
	
	public Usuario findByEmail (String email)	{
		   
		   List<Usuario> usuarios = findAll();
		   Usuario usuario = new Usuario();
		    for (Usuario usuario2 : usuarios) {
		    	if(usuario2.getEmail().contentEquals(email)) {	
		    		
		    		usuario.setId(usuario2.getId());
		    		usuario.setEmail(usuario2.getEmail());
		    		usuario.setPassword(usuario2.getPassword());
		    		
		    		
		    		
		    	}
		    }
		   return usuario;
	   }
	
	/**
	 * Metodo create Usuario
	 */

	@Override
	public boolean save(Usuario usuario) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.persist(usuario); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * Metodo update usuario
	 */

	@Override
	public boolean update(Usuario usuario) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.merge(usuario); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * Metodo Delete Usuario
	 */

	@Override
	public boolean delete(Long id) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			Usuario usuario = manager.find(Usuario.class, id);
			if (usuario != null) {
				manager.remove(usuario);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}

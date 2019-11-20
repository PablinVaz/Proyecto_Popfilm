package com.entidades.dao.impl.jee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.dao.jee.PeliculaDao;
import com.entidades.jee.Director;
import com.entidades.jee.Pelicula;


public class PeliculaDaoImpl implements PeliculaDao {
	
	
	
	private static final String USER_FIND_ALL = "SELECT p FROM Pelicula p";
	
	private EntityManagerFactory managerFactory;
	private EntityManager manager;
	
	
	
	public PeliculaDaoImpl() {
		managerFactory= Persistence.createEntityManagerFactory("popfilm");
		manager = managerFactory.createEntityManager();
	}

	@Override
	public Pelicula findById(Long id) {
		
		if(id==null){
			return null;
		}
		
		return manager.find(Pelicula.class, id);
	}

	@Override
	public List<Pelicula> findAll() {
		
		TypedQuery<Pelicula> query = manager.createQuery(USER_FIND_ALL, Pelicula.class);
		List<Pelicula>listaPeliculas=query.getResultList();
		return listaPeliculas;
		
	}

	@Override
	public boolean save(Pelicula pelicula) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.persist(pelicula); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Pelicula pelicula) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.merge(pelicula); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(Long id) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			Pelicula pelicula = manager.find(Pelicula.class, id);
			if (pelicula != null) {
				manager.remove(pelicula);
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

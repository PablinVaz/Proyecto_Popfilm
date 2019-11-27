package com.entidades.dao.impl.jee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.TypedQuery;
import com.entidades.dao.jee.GeneroDao;
import com.entidades.jee.Genero;



public class GeneroDaoImpl implements GeneroDao {



	
	private static final String USER_FIND_ALL= "SELECT g FROM Genero g";
	
	private EntityManagerFactory managerFactory;
	private EntityManager manager;
	
	
	
	public GeneroDaoImpl() {
		managerFactory= Persistence.createEntityManagerFactory("popfilm");
		manager = managerFactory.createEntityManager();
	}
	

	@Override
	public Genero findById(Long id) {
		
		if(id==null) {
			return null;
		}
		return manager.find(Genero.class,id);
	}

	@Override
	public List<Genero> findAll() {
		TypedQuery<Genero> query = manager.createQuery(USER_FIND_ALL, Genero.class);
		List<Genero>listaGeneros=query.getResultList();
		return listaGeneros;	
	}
	
	@Override
	public boolean save(Genero genero) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.persist(genero); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Genero genero) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.merge(genero); 
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
			Genero genero = manager.find(Genero.class, id);
			if (genero != null) {
				manager.remove(genero);
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
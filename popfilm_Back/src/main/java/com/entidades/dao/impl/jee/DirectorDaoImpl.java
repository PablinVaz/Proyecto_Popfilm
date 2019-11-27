package com.entidades.dao.impl.jee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.TypedQuery;

import com.entidades.dao.jee.DirectorDao;
import com.entidades.jee.Director;



public class DirectorDaoImpl implements DirectorDao {

	
	
	private static final String USER_FIND_ALL= "SELECT d FROM Director d";
	
	private EntityManagerFactory managerFactory;
	private EntityManager manager;
	
	
	
	public DirectorDaoImpl() {
		managerFactory= Persistence.createEntityManagerFactory("popfilm");
		manager = managerFactory.createEntityManager();
	}
	

	@Override
	public Director findById(Long id) {
		
		if(id==null) {
			return null;
		}
		return manager.find(Director.class,id);
	}

	@Override
	public List<Director> findAll() {
		TypedQuery<Director> query = manager.createQuery(USER_FIND_ALL, Director.class);
		List<Director>listaDirectores=query.getResultList();
		return listaDirectores;	
	}
	
	@Override
	public boolean save(Director director) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.persist(director); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Director director) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.merge(director); 
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
			Director director = manager.find(Director.class, id);
			if (director != null) {
				manager.remove(director);
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
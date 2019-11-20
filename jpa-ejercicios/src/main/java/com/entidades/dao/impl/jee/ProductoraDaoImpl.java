package com.entidades.dao.impl.jee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.dao.jee.ProductoraDao;
import com.entidades.jee.Director;
import com.entidades.jee.Pelicula;
import com.entidades.jee.Productora;



public class ProductoraDaoImpl implements ProductoraDao {
	
	
	
	private static final String USER_FIND = "SELECT p FROM Productora p where p.id=:id";
	private static final String USER_FIND_ALL= "SELECT p FROM Productora p";
	
	private EntityManagerFactory managerFactory;
	private EntityManager manager;
	
	
	
	public ProductoraDaoImpl() {
		managerFactory= Persistence.createEntityManagerFactory("popfilm");
		manager = managerFactory.createEntityManager();
	}
	

	@Override
	public Productora findById(Long id) {
		
		if(id==null) {
			return null;
		}
		return manager.find(Productora.class,id);
	}

	@Override
	public List<Productora> findAll() {
		TypedQuery<Productora> query = manager.createQuery(USER_FIND_ALL, Productora.class);
		List<Productora>listaProductores=query.getResultList();
		return listaProductores;	
	}
	
	@Override
	public boolean save(Productora productora) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.persist(productora); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Productora productora) {
		boolean flag = false;
		try {

			manager.getTransaction().begin();   
			manager.merge(productora); 
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
			Productora productora = manager.find(Productora.class, id);
			if (productora != null) {
				manager.remove(productora);
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

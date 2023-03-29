package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Example;

public class ExampleDao {

	public Example merge(Example example) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Example merged = em.merge(example);
		transaction.commit();
		em.close();
		return merged;
	}

	public Example findById(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		Example example = em.find(Example.class, id);
		em.close();
		return example;
	}
	
	public void remove(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createQuery("delete from Example e where e.id = :id", Example.class).setParameter("id", id)
				.executeUpdate();
		transaction.commit();
		em.close();
	}
	
	public static void main(String[] args) {
		String nom = "Jean-Jacques";
    	ExampleDao exampleDao = new ExampleDao();
    	Example example = new Example();
		example.setNom(nom);
    	
		Example savedExample = exampleDao.merge(example);
	}

}

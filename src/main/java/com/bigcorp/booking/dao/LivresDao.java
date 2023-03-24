package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Livre;

public class LivresDao {
	
	public Livre merge(Livre object) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Livre merged = em.merge(object);
		transaction.commit();
		em.close();
		return merged;
	}
	
	public Livre findById(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Livre.class, id);
	}
	
}
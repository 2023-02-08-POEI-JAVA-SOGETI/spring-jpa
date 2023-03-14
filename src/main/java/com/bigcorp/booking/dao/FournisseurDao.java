package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDao {

	public Fournisseur merge(Fournisseur fournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Fournisseur merged = em.merge(fournisseur);
		
		transaction.commit();
		em.close();

		return merged;
	}
	
	public Fournisseur findById(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		
		return em.find(Fournisseur.class, id);
	}
	
	public void remove(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.createQuery("DELETE FROM Provider p WHERE p.id = :id", Fournisseur.class)
				.executeUpdate();
		transaction.commit();
		em.close();
	}
}

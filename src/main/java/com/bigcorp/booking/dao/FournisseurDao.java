package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDao {

	public Fournisseur merge(Fournisseur f) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Fournisseur merged = em.merge(f);
		transaction.commit();
		em.close();
		return merged;
	}
	
	public static void main(String[] args) {
		String nom = "Mon Fournisseur Prefere";
		
    	FournisseurDao fd = new FournisseurDao();
    	Fournisseur f = new Fournisseur(10, 10, nom, "Fournisseur test", "mon adresse test");

		Fournisseur savedFournisseur = fd.merge(f);
	}

	public Fournisseur findById(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Fournisseur.class, id);
	}
}

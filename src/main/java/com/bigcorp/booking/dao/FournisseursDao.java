package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Fournisseurs;

public class FournisseursDao {
	public Fournisseurs merge(Fournisseurs fournisseurs) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Fournisseurs merged = em.merge(fournisseurs);
		transaction.commit();
		em.close();
		return merged;
	}

	public Fournisseurs findById(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Fournisseurs.class, id);
	}
	

	public void remove(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createQuery("delete from Example e where e.id = :iD", Fournisseurs.class).setParameter("iD", id)
				.executeUpdate();
		transaction.commit();
		em.close();
	}
	
	
	public static void main(String[] args) {
		String nom = "Jean-Jacques";
		
    	FournisseursDao fournisseursDao = new FournisseursDao();
    	Fournisseurs fournisseurs = new Fournisseurs();
		fournisseurs.setNom(nom);
		fournisseurs.setNumeroUnique(45);
    	
		Fournisseurs savedFournisseurs = fournisseursDao.merge(fournisseurs);
	}
}

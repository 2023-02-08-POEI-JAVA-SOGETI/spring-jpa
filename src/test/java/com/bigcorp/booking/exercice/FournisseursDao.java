package com.bigcorp.booking.exercice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.dao.PersistenceSingleton;

public class FournisseursDao {

	public Fournisseurs merge(Fournisseurs fournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Fournisseurs merged = em.merge(fournisseur);
		transaction.commit();
		em.close();
		return merged;
	}

	public Fournisseurs findById(Integer integer) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Fournisseurs.class, integer);
	}
	

	public void remove(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createQuery("delete from Fournisseurs e where e.id = :id", Fournisseurs.class).setParameter("id", id)
				.executeUpdate();
		transaction.commit();
		em.close();
	}
	
	
	public static void main(String[] args) {
		String nom = "Jean-Jacques";
    	FournisseursDao fournisseurDao = new FournisseursDao();
    	Fournisseurs fournisseur = new Fournisseurs();
		fournisseur.setNom(nom);
    	
		Fournisseurs savedFournisseur = fournisseurDao.merge(fournisseur);
	}

}

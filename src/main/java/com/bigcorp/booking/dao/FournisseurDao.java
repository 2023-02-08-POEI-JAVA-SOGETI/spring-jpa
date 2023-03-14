package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDao {

	public Fournisseur merge(Fournisseur example) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Fournisseur merged = em.merge(example);
		transaction.commit();
		em.close();
		return merged;
	}

	public Fournisseur findById(int id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Fournisseur.class, id);
	}
	

//	public void remove(Long id) {
//		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		em.createQuery("delete from Example e where e.id = :id", Example.class).setParameter("id", id)
//				.executeUpdate();
//		transaction.commit();
//		em.close();
//	}
//	
	
	public static void main(String[] args) {
		String nom = "camille";
    	int num = 123;
    	String email = "camille@camille.com";
    	String adresse = "1 rue de la Gare 75000 Paris";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom(nom);
		fournisseur.setNum(num);
		fournisseur.setEmail(email);
		fournisseur.setAdresse(adresse);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		Fournisseur savedFournisseurId = fournisseurDao.findById(1);
	}

}

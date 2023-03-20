package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Utilisateur;


public class UtilisateurDao {

	/*public void testSave() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		Assertions.assertNotNull(savedFournisseur.getId());
	}*/

	public Utilisateur merge(Utilisateur object) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Utilisateur merged = em.merge(object);
		transaction.commit();
		em.close();
		return merged;
	}

	public Utilisateur findById(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Utilisateur.class, id);
	}

	public void remove(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createQuery("delete from Example e where e.id = :id", Utilisateur.class).setParameter("id", id)
				.executeUpdate();
		transaction.commit();
		em.close();
	}

}

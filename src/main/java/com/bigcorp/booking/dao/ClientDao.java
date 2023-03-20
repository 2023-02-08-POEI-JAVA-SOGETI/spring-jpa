package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Fournisseur;


public class ClientDao extends AbstractDao<Fournisseur> {

	/*public void testSave() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		Assertions.assertNotNull(savedFournisseur.getId());
	}*/

	public Client merge(Client object) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Client merged = em.merge(object);
		transaction.commit();
		em.close();
		return merged;
	}

	public Client findById(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Client.class, id);
	}

	public void remove(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createQuery("delete from Example e where e.id = :id", Client.class).setParameter("id", id)
				.executeUpdate();
		transaction.commit();
		em.close();
	}

}

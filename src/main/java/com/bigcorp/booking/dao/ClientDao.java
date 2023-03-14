package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Client;

public class ClientDao extends AbstractDao<Client>{

	@Override
	public Client merge(Client client) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Client merged = em.merge(client);
		
		transaction.commit();
		em.close();

		return merged;
	}
	
	public Client findById(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		
		return em.find(Client.class, id);
	}
	
	public void remove(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.createQuery("DELETE FROM Client p WHERE p.id = :id", Client.class)
				.executeUpdate();
		transaction.commit();
		em.close();
	}
}

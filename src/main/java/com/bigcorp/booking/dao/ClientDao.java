package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Client;

public class ClientDao extends AbstractDao<Client>{

	/**
	 * Récupère tous les clients dont le nom est passé en 
	 * paramètre.
	 * @param nomClient
	 * @return une liste, not null
	 */
	public List<Client> getParNom(String nomClient){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Client> laListeDesClientsAvecLeBonNom 
			= em.createQuery("from Client where nom = :nomClient", Client.class)
			.setParameter("nomClient", nomClient).getResultList();
		em.close();
		return laListeDesClientsAvecLeBonNom;
	}

}
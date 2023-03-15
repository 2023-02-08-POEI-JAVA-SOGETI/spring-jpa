package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;

import com.bigcorp.booking.model.Client;

public class ClientDao extends AbstractDao<Client>{

	/**
	 * Récupère tous les clients dont le nom est passé en 
	 * paramètre.
	 * 
	 * @param nomClient
	 * @return une liste, not null
	 */
	public List<Client> getParNom(String nomClient){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		//Va envoyer une requête comme 'SELECT * FROM CLIENT WHERE NOM = ' + nomClient
		List<Client> laListeDesClientsAvecLeBonNom 
			= em.createQuery("from Client where nom = :nomClient", Client.class)
			.setParameter("nomClient", nomClient).getResultList();
		em.close();
		return laListeDesClientsAvecLeBonNom;
	}

	/**
	 * Récupère tous les clients dont le nom contient la chaîne passée en 
	 * paramètre. Attention, sensible à la casse.
	 * @param nomClient
	 * @return une liste, not null
	 */
	public List<Client> getParNomLikeSensibleALaCasse(String nomClient){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		//Va envoyer une requête comme 'SELECT * FROM CLIENT WHERE NOM LIKE %' + nomClient + '%'
		List<Client> laListeDesClientsAvecLeBonNom 
			= em.createQuery("from Client where nom like :nomClient", Client.class)
			.setParameter("nomClient", "%" +  nomClient + "%").getResultList();
		em.close();
		return laListeDesClientsAvecLeBonNom;
	}

	/**
	 * Récupère tous les clients dont le nom contient la chaîne passée en 
	 * paramètre. Insensible à la casse
	 * @param nomClient
	 * @return une liste, not null
	 */
	public List<Client> getParNomLikeInsensibleALaCasse(String nomClient){
		if(nomClient == null) {
			nomClient = StringUtils.EMPTY;
		}
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		//Va envoyer une requête comme 'SELECT * FROM CLIENT WHERE UPPER(NOM) LIKE %' + UPPER(nomClient) + '%'
		List<Client> laListeDesClientsAvecLeBonNom 
			= em.createQuery("from Client where upper(nom) like :nomClient", Client.class)
			.setParameter("nomClient", "%" +  nomClient.toUpperCase() + "%").getResultList();
		em.close();
		return laListeDesClientsAvecLeBonNom;
	}

}
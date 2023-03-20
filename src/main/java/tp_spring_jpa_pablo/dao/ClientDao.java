package tp_spring_jpa_pablo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.dao.PersistenceSingleton;

import tp_spring_jpa_pablo.model.Client;

public class ClientDao extends AbstractDao<Client> {
	
	// JPQL requetes SQL en JPA
	public List<Client> getParNom(String nomClient) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Client> laListeDesClientsAvecLeBonNom = 
			em.createQuery("from Client where nom = :nomClient", Client.class)
			.setParameter("nomClient", nomClient).getResultList();
		em.close();
		return laListeDesClientsAvecLeBonNom;
	}
	
	public List<Client> findAll() {
	    EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
	    try {
	        return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
	    } finally {
	        em.close();
	    }
	}

	
}

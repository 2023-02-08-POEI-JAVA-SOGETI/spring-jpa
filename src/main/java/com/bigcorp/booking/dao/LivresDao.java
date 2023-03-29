package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Livre;

public class LivresDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	/*public Livre findById(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Livre.class, id);
	}*/
	
	public Livre findByTitre(String titre) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Livre.class, titre);
	}
	
	public Livre findById(Class<Livre> class1, Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		Livre foundEntity = em.find(class1, id);
		em.close();
		return foundEntity;
	}	
	
	public Livre findByTitre(Class<Livre> class2, String titre) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		Livre foundEntity = em.find(class2, titre);
		em.close();
		return foundEntity;
	}	

	public List<Livre> getParTitreLikeInsensibleALaCasse(String titreLivre) {
		if(titreLivre == null) {
			titreLivre = "";
		}
		
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		//Va envoyer une requête comme 'SELECT * FROM LIVRE WHERE UPPER(NOM) LIKE %' + UPPER(titreLivre) + '%'
		List<Livre> laListeDesLivresAvecLeBonTitre
			= em.createQuery("from Livre where upper(titre) like :titreLivre", Livre.class)
			.setParameter("titreLivre", "%" +  titreLivre.toUpperCase() + "%").getResultList();
		em.close();
		return laListeDesLivresAvecLeBonTitre;

	}

	
	public Livre merge(Livre livre) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Livre merged = em.merge(livre);
		transaction.commit();
		em.close();
		return merged;
	}

	public void persist(Livre livre) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(livre);
		transaction.commit();
		em.close();
	}

	public void remove(Livre livre) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(livre);
		transaction.commit();
		em.close();
	}


	
}
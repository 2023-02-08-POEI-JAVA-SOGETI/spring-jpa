package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDao extends AbstractDao<Fournisseur> {

	/*
	 * public void testSave() { FournisseurDao fournisseurDao = new
	 * FournisseurDao(); Fournisseur fournisseur = new Fournisseur(); Fournisseur
	 * savedFournisseur = fournisseurDao.merge(fournisseur);
	 * Assertions.assertNotNull(savedFournisseur.getId()); }
	 */

	/**
	 * Récupère tous les clients dont le nom est passé en paramètre.
	 * 
	 * @param nomClient
	 * @return une liste, not null
	 */

	public List<Fournisseur> getParNom(String nomFournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> laListeDesFournisseurAvecLeBonNom = em
				.createQuery("from Fournisseur where nom = :noFournisseur", Fournisseur.class)
				.setParameter("nomFournisseur", nomFournisseur).getResultList();
		em.close();
		return laListeDesFournisseurAvecLeBonNom;
	}

	/*
	 * public Fournisseur merge(Fournisseur object) { EntityManager em =
	 * PersistenceSingleton.INSTANCE.createEntityManager(); EntityTransaction
	 * transaction = em.getTransaction(); transaction.begin(); Fournisseur merged =
	 * em.merge(object); transaction.commit(); em.close(); return merged; }
	 * 
	 * public Fournisseur findById(Long id) { EntityManager em =
	 * PersistenceSingleton.INSTANCE.createEntityManager(); return
	 * em.find(Fournisseur.class, id); }
	 * 
	 * public void remove(Long id) { EntityManager em =
	 * PersistenceSingleton.INSTANCE.createEntityManager(); EntityTransaction
	 * transaction = em.getTransaction(); transaction.begin();
	 * em.createQuery("delete from Example e where e.id = :id",
	 * Fournisseur.class).setParameter("id", id) .executeUpdate();
	 * transaction.commit(); em.close(); }
	 */
}

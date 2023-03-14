package com.bigcorp.booking.exercice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bigcorp.booking.dao.PersistenceSingleton;



public class FournisseurDao {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurDao.class);
	
		public Fournisseur merge(Fournisseur fournisseur)
		{
			LOGGER.info("Début du merge, création EntityManager");
			
			EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			LOGGER.info("merge du fournisseur");
			
			Fournisseur myNewFournisseur = em.merge(fournisseur);
			et.commit();
			em.close();
			
			LOGGER.info("Fin du merge");
			
			return myNewFournisseur;
			
		}

}

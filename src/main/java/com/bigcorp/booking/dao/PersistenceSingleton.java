package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton pour un contexte de persistence
 */
public class PersistenceSingleton {

	private static final String PERSISTENCE_UNIT = "persistence-unit";

	// On s'assure ici que seule une instance de la classe sera créée
	public static final PersistenceSingleton INSTANCE = new PersistenceSingleton();

	private EntityManagerFactory entityManagerFactory;

	// On s'assure ici que seule une instance de la classe sera créée
	private PersistenceSingleton() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	// Méthode utile pour créer une entityManager
	public EntityManager createEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}

}

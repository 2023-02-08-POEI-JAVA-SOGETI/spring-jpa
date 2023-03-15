package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/* Classe abstraite = classe qui ne peut pas être instanciée directement. càd on peut pas créer d'objets à partir
 * de cette classe => On doit créer une s/classe qui étend la classe abstraite et implémente toutes les méthodes 
 * abstraites de la classe abstraite.
 * Une méthode abstraite ne contient pas de corps de méthode (càd la méthode n'a pas de code).
 * Les s/classes qui étendent la classe abstraite doivent implémenter toutes les méthodes abstraites de la classe
 * abstraite en fournissant le corps de la méthode.
 */

/**
 * Base Abstract DAO
 * @author bigcorp
 *
 * @param <T>
 */
public abstract class AbstractDao<T> {

	@PersistenceContext  //injecter une instance d'EntityManager, utilisée pour interagir avec la BDD
	protected EntityManager entityManager;

	/**
	 * @see EntityManager#find(Class, Object)
	 * @param entity
	 */
	public T findById(Class<T> clazz, Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(clazz, id);
	}

	/**
	 * @see EntityManager#merge(Object)
	 * @param entity
	 */
	public T merge(T entity) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		T merged = em.merge(entity);
		transaction.commit();
		em.close();
		return merged;
	}

	/**
	 * @see EntityManager#persist(Object)
	 * @param entity
	 */
	public void persist(T entity) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(entity);
		transaction.commit();
		em.close();
	}

	/**
	 * @see EntityManager#remove(Object)
	 * @param entity
	 */
	public void remove(T entity) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(entity);
		transaction.commit();
		em.close();
	}

}

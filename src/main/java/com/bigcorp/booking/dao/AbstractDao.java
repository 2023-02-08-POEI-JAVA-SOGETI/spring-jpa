package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 * Base Abstract DAO
 * @author bigcorp
 *
 * @param <T>
 */
public abstract class AbstractDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * @see EntityManager#find(Class, Object)
	 * @param entity
	 */
	public T findById(Class<T> clazz, Integer id) {
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

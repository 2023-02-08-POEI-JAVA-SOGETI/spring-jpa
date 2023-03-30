package com.bigcorp.booking.tp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.dao.PersistenceSingleton;

public class ArticlesDao {

	public Articles merge(Articles article) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Articles merged = em.merge(article);
		transaction.commit();
		em.close();
		return merged;
	}

	public Articles findById(Integer integer) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Articles.class, integer);
	}
	
	public void remove(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createQuery("delete from Articles e where e.id = :id", Articles.class).setParameter("id", id)
				.executeUpdate();
		transaction.commit();
		em.close();
	}
	
	public static void main(String[] args) {
		String nom = "Boucles d'oreilles";
    	ArticlesDao articleDao = new ArticlesDao();
    	Articles article = new Articles();
		article.setNom(nom);
    	
		Articles savedArticle = articleDao.merge(article);
	}

}

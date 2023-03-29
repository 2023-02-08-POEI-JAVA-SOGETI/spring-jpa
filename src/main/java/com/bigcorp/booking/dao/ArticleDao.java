package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Article;

@Repository
public class ArticleDao extends AbstractDao<Article> {

	/*
	 * public void testSave() { FournisseurDao fournisseurDao = new
	 * FournisseurDao(); Fournisseur fournisseur = new Fournisseur(); Fournisseur
	 * savedFournisseur = fournisseurDao.merge(fournisseur);
	 * Assertions.assertNotNull(savedFournisseur.getId()); }
	 */

	/*
	 * public Article merge(Article object) { EntityManager em =
	 * PersistenceSingleton.INSTANCE.createEntityManager(); EntityTransaction
	 * transaction = em.getTransaction(); transaction.begin(); Article merged =
	 * em.merge(object); transaction.commit(); em.close(); return merged; }
	 * 
	 * public Article findById(Long id) { EntityManager em =
	 * PersistenceSingleton.INSTANCE.createEntityManager(); return
	 * em.find(Article.class, id); }
	 * 
	 * public void remove(Long id) { EntityManager em =
	 * PersistenceSingleton.INSTANCE.createEntityManager(); EntityTransaction
	 * transaction = em.getTransaction(); transaction.begin();
	 * em.createQuery("delete from Example e where e.id = :id",
	 * Article.class).setParameter("id", id) .executeUpdate(); transaction.commit();
	 * em.close(); }
	 * 
	 */

	public List<Article> getParNomAvecFournisseur(String nomArticle) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		
		List<Article> articles = em
				.createQuery("from Article article " + " left outer join fetch article.fournisseur "
						+ " where article.nom = :nomArticle ", Article.class)
				.setParameter("nomArticle", nomArticle).getResultList();
		em.close();
		return articles;
	}

}

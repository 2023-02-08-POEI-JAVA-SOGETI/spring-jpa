package tp_spring_jpa_pablo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.dao.PersistenceSingleton;

import tp_spring_jpa_pablo.model.Article;

public class ArticleDao extends AbstractDao<Article> {		
	
	// JPQL requetes SQL en JPA
	public List<Article> getParNom(String nomArticle) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> laListeDesArticlesAvecLeBonNom = 
			em.createQuery("from Article where nom = :nomArticle", Article.class)
			.setParameter("nomArticle", nomArticle).getResultList();
		em.close();
		return laListeDesArticlesAvecLeBonNom;
	}
	/*	
	// JPQL requetes SQL en JPA
	public List<Article> getParNom2(String nomArticle2) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> laListeDesArticlesQuiCommenceParB = 
			em.createQuery("from Article where nom = :nomArticle2", Article.class)
			.setParameter("nomArticle2", "%" + "an" + "%").getResultList();
		em.close();
		return laListeDesArticlesQuiCommenceParB;
	}*/
	
}

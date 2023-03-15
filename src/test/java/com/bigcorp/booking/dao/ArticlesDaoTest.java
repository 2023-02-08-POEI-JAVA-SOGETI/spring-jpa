package com.bigcorp.booking.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Articles;


class ArticlesDaoTest {

	@Test
    public void testSave() {	
    	String etat = "T.bon etat";
    	
    	ArticlesDao articleDao = new ArticlesDao();
    	Articles article = new Articles();
		article.setEtat(etat);
    	
		Articles savedArticle = articleDao.merge(article);
		
		Assertions.assertNotNull(savedArticle.getId());
		
		Articles formationjava = (Articles) articleDao.findById(Articles.class, savedArticle.getId());		
		Assertions.assertEquals(etat, formationjava.getEtat());		
    }
	
	@Test
	public void testPersist() {
	    String etat = "Bon état";

	    ArticlesDao articleDao = new ArticlesDao(); //nouvelle instances de la classe ArticlesDo en utilisant son constructeur par defaut
	    Articles article = new Articles(); //nouvelle instance de la classe Articles en utilisant son constructeur par defaut
	    article.setEtat(etat);

	    articleDao.persist(article);

	    Articles savedArticle = (Articles) articleDao.findById(Articles.class, article.getId());
	    Assertions.assertEquals(etat, savedArticle.getEtat());
	}

    @Test
    public void testInsert() {
        Articles article = new Articles(0, "548", "Bien", "Bijoux", "Or");
        ArticlesDao articleDao = new ArticlesDao();
        articleDao.merge(article);
        assertNotNull(article.getId());
    }
	
    @Test
    public void testRemove() {
        String etat = "Mauvais état";

        ArticlesDao articleDao = new ArticlesDao();
        Articles article = new Articles();
        article.setEtat(etat);

        articleDao.persist(article);

        articleDao.remove(article);

        Articles removedArticle = (Articles) articleDao.findById(Articles.class, article.getId());
        Assertions.assertNull(removedArticle);
    }
  

}

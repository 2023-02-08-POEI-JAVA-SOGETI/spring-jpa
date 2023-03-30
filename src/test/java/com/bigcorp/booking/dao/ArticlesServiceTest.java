package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Articles;
import com.bigcorp.booking.model.EtatArticles;
import com.bigcorp.booking.service.ArticlesService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
class ArticlesServiceTest {

	@Autowired
	private ArticlesService articleService;	
	
	
	@BeforeEach
    public void setUp() throws Exception {			
		Articles a1 = new Articles(14, 145, "nom1", "description1", EtatArticles.NEUF);		
		Articles a2 = new Articles(15, 146, "nom2", "description2", EtatArticles.OCCASION);

        articleService.save(a1);
        articleService.save(a2);
    } 
	
	@Test
	public void testSaveGet() {
		Articles a1 = new Articles(14, 145, "nom1", "description1", EtatArticles.NEUF);
		Articles articleSauvegarde = articleService.save(a1);	
		Articles articleRecupere = articleService.findById(articleSauvegarde.getId());
		Assertions.assertEquals(articleRecupere.getId(), articleSauvegarde.getId());
	}

	@Test
	public void testDelete() {
	    Articles a2 = new Articles(15, 146, "nom2", "description2", EtatArticles.OCCASION);
	    Articles articleSauvegarde = articleService.save(a2);	    
	    Assertions.assertNotNull(articleService.findById(articleSauvegarde.getId()));
	    articleService.delete(articleSauvegarde.getId());
	    Assertions.assertNull(articleService.findById(articleSauvegarde.getId()));
	}

	@Test
	public void testFindAll() {
		Iterable<Articles> articles = articleService.findAll();
		Integer compteur = 0;
		for (Articles a : articles ) 
			compteur++;			
		Assertions.assertEquals(2, compteur);
	}
	
	@Test
	public void testFindById() {
		Articles a3 = new Articles(17, 245, "nom3", "description3", EtatArticles.NEUF);
		Articles articleSauvegarde = articleService.save(a3);
		Articles articleRecupere = this.articleService.findById(articleSauvegarde.getId());
		Assertions.assertEquals(articleSauvegarde.getId(), articleRecupere.getId());
	}
}

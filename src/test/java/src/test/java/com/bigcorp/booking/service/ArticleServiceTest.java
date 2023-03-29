package src.test.java.com.bigcorp.booking.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.service.exception.ArticleException;
import com.bigcorp.booking.service.exception.FournisseurException;
import com.bigcorp.booking.spring.SpringConfiguration;


@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private FournisseurService fournisseurService;
	

	@Test
	public void testSaveGet() throws ArticleException {
		Article article = new Article();
		article.setNom("Land Rover");
		article.setId(1);
		article.setNumero(54);
		article.setFC("f");
		article.setDescription("Pour aller aux champs");
		//article.setEtatArticle("OCCASION");
		
		
		Article articleSauvegarde = this.articleService.sauvegarde(article);
		Assertions.assertNotNull(articleSauvegarde);
		Assertions.assertNotNull(articleSauvegarde.getId());
		Article articleRecupere = this.articleService.findById(articleSauvegarde.getId());
		Assertions.assertNotNull(articleRecupere);
		this.articleService.supprimer(articleSauvegarde.getId());
		Assertions.assertNull(articleRecupere);
	}
	
	@Test
	public void testSaveGetByEtat() throws ArticleException {
		Article article = new Article();
		article.setNom("Jean-Spring");
		EtatArticle etatArticle = EtatArticle.NEUF;
		article.setEtatArticle(etatArticle);
		Article articleSauvegarde = this.articleService.sauvegarde(article);
		Assertions.assertNotNull(articleSauvegarde);
		Assertions.assertNotNull(articleSauvegarde.getId());
		List<Article> articles = this.articleService.findByEtatArticle(etatArticle);
		Assertions.assertFalse(articles.isEmpty());
	}
	
	@Test
	public void testAttache() throws FournisseurException, ArticleException {
		Article article = new Article();
		Article articleSauvegarde = this.articleService.sauvegarde(article);
}
}
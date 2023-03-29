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
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private FournisseurService fournisseurService;

	@Test
	public void testSaveGetByIdDelete() throws ArticleException {

		// Préparation des données de test
		Article article = new Article();
		article.setNom("Land Rover");
		article.setId(1);
		article.setNumero(54);
		article.setFC("f");
		article.setDescription("Pour aller aux champs");
		// article.setEtatArticle("OCCASION");

		// Test de la methode save=sauvegarde de articleService qui
		// est utilisée dans le ArticleRestController
		// On s'assure de la sauvegarde de l'enregistrement en base
		Article articleSauvegarde = this.articleService.sauvegarde(article);

		Assertions.assertNotNull(articleSauvegarde);
		Assertions.assertNotNull(articleSauvegarde.getId());

		// Test de la methode findById de articleService qui
		// est utilisée dans le ArticleRestController
		// On s'assure de la récupération de l'enregistrement précédente en base grace à
		// son id
		Article articleRecupere = this.articleService.findById(articleSauvegarde.getId());
		Assertions.assertNotNull(articleRecupere);

		// Test de la methode supprimer=delete de articleService qui
		// est utilisée dans le ArticleRestController
		// On s'assure que l'enregistrement précédement récupération grace à son id est
		// supprimé
		this.articleService.supprimer(articleSauvegarde.getId());
		Assertions.assertNull(this.articleService.findById(articleSauvegarde.getId()));
	}

	@Test
	public void testSaveGetByEtat() throws ArticleException {

		// Préparation des données de test
		Article article = new Article();
		article.setNom("Land Rover");
		article.setId(1);
		article.setNumero(54);
		article.setFC("f");
		article.setDescription("Pour aller aux champs");
		EtatArticle etatArticle = EtatArticle.NEUF;
		article.setEtatArticle(etatArticle);
		
		// Test de la methode findByEtatArticle de articleService qui 
		// est utilisée dans le ArticleRestController
		// On s'assure dabord de la sauvegarde de l'enregistrement en base
		Article articleSauvegarde = this.articleService.sauvegarde(article);
		Assertions.assertNotNull(articleSauvegarde);
		Assertions.assertNotNull(articleSauvegarde.getId());
		
		//On s'assure ensuite que l'enrégistrement récupéré n'est pas vite.
		List<Article> articles = this.articleService.findByEtatArticle(etatArticle);
		Assertions.assertFalse(articles.isEmpty());
	}

//	@Test
//	public void testAttache() throws FournisseurException, ArticleException {
//		Article article = new Article();
//		Article articleSauvegarde = this.articleService.sauvegarde(article);
//	}
}
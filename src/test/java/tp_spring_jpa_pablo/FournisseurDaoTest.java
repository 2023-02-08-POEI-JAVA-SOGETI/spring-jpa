package tp_spring_jpa_pablo;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import tp_spring_jpa_pablo.dao.ArticleDao;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Fournisseur;
import tp_spring_jpa_pablo.model.Fournisseur;

public class FournisseurDaoTest {
	@Test
    public void testSave() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		Assertions.assertNotNull(savedFournisseur.getId());
    }
	
	@Test
	public void testGetParNom() {
		FournisseurDao FournisseurDao = new FournisseurDao();
		Fournisseur fournisseur1 = new Fournisseur();		
		fournisseur1.setNom("EDF");
		FournisseurDao.merge(fournisseur1);
		
		Fournisseur Fournisseur2 = new Fournisseur();
		Fournisseur2.setNom("Tropical");
		FournisseurDao.merge(Fournisseur2);
		
		List<Fournisseur> Fournisseurs = FournisseurDao.getParNom("EDF");
		Assert.assertEquals(1, Fournisseurs.size());
	}	
	
	@Test
    public void testRelationBidirectionnelle() {
    	ArticleDao articleDao = new ArticleDao();

    	//Création des Articles
    	Article article1 = new Article();
    	Article article2 = new Article();
    	Article article3 = new Article();
		article1.setNom("Article Test Bidi");
		article2.setNom("Article2 Test Bidi");
		article3.setNom("Article3 Test Bidi");
		
		// List avec mes articles
		List<Article> articles = Arrays.asList(article1, article2, article3);

		//Création du Fournisseur
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("Fournisseur Test Bidi");
		fournisseur.getArticles().addAll(articles);

		//Sauvegarde du Fournisseur
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);		
				
		// Liaison des deux entités
		for (Article article : articles) {
		    article.setFournisseur(savedFournisseur);
		    Article savedArticle = articleDao.merge(article);
		    Assertions.assertNotNull(savedArticle.getId(), "The saved article should have an ID.");
		}		

    }
	
}

package tp_spring_jpa_pablo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import tp_spring_jpa_pablo.dao.ArticleDao;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Fournisseur;

public class ArticleDaoTest {
	@Test
    public void testSave() {
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		Article savedArticle = articleDao.merge(article);
		Assertions.assertNotNull(savedArticle.getId());		
    }
	
	@Test
	public void testGetParNom() {
		ArticleDao ArticleDao = new ArticleDao();
		Article article1 = new Article();
		String nomArticle1 = "Banana";
		article1.setNom(nomArticle1);
		ArticleDao.merge(article1);
		
		Article Article2 = new Article();
		Article2.setNom("Chocolat");
		ArticleDao.merge(Article2);
		
		List<Article> Articles = ArticleDao.getParNom(nomArticle1);
		Assert.assertEquals(1, Articles.size());
		
		/*List<Article> Articles2 = ArticleDao.getParNom2(nomArticle1);
		Assert.assertEquals(1, Articles2.size());*/
	}
	
	@Test
    public void testMergeAvecFournisseur() {
    	ArticleDao articleDao = new ArticleDao();

    	//Création de l'Article
    	Article article1 = new Article();
		article1.setNom("Article Test Bidi");

		//Création du Fournisseur
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("Fournisseur Test Bidi");

		//Sauvegarde du Fournisseur
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);

		//Liaison des deux entités
		article1.setFournisseur(savedFournisseur);

		//Sauvegarde de la leçon
		Article savedArticle = articleDao.merge(article1);

		Assertions.assertNotNull(savedArticle.getId());		

    }
	
	
}

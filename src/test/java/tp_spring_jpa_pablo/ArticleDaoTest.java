package tp_spring_jpa_pablo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

package tp_spring_jpa_pablo.main;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;

import tp_spring_jpa_pablo.dao.ArticleDao;
import tp_spring_jpa_pablo.dao.ClientDao;
import tp_spring_jpa_pablo.dao.EtatArticle;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.dao.UtilisateurDao;
import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Client;
import tp_spring_jpa_pablo.model.Fournisseur;
import tp_spring_jpa_pablo.model.Utilisateur;

public class Main3 {

	public static void main(String[] args) {		
		// Instantiating the classes        
        FournisseurDao fournisseurDao = new FournisseurDao();       
        ArticleDao articleDao = new ArticleDao();		

		//Création du Fournisseur
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("Fournisseur Test Bidi 2");
		
		
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		// List avec mes articles
		List<Fournisseur> articlesDuFournisseur = fournisseurDao.getArticlesFournisseur(savedFournisseur);
		//fournisseur.getArticles().addAll(articles);
		
		/*
	    // Liaison des deux entités
 		for (Article article : articlesDuFournisseur) {
 		    article.setFournisseur(savedFournisseur);
 		    Article savedArticle = articleDao.merge(article);
 		    Assertions.assertNotNull(savedArticle.getId(), "The saved article should have an ID.");
 		}*/

	}

}

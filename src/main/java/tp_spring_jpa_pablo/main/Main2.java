package tp_spring_jpa_pablo.main;

import java.util.Random;

import tp_spring_jpa_pablo.dao.ArticleDao;
import tp_spring_jpa_pablo.dao.ClientDao;
import tp_spring_jpa_pablo.dao.EtatArticle;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.dao.UtilisateurDao;
import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Client;
import tp_spring_jpa_pablo.model.Fournisseur;
import tp_spring_jpa_pablo.model.Utilisateur;

public class Main2 {

	public static void main(String[] args) {
		// Instantiating the classes
        Fournisseur fournisseur = new Fournisseur();
        FournisseurDao fournisseurDao = new FournisseurDao();
        Article article = new Article();
        ArticleDao articleDao = new ArticleDao();
        
        /*
        fournisseur.setAdresse("13 rue tabaga");
		fournisseur.setEmail("roberto@gmail.com");
		fournisseur.setNom("Roberto");
		fournisseur.setId(new Random().nextInt());
		
		article.setDescription("Test merge avec foreign key");
		article.setEtat(EtatArticle.INUTILISABLE);
		article.setNom("Test FK");
		article.setType("FK");
		article.setId(new Random().nextInt());*/
        
        // Add an Article with an article_id that's a Foreing Key in Fournisseur table
        Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
        article.setFournisseur(savedFournisseur);
        articleDao.merge(article);
        
                
        
        

	}

}

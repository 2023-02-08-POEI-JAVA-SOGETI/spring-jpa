package tp_spring_jpa_pablo.main;

import java.util.List;
import tp_spring_jpa_pablo.dao.ArticleDao;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Fournisseur;

public class Main3 {

	public static void main(String[] args) {		
		//Sauvegarde du Fournisseur
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		String nomFournisseur = "Fournisseur Test Bidi";
		fournisseur.setNom(nomFournisseur);		
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);

    	//Sauvegarde des Articles
		ArticleDao articleDao = new ArticleDao();
		Article newArticle1 = new Article();   	
		Article newArticle2 = new Article();   	
		Article newArticle3 = new Article();   	
		newArticle1.setNom("Bidi 1");
		newArticle2.setNom("Bidi 2");
		newArticle3.setNom("Bidi 3");
		
		// Rattachement
		newArticle1.setFournisseur(savedFournisseur);
		savedFournisseur.getArticles().add(newArticle1);
		newArticle2.setFournisseur(savedFournisseur);
		savedFournisseur.getArticles().add(newArticle2);
		newArticle3.setFournisseur(savedFournisseur);
		savedFournisseur.getArticles().add(newArticle3);
		
		// Sauvegarde
		articleDao.merge(newArticle1);
		articleDao.merge(newArticle2);
		articleDao.merge(newArticle3);
		
		List<Fournisseur> fournisseurs = fournisseurDao.getArticlesFournisseur(nomFournisseur);
		for (Fournisseur fournisseurLu : fournisseurs) {			
			System.out.println("Fournisseur nom : " + fournisseurLu.getNom() 
				+ "Nombre d'articles associes : " + fournisseurLu.getArticles().size());
			
		}
	}

}

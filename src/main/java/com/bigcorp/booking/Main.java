package com.bigcorp.booking;

import com.bigcorp.booking.dao.ArticleDaoEnAbstract;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.TypeArticle;

public class Main {
	public static void main(String[] args) {
		System.out.println("hey");
		
		/* 
		String nom = "Jack";
    	int num = 1000;
    	String email = "jack@mail.com";
    	String adresse = "3 rue du moulin";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom(nom);
		fournisseur.setNum(num);
		fournisseur.setEmail(email);
		fournisseur.setAdresse(adresse);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		*/
		
		int numArticle = 100;
    	TypeArticle type = TypeArticle.NEUF;
    	String nom  = "NVDIA GTX 3060";
    	String description = "Une superbe carte graphique";
    	ArticleDaoEnAbstract articleDao = new ArticleDaoEnAbstract();
    	Article article = new Article();
		article.setNumArticle(numArticle);
		article.setType(type);
		article.setNom(nom);
		article.setDescription(description);
    	
		Article savedArticle = articleDao.merge(article);
				
		
	}
}
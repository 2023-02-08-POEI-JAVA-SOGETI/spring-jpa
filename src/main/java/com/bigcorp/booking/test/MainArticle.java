package com.bigcorp.booking.test;

import com.bigcorp.booking.dao.ArticleDao;
import com.bigcorp.booking.dao.FournisseurDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;
import com.bigcorp.booking.model.Fournisseur;

public class MainArticle {

	
	public void testOneToMany() {
		
    	ArticleDao articleDao = new ArticleDao();
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	
    	// test insertion d'un article avec un fournisseur ayant déjà un id en base  	
    	Article a2 = new Article(2, Etat.NEUF.name(), "grue", "gru gru gru");
	
    	Fournisseur f2 = fournisseurDao.findById(14);

    	// affectation du fournisseur dans l'article
    	a2.setFournisseur(f2);
    	
    	Article savedArticle2 = articleDao.merge(a2);	
	}
	
	public static void testManyToOne() {
    	String nom = "Fournissor";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur(103, nom, "email_fournissor", "adresse_fournissor");
    	
    	Fournisseur savedFournisseur = fournisseurDao.merge(f);
		
    	ArticleDao articleDao = new ArticleDao();
    	Article a = new Article(3, Etat.NEUF.name(), "rateau", "ratisse");
    	Article a2 = new Article(4, Etat.NEUF.name(), "pioche", "pioche");
    	
    	a.setFournisseur(savedFournisseur);
    	a2.setFournisseur(savedFournisseur);

    	articleDao.merge(a);
    	articleDao.merge(a2);
	}
	
	public static void main(String[] args) {
		
//	  	Integer num_article = 1;
//    	String nom = "brouette";
//    	String description = "c'est bien pratique une brouette";
//    	
//    	ArticleDao articleDao = new ArticleDao();
//    	Article a = new Article(num_article, Etat.NEUF.name(), nom, description);
//	
//    	FournisseurDao fournisseurDao = new FournisseurDao();
//    	Fournisseur f = new Fournisseur(12, "black & d'equerre", "a@a.com", "adresse b&d");
//
//
//    	Fournisseur savedFournisseur = fournisseurDao.merge(f);
//
//    	// affectation du fournisseur dans l'article
//    	a.setFournisseur(savedFournisseur);
//    	
//    	Article savedArticle = articleDao.merge(a);		
//    	
		
		testManyToOne();
	}
}

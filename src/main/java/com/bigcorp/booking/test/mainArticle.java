package com.bigcorp.booking.test;

import java.util.Random;

import com.bigcorp.booking.dao.ArticleDao;
import com.bigcorp.booking.dao.FournisseurDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;
import com.bigcorp.booking.model.Fournisseur;

public class mainArticle {

	public static void main(String[] args) {
		
//	  	Integer num_article = 1;
//    	String nom = "brouette";
//    	String description = "c'est bien pratique une brouette";
//    	
    	ArticleDao articleDao = new ArticleDao();
//    	Article a = new Article(num_article, Etat.NEUF.name(), nom, description);
//	
    	FournisseurDao fournisseurDao = new FournisseurDao();
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
    	
    	// test insertion d'un article avec un fournisseur ayant déjà un id en base
	  	Integer num_article2 = 2;
    	String nom2 = "grue";
    	String description2 = "gru gru gru";
    	
    	Article a2 = new Article(2, Etat.NEUF.name(), nom2, description2);
	
    	Fournisseur f2 = fournisseurDao.findById(new Random().nextInt());

    	// affectation du fournisseur dans l'article
    	a2.setFournisseur(f2);
    	
    	Article savedArticle2 = articleDao.merge(a2);		
	}
}

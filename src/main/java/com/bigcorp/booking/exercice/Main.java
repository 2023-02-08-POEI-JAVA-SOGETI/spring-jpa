package com.bigcorp.booking.exercice;

import com.bigcorp.booking.exercice.dao.ArticleDao;
import com.bigcorp.booking.exercice.dao.FournisseurDao;
import com.bigcorp.booking.exercice.model.Article;
import com.bigcorp.booking.exercice.model.Fournisseur;
import com.bigcorp.booking.exercice.model.Type;

public class Main {

	public static void main(String[] args) {
		
		
		FournisseurDao fourDao = new FournisseurDao();
		ArticleDao artDao = new ArticleDao();
		
		Fournisseur fournisseur = new Fournisseur("Silvio", 
													05060304, 
													"Mon Email", 
													"Mon Adresse");
		
		Article article = new Article(0505, Type.ACHAT, "Article Test", "Description Test" );
		
		
//		fourDao.merge(fournisseur);
		Fournisseur findbyId = fourDao.findById(Fournisseur.class, 1);
		System.out.println(findbyId);
		
		artDao.merge(article);
		
		

	}

}

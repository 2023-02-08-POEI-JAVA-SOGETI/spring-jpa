package com.bigcorp.booking.dao;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Article.EtatArticle;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Utilisateur;

public class SampleLauncher {	
	public static void main(String[] args) {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur(667, "Foxconn Technology", "who@foxconn.com", "Mainland China");
		
		fournisseurDao.merge(fournisseur);
		
		Fournisseur fournisseurDeux = new Fournisseur(668, "Initex", "who@initex.com", "Taiwan");

		fournisseurDao.merge(fournisseurDeux);
		
		ArticleDao articleDao = new ArticleDao();
		Article article =  new Article(4678, "???", "iPhone 15 Pro Max", "New iPhone Pro series - 256GB storage capacity", EtatArticle.NEUF);
		
		articleDao.merge(article);
		
		ClientDao clientDao = new ClientDao();
		Client client =  new Client(878, "Cook", "Tim", "timcook@apple.com", "Apple QG - Cupertino, Californie, États-Unis");
		
		clientDao.merge(client);
		
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		Utilisateur utilisateur =  new Utilisateur(1204, "Siri", "Assistant", "assistant@siri.com", "dissiri", "queltempsfaitilaujourdhui?");
		
		utilisateurDao.merge(utilisateur);
	}
}

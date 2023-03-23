package com.bigcorp.booking.dao;

import java.util.List;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Article.EtatArticle;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Utilisateur;

import com.bigcorp.booking.service.FournisseurService;

public class SampleLauncher {
	public static void main(String[] args) {
		FournisseurService fournisseurService = new FournisseurService();
//		Fournisseur fournisseur = new Fournisseur(667, "Apple Inc.", "contact@apple.com",
//				"Cupertino, Californie, États-Unis");
//
//		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
//
//		Fournisseur fournisseurDeux = new Fournisseur(668, "Initex", "who@initex.com", "Taiwan");
//
//		Fournisseur savedFournisseurDeux = fournisseurDao.merge(fournisseurDeux);
//
//		ArticleDao articleDao = new ArticleDao();
//		Article article = new Article(4678, "???", "iPhone 15 Pro Max",
//				"New iPhone Pro series - 256GB storage capacity", EtatArticle.NEUF, savedFournisseur);
//
//		articleDao.merge(article);
//
//		ClientDao clientDao = new ClientDao();
//		Client client = new Client(878, "Cook", "Tim", "timcook@apple.com",
//				"Apple HQ - Cupertino, Californie, États-Unis");
//
//		clientDao.merge(client);
//
//		UtilisateurDao utilisateurDao = new UtilisateurDao();
//		Utilisateur utilisateur = new Utilisateur(1204, "Siri", "Assistant", "assistant@siri.com", "dissiri",
//				"queltempsfaitilaujourdhui?");
//
//		utilisateurDao.merge(utilisateur);
//
//		String articleName = "Rechargeable battery";
//		String fournisseurName = "Duracell";
//		Fournisseur fournisseurTrois = new Fournisseur();
//
//		fournisseurTrois.setNom(fournisseurName);
//		Fournisseur savedFournisseurTrois = fournisseurDao.merge(fournisseurTrois);
//
//		String utilisateurTroisName = "Doe";
//		Utilisateur utilisateurTrois = new Utilisateur();
//
//		utilisateurTrois.setNom(utilisateurTroisName);
//		Utilisateur savedUtilisateurTrois = utilisateurDao.merge(utilisateurTrois);
//
//		Article articleTrois = new Article();
//		articleTrois.setNom(articleName);
//		articleTrois.setDescription("New rechargeable batteries by Duracell");
//
//		articleTrois.associateWith(savedFournisseurTrois);
//		articleDao.merge(articleTrois);
//
//		String clientDeuxName = "Henry";
//		Client clientDeux = new Client();
//		
//		clientDeux.setNom(clientDeuxName);
//		clientDeux.associateWithFournisseur(savedFournisseurTrois);
//		clientDeux.associateWithUtilisateur(savedUtilisateurTrois);
//		
//		clientDao.merge(clientDeux);

		List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();

		System.out.println(fournisseurs);
//
//		List<Utilisateur> utilisateurs = utilisateurDao.fetchByNameWithClients(utilisateurTroisName);
//
//		System.out.println(utilisateurs);

	}
}

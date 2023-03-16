package com.bigcorp.booking.dao;

import java.util.List;
import java.util.Random;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Utilisateur;

public class RemplisseurBase {

	public static void main(String[] args) {

		//Création et sauvegarde d'un fournisseur
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setAdresse("13 rue tabaga");
		fournisseur.setEmail("roberto@gmail.com");
		fournisseur.setNom("Roberto");
		fournisseur.setNumero(new Random().nextInt());

		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseurSauvegarde = fournisseurDao.merge(fournisseur);
		
		//Création et sauvegarde d'un article
		Article article = new Article();
		article.setDescription("Joli");
		article.setEtatArticle(EtatArticle.INUTILISABLE);
		article.setNom("Arbre");
		article.setFc("F");
		article.setNumero(new Random().nextInt());
		article.associe(fournisseurSauvegarde);

		ArticleDao articleDao = new ArticleDao();
		articleDao.merge(article);


		//Création et sauvegarde d'un client
		Client client = new Client();
		client.setAdresse("5 rue du commerce");
		client.setEmail("el.cliento@user.br");
		client.setNom("cliento");
		client.setPrenom("el");
		client.setNumero(new Random().nextInt());
		client.associe(fournisseurSauvegarde);
		ClientDao clientDao = new ClientDao();
		Client clientSauvegarde = clientDao.merge(client);
		
		//Création et sauvegarde d'un utilisateur
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setLogin("admin");
		utilisateur.setEmail("jean-roger@gmail.com");
		utilisateur.setNom("roger");
		utilisateur.setNumero(new Random().nextInt());
		utilisateur.setMdp("secret!");
		utilisateur.setPrenom("jean");
		utilisateur.associe(clientSauvegarde);

		UtilisateurDao utilisateurDao = new UtilisateurDao();
		utilisateurDao.merge(utilisateur);
		
		//Lecture de l'utilisateur
		List<Utilisateur> utilisateursLus = utilisateurDao.getParNomAvecTout("roger");
		for(Utilisateur utilisateurLu : utilisateursLus) {
			System.out.println("Ai trouvé l'utilisateur : " + utilisateurLu.getNom());
			Client clientLu = utilisateurLu.getClient();
			System.out.println("Le client lié a le nom : " + clientLu.getNom());
			Fournisseur fournisseurLu = clientLu.getFournisseur();
			System.out.println("Le fournisseur lié a le nom : " + fournisseurLu.getNom());
			for(Article articleLu : fournisseurLu.getArticles()) {
				System.out.println("L'article lié a le nom : " + articleLu.getNom());
			}
			
			
		}

	}

}

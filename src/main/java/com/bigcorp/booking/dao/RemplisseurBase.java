package com.bigcorp.booking.dao;

import java.util.List;
import java.util.Random;

import com.bigcorp.booking.model.Articles;

import com.bigcorp.booking.model.Clients;
import com.bigcorp.booking.model.EtatArticles;
import com.bigcorp.booking.model.Fournisseurs;
import com.bigcorp.booking.model.Utilisateurs;

public class RemplisseurBase {

	public static void main(String[] args) {

		//Création et sauvegarde d'un fournisseur
		Fournisseurs fournisseur = new Fournisseurs();
		fournisseur.setAdresse("13 rue tabaga");
		fournisseur.setEmail("roberto@gmail.com");
		fournisseur.setNom("Roberto");
		fournisseur.setNumero(new Random().nextInt());

		FournisseursDao fournisseurDao = new FournisseursDao();
		Fournisseurs fournisseurSauvegarde = fournisseurDao.merge(fournisseur);
		
		//Création et sauvegarde d'un article
		Articles article = new Articles();
		article.setDescription("Joli");
		article.setEtatArticle(EtatArticles.INUTILISABLE);
		article.setNom("Arbre");
		article.setFc("F");
		article.setNumero(new Random().nextInt());
		article.associe(fournisseurSauvegarde);

		ArticlesDao articleDao = new ArticlesDao();
		articleDao.merge(article);


		//Création et sauvegarde d'un client
		Clients client = new Clients();
		client.setAdresse("5 rue du commerce");
		client.setEmail("el.cliento@user.br");
		client.setNom("cliento");
		client.setPrenom("el");
		client.setNumero(new Random().nextInt());
		client.associe(fournisseurSauvegarde);
		ClientsDao clientDao = new ClientsDao();
		Clients clientSauvegarde = clientDao.merge(client);
		
		//Création et sauvegarde d'un utilisateur
		Utilisateurs utilisateur = new Utilisateurs();
		utilisateur.setLogin("admin");
		utilisateur.setEmail("jean-roger@gmail.com");
		utilisateur.setNom("roger");
		utilisateur.setNumero(new Random().nextInt());
		utilisateur.setMdp("secret!");
		utilisateur.setPrenom("jean");
		utilisateur.associe(clientSauvegarde);

		UtilisateursDao utilisateurDao = new UtilisateursDao();
		utilisateurDao.merge(utilisateur);
		
		//Lecture de l'utilisateur
		List<Utilisateurs> utilisateursLus = utilisateurDao.getParNomAvecTout("roger");
		for(Utilisateurs utilisateurLu : utilisateursLus) {
			System.out.println("Ai trouvé l'utilisateur : " + utilisateurLu.getNom());
			Clients clientLu = utilisateurLu.getClients();
			System.out.println("Le client lié a le nom : " + clientLu.getNom());
			Fournisseurs fournisseurLu = clientLu.getFournisseur();
			System.out.println("Le fournisseur lié a le nom : " + fournisseurLu.getNom());
			for(Articles articleLu : fournisseurLu.getArticles()) {
				System.out.println("L'article lié a le nom : " + articleLu.getNom());
			}
			
			
		}

	}

}

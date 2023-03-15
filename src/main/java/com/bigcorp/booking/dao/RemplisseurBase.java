package com.bigcorp.booking.dao;

import java.util.Random;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Utilisateur;

public class RemplisseurBase {

	public static void main(String[] args) {

		Article article = new Article();
		article.setDescription("Joli");
		article.setEtatArticle(EtatArticle.INUTILISABLE);
		article.setNom("Arbre");
		article.setFc("F");
		article.setNumero(new Random().nextInt());

		ArticleDao articleDao = new ArticleDao();
		articleDao.merge(article);

		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setAdresse("13 rue tabaga");
		fournisseur.setEmail("roberto@gmail.com");
		fournisseur.setNom("Roberto");
		fournisseur.setNumero(new Random().nextInt());

		FournisseurDao fournisseurDao = new FournisseurDao();
		fournisseurDao.merge(fournisseur);

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setLogin("admin");
		utilisateur.setEmail("jean-roger@gmail.com");
		utilisateur.setNom("roger");
		utilisateur.setNumero(new Random().nextInt());
		utilisateur.setMdp("secret!");
		utilisateur.setPrenom("jean");

		UtilisateurDao utilisateurDao = new UtilisateurDao();
		utilisateurDao.merge(utilisateur);

		Client client = new Client();
		client.setAdresse("5 rue du commerce");
		client.setEmail("el.cliento@user.br");
		client.setNom("cliento");
		client.setPrenom("el");
		client.setNumero(new Random().nextInt());
		ClientDao clientDao = new ClientDao();
		clientDao.merge(client);

	}

}

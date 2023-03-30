package com.bigcorp.booking.dao;

import java.util.List;
import java.util.Random;

import com.bigcorp.booking.model.Animal;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.model.EtatSante;
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
		Article article1 = new Article();
		article1.setId(1);
		article1.setDescription("Jolie");
		article1.setEtatArticle(EtatArticle.NEUF);
		article1.setNom("Robe");
		article1.setFc("F");
		article1.setNumero(new Random().nextInt());
		article1.associe(fournisseurSauvegarde);

		ArticleDao articleDao1 = new ArticleDao();
		articleDao1.merge(article1);
		
		
		Article article2 = new Article();
		article2.setId(2);
		article2.setDescription("Grand");
		article2.setEtatArticle(EtatArticle.OCCASION);
		article2.setNom("Manteau");
		article2.setFc("D");
		article2.setNumero(new Random().nextInt());
		article2.associe(fournisseurSauvegarde);
		
		ArticleDao articleDao2 = new ArticleDao();
		articleDao2.merge(article2);
		
		
		Article article3 = new Article();
		article3.setId(3);
		article3.setDescription("Bleue");
		article3.setEtatArticle(EtatArticle.OCCASION);
		article3.setNom("Armoire");
		article3.setFc("Z");
		article3.setNumero(new Random().nextInt());
		article3.associe(fournisseurSauvegarde);
		
		ArticleDao articleDao3 = new ArticleDao();
		articleDao3.merge(article3);
		
		
		Article article4 = new Article();
		article4.setId(4);
		article4.setDescription("Portable");
		article4.setEtatArticle(EtatArticle.INUTILISABLE);
		article4.setNom("Ordinateur");
		article4.setFc("O");
		article4.setNumero(new Random().nextInt());
		article4.associe(fournisseurSauvegarde);
		
		ArticleDao articleDao4 = new ArticleDao();
		articleDao4.merge(article4);
		
		
		Article article5 = new Article();
		article5.setId(5);
		article5.setDescription("Yacht");
		article5.setEtatArticle(EtatArticle.NEUF);
		article5.setNom("Bateau");
		article5.setFc("B");
		article5.setNumero(new Random().nextInt());
		article5.associe(fournisseurSauvegarde);
		
		ArticleDao articleDao5 = new ArticleDao();
		articleDao5.merge(article5);
		
		

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
		
		//Création et sauvegarde d'un animal
		Animal animal = new Animal();
		animal.setId(1);
		animal.setSurnom("Loulou");
		animal.setEtatSante(EtatSante.SURPOIDS);
		animal.setEspece("Chat");
		animal.setPoids(4);
		animal.setProprietaire("Ellie");
		
		AnimalDao animalDao = new AnimalDao();
		Animal animalSauvegarde = animalDao.merge(animal);

		Animal animal2 = new Animal();
		animal2.setId(2);
		animal2.setSurnom("Rex");
		animal2.setEtatSante(EtatSante.CONVENABLE);
		animal2.setEspece("Chien");
		animal2.setPoids(12);
		animal2.setProprietaire("Jane");
		
		AnimalDao animalDao2 = new AnimalDao();
		Animal animalSauvegarde2 = animalDao2.merge(animal2);

		
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

package com.bigcorp.booking.model;

import com.bigcorp.booking.dao.ArticleDao;
import com.bigcorp.booking.dao.ClientDao;
import com.bigcorp.booking.dao.UtilisateurDao;


public class TpAvanceArticle {

	public static void main(String[] args) {
		// CREATE article in mysql
		String nom = "other webcam";
    	Integer numArticle = 852;
    	String description = "Description de la webcam";
    	Article tpArticle = new Article();
    	ArticleDao tpArticleDao = new ArticleDao();
		
		tpArticle.setNom(nom);
		tpArticle.setNumArticle(numArticle);
		tpArticle.setDescription(description);
		tpArticle.setType(TypeArticle.INUTILISABLE);
		
		Article savedTpArticle = tpArticleDao.merge(tpArticle);
		tpArticleDao.findById(Article.class, savedTpArticle.getId());
		
		//CREATE client in mysql
		String nomClient = "maxmax";
		String prenom = "max";
		Integer num = 321;
		String email = "max@max.com";
		String adresse = "chez max 01234 maxville";

		Client tpClient = new Client();
		ClientDao tpClientDao = new ClientDao();
		
		tpClient.setNom(nomClient);
		tpClient.setPrenom(prenom);
		tpClient.setNum(num);
		tpClient.setEmail(email);
		tpClient.setAdresse(adresse);
		
		Client savedTpClient = tpClientDao.merge(tpClient);
		tpClientDao.findById(Client.class, savedTpClient.getId());
		
		//CREATE utilisateur in mysql
		String nomUser = "loulou";
		String prenomUser = "lou";
		Integer numUser = 753;
		String emailUser = "lou@lou.com";
		String login = "lou";
		String password = "lou";

		Utilisateur tpUtilisateur = new Utilisateur();
		UtilisateurDao tpUtilisateurDao = new UtilisateurDao();
		
		tpUtilisateur.setNom(nomUser);
		tpUtilisateur.setPrenom(prenomUser);
		tpUtilisateur.setNum(numUser);
		tpUtilisateur.setEmail(emailUser);
		tpUtilisateur.setLogin(login);
		tpUtilisateur.setPassword(password);
		
		Utilisateur savedTpUtilisateur = tpUtilisateurDao.merge(tpUtilisateur);
		tpUtilisateurDao.findById(Utilisateur.class, savedTpUtilisateur.getId());
	}

}

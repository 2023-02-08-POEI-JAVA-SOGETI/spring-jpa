package com.bigcorp.booking.model;

import com.bigcorp.booking.dao.ArticleDao;
import com.bigcorp.booking.dao.ClientDao;
import com.bigcorp.booking.dao.FournisseurDao;
import com.bigcorp.booking.dao.UtilisateurDao;


public class TpAvanceArticleFourniss {

	public static void main(String[] args) {
		// CREATE article in mysql
    	Article tpArticle = new Article();
		
		tpArticle.setNom("super clavier");
		tpArticle.setNumArticle(159);
		tpArticle.setDescription("Description du super clavier");
		tpArticle.setType(TypeArticle.NEUF);
		
		//CREATE fournisseur qui sera associé à article
		Fournisseur tpFournisseur = new Fournisseur();
		tpFournisseur.setNom("Fournisseur de supers claviers");		
		tpFournisseur.setNum(5869);		
		tpFournisseur.setEmail("claviers@claiver.com");		
		tpFournisseur.setAdresse("1 rue des claviers 10000 clavierville");		
		
		//Sauvegarde du fournisseur
		FournisseurDao tpFournisseurDao = new FournisseurDao();
		Fournisseur savedTpFournisseur = tpFournisseurDao.merge(tpFournisseur);
		
		//Liaison article et fournisseur
		tpArticle.setFournisseur(savedTpFournisseur);
		
		//CREATE ArticleDao pour persister article en BDD
		ArticleDao tpArticleDao = new ArticleDao();
		
		//Sauvegarde article avec liaison au fournisseur  
		Article savedTpArticle = tpArticleDao.merge(tpArticle);
		
		tpArticleDao.findById(Article.class, savedTpArticle.getId());		
	}

}

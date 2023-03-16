package com.bigcorp.booking.model;

import com.bigcorp.booking.dao.ArticleDao;
import com.bigcorp.booking.dao.ClientDao;
import com.bigcorp.booking.dao.FournisseurDao;
import com.bigcorp.booking.dao.UtilisateurDao;


public class TpAvanceArticleFourniss {

	public static void main(String[] args) {
//		// CREATE article in mysql
//    	Article tpArticle = new Article();
//		
//		tpArticle.setNom("un autre super clavier");
//		tpArticle.setNumArticle(1579);
//		tpArticle.setDescription("Description du super clavier");
//		tpArticle.setType(TypeArticle.NEUF);
//		
//		//CREATE fournisseur qui sera associé à article
//		Fournisseur tpFournisseur = new Fournisseur();
//		tpFournisseur.setNom("Fournisseur de supers claviers");		
//		tpFournisseur.setNum(5869);		
//		tpFournisseur.setEmail("claviers@claiver.com");		
//		tpFournisseur.setAdresse("1 rue des claviers 10000 clavierville");		
//		
//		//Sauvegarde du fournisseur
//		FournisseurDao tpFournisseurDao = new FournisseurDao();
//		Fournisseur savedTpFournisseur = tpFournisseurDao.merge(tpFournisseur);
//		
//		//Liaison article et fournisseur
//		tpArticle.setFournisseur(savedTpFournisseur);
//		
//		//CREATE ArticleDao pour persister article en BDD
//		ArticleDao tpArticleDao = new ArticleDao();
//		
//		//Sauvegarde article avec liaison au fournisseur  
//		Article savedTpArticle = tpArticleDao.merge(tpArticle);
//		
//		tpArticleDao.findById(Article.class, savedTpArticle.getId());

		// CREATE article in mysql
    	Article tpArticle = new Article();
    	Article tpArticle2 = new Article();
    	
		tpArticle.setNom("un clavier très bien");
		tpArticle.setNumArticle(1579);
		tpArticle.setDescription("Description du clavier très bien");
		tpArticle.setType(TypeArticle.NEUF);
		
		tpArticle2.setNom("un autre clavier très bien");
		tpArticle2.setNumArticle(1580);
		tpArticle2.setDescription("Description de l'autre clavier très bien");
		tpArticle2.setType(TypeArticle.NEUF);
		
		//CREATE fournisseur qui sera associé à article
		Fournisseur tpFournisseur = new Fournisseur();
		tpFournisseur.setNom("Fournisseur de claviers très bien");		
		tpFournisseur.setNum(2365);		
		tpFournisseur.setEmail("claviers@claviers.com");		
		tpFournisseur.setAdresse("1 rue des claviers très biens 10000 claviertresbiensville");		
		
		//Sauvegarde du fournisseur
		FournisseurDao tpFournisseurDao = new FournisseurDao();
		Fournisseur savedTpFournisseur = tpFournisseurDao.merge(tpFournisseur);
		
		//Liaison article et fournisseur
		tpArticle.setFournisseur(savedTpFournisseur);
		tpArticle2.setFournisseur(savedTpFournisseur);
		
		//CREATE ArticleDao pour persister article en BDD
		ArticleDao tpArticleDao = new ArticleDao();
		
		//Sauvegarde article avec liaison au fournisseur  
		Article savedTpArticle = tpArticleDao.merge(tpArticle);
		Article savedTpArticle2 = tpArticleDao.merge(tpArticle2);
		
		tpArticleDao.findById(Article.class, savedTpArticle.getId());
		
	}

}

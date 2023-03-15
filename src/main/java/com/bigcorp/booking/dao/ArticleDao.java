package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;



import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseurs;


public class ArticleDao extends AbstractDao<Article> {

	public List<Article> getParNom(String nomArticle){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> laListeDesArticlesAvecLeBonNom 
			= em.createQuery("from Article where upper (nom) like upper (:nomArticle)", Article.class)
			.setParameter("nomArticle", nomArticle).getResultList();
		em.close();
		return laListeDesArticlesAvecLeBonNom;
	}
	
	public static void main(String[] args) {
		ArticleDao articleDao = new ArticleDao();
    	Article article1 = new Article();
    	article1.setNom("DS3");
    	article1.setNumeroUnique(453435);
    	Fournisseurs fournisseur = new Fournisseurs();
    	fournisseur.setNom("Emile");
    	fournisseur.setNumeroUnique(4452);
    	FournisseursDao fournisseurDAO = new FournisseursDao();
    	Fournisseurs savedFournisseur = fournisseurDAO.merge(fournisseur);
    	
    	article1.setFournisseur(savedFournisseur);
    	Article savedArticle = articleDao.merge(article1);
    	

}}

package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseurs;

public class FournisseursDao extends AbstractDao<Fournisseurs> {

	public List<Fournisseurs> getFournisseurEtArticlesAssocies(String nomFournisseurs){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseurs> Fournisseur
			= em.createQuery("from Fournisseurs f"
					+ " left outer join fetch f.articles "
					+ " where f.nom = :nomFournisseurs", Fournisseurs.class)
			.setParameter("nomFournisseurs", nomFournisseurs).getResultList();
		em.close();
		return Fournisseur;
	}
	
	
	public static void main(String[] args) {
		/*String nom = "Jean-Jacques";
		
    	FournisseursDao fournisseursDao = new FournisseursDao();
    	Fournisseurs fournisseurs = new Fournisseurs();
		fournisseurs.setNom(nom);
		fournisseurs.setNumeroUnique(45);
    	
		Fournisseurs savedFournisseurs = fournisseursDao.merge(fournisseurs);*/
		ArticleDao articleDao = new ArticleDao();
    	Article article1 = new Article();
    	article1.setNom("DS3");
    	article1.setNumeroUnique(878941454);
    	Article article2 = new Article();
    	article2.setNom("DS2");
    	article2.setNumeroUnique(48147564);
    	Fournisseurs fournisseur = new Fournisseurs();
    	fournisseur.setNom("Emile2");
    	fournisseur.setNumeroUnique(845415741);
    	fournisseur.getArticles().add(article2);
    	fournisseur.getArticles().add(article1);
    	FournisseursDao fournisseurDAO = new FournisseursDao();
    	Fournisseurs savedFournisseur = fournisseurDAO.merge(fournisseur);
    	
    	article1.setFournisseur(savedFournisseur);
    	article2.setFournisseur(savedFournisseur);
    	Article savedArticle1 = articleDao.merge(article1);
    	Article savedArticle2 = articleDao.merge(article2);
    	
    	List<Fournisseurs> fournisseurFinal = fournisseurDAO.getFournisseurEtArticlesAssocies("Emile");
    	
    	int numberOfArticles = fournisseurFinal.get(0).getArticles().size();
    
}}

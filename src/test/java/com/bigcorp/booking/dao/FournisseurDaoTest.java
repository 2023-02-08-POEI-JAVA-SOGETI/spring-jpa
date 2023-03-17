package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;
import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Jean-Jacques";
    	String email = "Email de Jean-Jacques";
    	String adresse = "Adresse de Jean-Jacques";
    	Integer numero = 1;
    	
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur(numero, nom, email, adresse);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(f);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseur exampleDeLaBaseDeDonnees = fournisseurDao.findById(savedFournisseur.getId());
		Assertions.assertEquals(nom, exampleDeLaBaseDeDonnees.getNom());
		
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "Jean-Paul";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur();
    	f.setNom(nom);
		f.setAdresse("ma nouvelle adresse");
		f.setEmail("jp email");
		f.setNumero(99);

		Fournisseur savedFournisseur = fournisseurDao.merge(f);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		
    }
    
    @Test
    public void testSave3() {
    	
    	String nom = "FournisseurTest";
    	FournisseurDao fournisseurDao = new FournisseurDao();
  
    	Fournisseur f = new Fournisseur(100, nom, "email", "adresse");
    	fournisseurDao.merge(f);
    	
    	List<Fournisseur> listFournisseur = fournisseurDao.getParNom(nom);
    	
    	Assertions.assertEquals(1, listFournisseur.size());
    }    
    
    @Test
    public void testSave4() {
    	
    	String nom = "FournisseurBiduleTest";
    	FournisseurDao fournisseurDao = new FournisseurDao();
  
    	Fournisseur f = new Fournisseur(101, nom, "email", "adresse");
    	fournisseurDao.merge(f);
    	
    	List<Fournisseur> listFournisseur = fournisseurDao.getParSousChaineNom("bidule");
    	
    	Assertions.assertEquals(1, listFournisseur.size());
    }    
    
    @Test
    public void testSave5() {
    	
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	List<Fournisseur> listFournisseur = fournisseurDao.getParSousChaineNom("Bidule");
    	
    	Assertions.assertEquals(1, listFournisseur.size());
    }    
    
    //Test du OneToMany sur les articles
    @Test
    public void testSave6() {
    	
    	String nom = "Fournisseur";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur(102, nom, "email", "adresse");

    	
    	ArticleDao articleDao = new ArticleDao();
    	Article a = new Article(3, Etat.NEUF.name(), "rateau", "ratisse");
    	Article a2 = new Article(4, Etat.NEUF.name(), "pioche", "pioche");

    	f.getArticles().add(a);
    	f.getArticles().add(a2);
    	
    	Fournisseur savedFournisseur = fournisseurDao.merge(f);
    	a.setFournisseur(savedFournisseur);
    	a2.setFournisseur(savedFournisseur);
    	
    	articleDao.merge(a);
    	articleDao.merge(a2);
		
		Assertions.assertNotNull(savedFournisseur.getId());
    	Assertions.assertEquals(f.getArticles().size(), savedFournisseur.getArticles().size());	
    }    
    
    //Test du OneToMany sur les articles
    @Test
    public void testSave7() {
    	
    	String nom = "Fournissor";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur(103, nom, "email", "adresse");
    	
    	Fournisseur savedFournisseur = fournisseurDao.merge(f);
		Assertions.assertNotNull(savedFournisseur.getId());
		
    	ArticleDao articleDao = new ArticleDao();
    	Article a = new Article(3, Etat.NEUF.name(), "rateau2", "ratisse");
    	Article a2 = new Article(4, Etat.NEUF.name(), "pioche2", "pioche");
    	
    	a.setFournisseur(savedFournisseur);
    	a2.setFournisseur(savedFournisseur);

    	articleDao.merge(a);
    	articleDao.merge(a2);
    	
		List<Fournisseur> fournisseurs = fournisseurDao.getArticlesByFournisseur(f.getNom());
		Assertions.assertNotNull(fournisseurs);
    	Assertions.assertFalse(fournisseurs.isEmpty());	
    	
    	Assertions.assertEquals(2, fournisseurs.get(0).getArticles().size());
    }
}
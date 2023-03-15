package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Utilisateur;

public class UtilisateurDaoTest {
	  
    @Test
    public void testSave() {
    	
    	//Arrange
		UtilisateurDao dao = new UtilisateurDao();
		Utilisateur utilisateur = new Utilisateur();
		String nomUtilisateur = "Dupont";
		String loginUtilisateur = "admin";
		
		utilisateur.setNom(nomUtilisateur);
		utilisateur.setLogin(loginUtilisateur);
		//Faire de même pour les autres attributs...
		
		//Act 
		Utilisateur utilisateurSauvegarde = dao.merge(utilisateur);
		
		//Assert
		Assertions.assertNotNull(utilisateurSauvegarde.getId());
		
		//Act
		Utilisateur utilisateurLu = dao.findById(Utilisateur.class,utilisateurSauvegarde.getId());
		
		//Assert
		Assertions.assertEquals(nomUtilisateur, utilisateurLu.getNom());
		Assertions.assertEquals(loginUtilisateur, utilisateurLu.getLogin());
		//Faire de même pour les autres attributs...
		
    }
    
    public void testPersist() {
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		Utilisateur utilisateur = new Utilisateur();
		String nomUtilisateur = "jean";
		
		utilisateur.setNom(nomUtilisateur);
		utilisateurDao.persist(utilisateur);
		
		Assertions.assertNotNull(utilisateur.getId());
    }
	  
   
}
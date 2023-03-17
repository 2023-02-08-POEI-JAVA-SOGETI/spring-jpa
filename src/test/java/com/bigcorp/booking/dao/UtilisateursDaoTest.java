package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Utilisateurs;

public class UtilisateursDaoTest {
	  
    @Test
    public void testSave() {
    	
    	//Arrange
		UtilisateursDao dao = new UtilisateursDao();
		Utilisateurs utilisateur = new Utilisateurs();
		String nomUtilisateur = "Dupont";
		String loginUtilisateur = "admin";
		
		utilisateur.setNom(nomUtilisateur);
		utilisateur.setLogin(loginUtilisateur);
		//Faire de même pour les autres attributs...
		
		//Act 
		Utilisateurs utilisateurSauvegarde = dao.merge(utilisateur);
		
		//Assert
		Assertions.assertNotNull(utilisateurSauvegarde.getId());
		
		//Act
		Utilisateurs utilisateurLu = dao.findById(Utilisateurs.class,utilisateurSauvegarde.getId());
		
		//Assert
		Assertions.assertEquals(nomUtilisateur, utilisateurLu.getNom());
		Assertions.assertEquals(loginUtilisateur, utilisateurLu.getLogin());
		//Faire de même pour les autres attributs...
		
    }
    
    public void testPersist() {
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateurs utilisateur = new Utilisateurs();
		String nomUtilisateur = "jean";
		
		utilisateur.setNom(nomUtilisateur);
		utilisateurDao.persist(utilisateur);
		
		Assertions.assertNotNull(utilisateur.getId());
    }
	  
   
}
package com.bigcorp.booking.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.UtilisateurService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class UtilisateurSpringTest {
	@Autowired
	public UtilisateurService utilisateurService;

	
	@Test
	public void testSave() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("doe");
		utilisateur.setPrenom("john");
		utilisateur.setNumero_employee(4012);
		utilisateur.setEmail("johndoe@gmail.com");
		utilisateur.setLogin("johndoe");
		utilisateur.setMot_de_passe("123456");
		
		Utilisateur savedUtilisateur = utilisateurService.save(utilisateur);
		
		Assertions.assertEquals(savedUtilisateur.getNom(), utilisateurService.findByName("doe").getNom());
		
	}
}

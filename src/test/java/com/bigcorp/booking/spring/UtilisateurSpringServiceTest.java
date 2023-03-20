package com.bigcorp.booking.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.spring.UtilisateurSpringService;


@SpringJUnitConfig(SpringConfiguration.class)
public class UtilisateurSpringServiceTest {
	
	@Autowired
	private UtilisateurSpringService utilisateurService;

	@Test
	public void test() {
		Utilisateur utilisateur1 = new Utilisateur();
		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur1.setNom("Test");
		utilisateur1.setNumero(123);
		utilisateur2.setNom("Test");
		utilisateur2.setNumero(456);
		utilisateurService.save(utilisateur2);
		utilisateurService.save(utilisateur1);
		List<Utilisateur> resultTest = utilisateurService.findContainingName("Test");
		Assertions.assertEquals(2, resultTest.size());
	}

}

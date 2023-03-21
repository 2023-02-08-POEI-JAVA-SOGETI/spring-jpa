package com.bigcorp.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.TypeArticle;
import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.ClientService;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.service.UtilisateurService;
import com.bigcorp.booking.spring.SpringConfiguration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SpringJUnitConfig(SpringConfiguration.class)
public class TestAppSpring {

	@Autowired
	private FournisseurService fournisseurService;

	@Test
	@DisplayName("Testing if service correctly saves a fournisseur")
	public void testSaveFournisseur() {
		Fournisseur fournisseur = new Fournisseur(1, "Mega Supply", "supply@mail.com", "3 rue du moulin");
		fournisseurService.save(fournisseur);
		Assertions.assertNotNull(fournisseur);
		Assertions.assertNotNull(fournisseur.getId());

	}
	
	@Autowired
	private ArticleService articleService;

	@Test
	@DisplayName("Testing if service correctly saves a article")
	public void testSaveArticle() {
		Article article = new Article(3, "Souris Logitech", "Une souris performante.", TypeArticle.NEUF);
		articleService.save(article);
		Assertions.assertNotNull(article);
		Assertions.assertNotNull(article.getId());

	}
	
	@Autowired
	private UtilisateurService utilisateurService;

	@Test
	@DisplayName("Testing if service correctly saves a utilisateur")
	public void testSaveUtilisateur() {
		Utilisateur utilisateur = new Utilisateur(1, "Dupont", "Jacques", "jacques.dupont@mail.com", "jdupont", "password");
		utilisateurService.save(utilisateur);
		Assertions.assertNotNull(utilisateur);
		Assertions.assertNotNull(utilisateur.getId());

	}
	
	@Autowired
	private ClientService clientService;

	@Test
	@DisplayName("Testing if service correctly saves a client")
	public void testSaveClient() {
		Client client = new Client(1, "Dupont", "Jacques", "jacques.dupont@mail.com", "4 rue des Lilas");
		clientService.save(client);
		Assertions.assertNotNull(client);
		Assertions.assertNotNull(client.getId());

	}
}
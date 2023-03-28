package com.bigcorp.booking.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseurs;
import com.bigcorp.booking.service.spring.ArticleSpringService;
import com.bigcorp.booking.service.spring.FournisseurSpringService;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleSpringServiceTest {

	@Autowired
	private ArticleSpringService articleService;
	@Autowired
	private FournisseurSpringService fournisseurService;

	@Test
	public void saveAndFindName() {
		Article article1 = new Article();
		Article article2 = new Article();
		article1.setNom("Test");
		article1.setNumeroUnique(123);
		article2.setNom("rest");
		article2.setNumeroUnique(456);
		articleService.save(article2);
		articleService.save(article1);
		List<Article> resultTest = articleService.findContainingName("Test");
		Assertions.assertEquals(1, resultTest.size());
	}

	@Test
	public void saveAndFindNumeroUnique() {
		Article article1 = new Article();
		Article article2 = new Article();
		article1.setNom("sdfsdf");
		article1.setNumeroUnique(865363);
		article2.setNom("hfhfgh");
		article2.setNumeroUnique(456456);
		articleService.save(article2);
		articleService.save(article1);
		Article resultTest = articleService.findNumeroUnique(456456);
		Assertions.assertNotNull(resultTest);
	}

	@Test
	public void saveWithFournisseur() {
		Article article1 = new Article();
		Fournisseurs fourn2 = new Fournisseurs();
		article1.setNom("Dark Souls");
		article1.setNumeroUnique(785);
		fourn2.setNom("Revo");
		fourn2.setNumeroUnique(78663);
		articleService.save(article1);
		fournisseurService.save(fourn2);
		articleService.saveWithFournisseur(article1.getiD(), fourn2.getiD());
		Article nouvelArticle = articleService.findById(article1.getiD());
		Assertions.assertEquals(nouvelArticle.getFournisseur().getiD(), fourn2.getiD());
	}

	@Test
	public void saveAndDelete() {
		Article article1 = new Article();
		Article article2 = new Article();
		article1.setNom("Elden");
		article1.setNumeroUnique(1234);
		article2.setNom("Elden");
		article2.setNumeroUnique(4567);
		articleService.save(article2);
		articleService.save(article1);
		Article articleToDelete = articleService.findNumeroUnique(4567);
		int articleToDeleteId = articleToDelete.getiD();
		articleService.delete(articleToDeleteId);
		List<Article> resultTest = articleService.findContainingName("Elden");
		Assertions.assertEquals(1, resultTest.size());
	}

	@Test
	public void saveAndUpdate() {
		Article article1 = new Article();
		Article article2 = new Article();
		Article article3 = new Article();
		article1.setNom("Apex");
		article1.setNumeroUnique(896);
		article2.setNom("Apex");
		article2.setNumeroUnique(854);
		articleService.save(article2);
		articleService.save(article1);
		Article articleToUpdate = articleService.findNumeroUnique(854);
		int articleToUpdateId = articleToUpdate.getiD();
		article3.setiD(articleToUpdateId);
		article3.setNom("Hunt");
		articleService.save(article3);
		List<Article> resultTest = articleService.findContainingName("Apex");
		Assertions.assertEquals(1, resultTest.size());
	}

}

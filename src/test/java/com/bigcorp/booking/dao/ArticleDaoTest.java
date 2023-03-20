package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.model.Fournisseur;

public class ArticleDaoTest /* extends AbstractDao<Article>*/ {

	@Test

	public void testSave() {
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		article.setNom("Jaguar");
		article.setDescription("pour se faire plaisir");
		article.setNumero(10);
		article.setId(1);
		article.setFC("abc");

		Article article1 = new Article();
		article1.setNom("Ferrari");
		article1.setDescription("pour rouller vite");
		article1.setNumero(9);
		article1.setId(2);
		article1.setFC("def");

		Article savedArticle = articleDao.merge(article);
		Assertions.assertNotNull(savedArticle.getId());

		Article savedArticle1 = articleDao.merge(article1);
		Assertions.assertNotNull(savedArticle1.getId());
	}

	@Test
	public void testMergeAvecFournisseur() {
		// Sauvegarde fournisseur
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur fournisseurSauvegarde = fournisseurDao.merge(fournisseur);

		// Sauvegarde article
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();

		// Rattachement
		article.setFournisseur(fournisseurSauvegarde);

		Article articleSauvegarde = articleDao.merge(article);

		Assertions.assertNotNull(articleSauvegarde.getId());

		Article articleLu = articleDao.findById(Article.class, articleSauvegarde.getId());

		Assertions.assertEquals(fournisseurSauvegarde.getId(), articleLu.getFournisseur().getId());

	}
}
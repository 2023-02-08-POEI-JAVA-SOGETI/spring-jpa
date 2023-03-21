package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.TypeArticle;

public class TestArticleDaoGetByName {

	@Test
	public void testGetParNom() {
		ArticleDaoEnAbstract articleDao = new ArticleDaoEnAbstract();
		Article article1 = new Article();
		String nomDurand = "leNomDurandDuTestGetParNom";
		article1.setNom(nomDurand);
		articleDao.merge(article1);

		Article article2 = new Article();
		article2.setNom(nomDurand);
		articleDao.merge(article2);

		List<Article> articles = articleDao.getParNom(nomDurand);
		Assertions.assertEquals(2, articles.size());

	}

	@Test
	public void testGetParSousChaineNom() {
		ArticleDaoEnAbstract articleDao = new ArticleDaoEnAbstract();
		Article article1 = new Article();
		String nomDurand = "leNomDurandDuTestGetParNom";
		article1.setNom(nomDurand);
		articleDao.merge(article1);

		Article article2 = new Article();
		article2.setNom(nomDurand);
		articleDao.merge(article2);

		List<Article> articles = articleDao.getParSousChaineNom("leNom");
		Assertions.assertEquals(2, articles.size());

	}



}
package com.bigcorp.booking.dao;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.model.Fournisseurs;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nom = "test2";
EtatArticle etat = EtatArticle.INUTILISABLE;
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		article.setNom(nom);
		article.setEtat(etat);
		article.setNumeroUnique(459);

		Article savedArticle = articleDao.merge(article);
	}

}

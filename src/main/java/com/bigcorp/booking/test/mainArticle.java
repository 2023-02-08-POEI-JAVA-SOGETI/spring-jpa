package com.bigcorp.booking.test;

import com.bigcorp.booking.dao.ArticleDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;

public class mainArticle {

	public static void main(String[] args) {
		String nom = "tarte";
		Integer numero = 22;
		String description = "pour utiliser la pelle";
		
		ArticleDao da = new ArticleDao();
		Article a = new Article(numero, Etat.etat.OCCASION.name(), nom, description);
		
		Article savedArticle = da.merge(a);
	}
}

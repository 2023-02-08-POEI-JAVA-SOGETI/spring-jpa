package com.bigcorp.booking.test;

import com.bigcorp.booking.dao.ArticleDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;

public class mainArticle {

	public static void main(String[] args) {
		
		ArticleDao da = new ArticleDao();
		Article a = new Article(23, Etat.OCCASION.name(), "pelle", 
				"une belle pelle, shiny and chrome");
		Article savedArticle = da.merge(a);
	}
}

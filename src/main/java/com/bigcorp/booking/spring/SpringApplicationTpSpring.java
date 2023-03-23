package com.bigcorp.booking.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.spring.ArticleSpringService;

public class SpringApplicationTpSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				SpringConfiguration.class)) {
			ArticleSpringService articleSpringService = appContext.getBean("articleSpringService",
					ArticleSpringService.class);
			Iterable<Article> foundIterable = articleSpringService.findAll();
			for (Article article : foundIterable) {
				System.out.println(article.getNom());
			}


		}
	}

}

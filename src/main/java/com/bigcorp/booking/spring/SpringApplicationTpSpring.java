package com.bigcorp.booking.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.spring.ArticleSpringService;

public class SpringApplicationTpSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			ArticleSpringService articleSpringService 
			= appContext.getBean("articleSpringService", ArticleSpringService.class);
			List<Article> result = articleSpringService.findContainingName("jojo");
			for (Article element : result) {
			    System.out.println(element.getNom());
			}
		}
	}

}

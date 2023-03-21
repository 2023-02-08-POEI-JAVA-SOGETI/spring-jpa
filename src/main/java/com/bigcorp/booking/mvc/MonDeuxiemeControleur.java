package com.bigcorp.booking.mvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.spring.ArticleSpringService;
import com.bigcorp.booking.spring.SpringConfiguration;

@Controller
public class MonDeuxiemeControleur {
	@RequestMapping("/coucou")
    public String showPageCoucou() {
    	System.out.println("Le contrôleur de coucou agit ! ");
        return "vue-coucou";
    }
	@ModelAttribute("monMessage")
	public String metDansLeContexteMonMessage() {
	return "Ma couleur préférée c'est le caca d'oie";
	}
	@ModelAttribute("monPojo")
	public PojoSpring metDansLeContexteMonPojo() {
	PojoSpring pojoSpring = new PojoSpring();
	pojoSpring.setNom("Emile");
	return pojoSpring;
	}
	/*@ModelAttribute("maListe")
	public Iterable<Article> metMaListe(){
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				SpringConfiguration.class)) {
			ArticleSpringService articleSpringService = appContext.getBean("articleSpringService",
					ArticleSpringService.class);
			Iterable<Article> foundIterable = articleSpringService.findAll();
			return foundIterable;

		}
	}*/
	@ModelAttribute("maListe")
	public PojoSpring metMaListe() {
	PojoSpring pojoSpring = new PojoSpring();
	
	return pojoSpring;
	}
}

package com.bigcorp.booking.mvc;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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


	pojoSpring.setiD(47);
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
	@RequestMapping("/details")
	private ModelAndView afficheDetails(@RequestParam("iD") int id) {
	System.out.println("J'affiche le détail de la planète : " + id);
	ModelAndView mav = new ModelAndView();
	mav.setViewName("details");
	PojoSpring pojoSpring2 = new PojoSpring();
	pojoSpring2.setNom("test");
	mav.addObject("detailsModel", pojoSpring2);
	return mav;
	}
	@RequestMapping("/details/{iD}")
	private ModelAndView afficheDetailsParChemin(@PathVariable("iD") int id) {
	System.out.println("J'affiche le détail de la planète à partir du chemin : " +
	id);
	ModelAndView mav = new ModelAndView();
	mav.setViewName("details");
	PojoSpring pojoSpring2 = new PojoSpring();
	pojoSpring2.setNom("test");
	mav.addObject("detailsModel", pojoSpring2);
	return mav;
	}

}

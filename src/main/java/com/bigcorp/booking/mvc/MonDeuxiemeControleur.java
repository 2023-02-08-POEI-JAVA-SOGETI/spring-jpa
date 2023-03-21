package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

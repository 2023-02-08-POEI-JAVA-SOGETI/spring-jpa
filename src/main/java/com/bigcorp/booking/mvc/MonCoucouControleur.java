package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Camion;

@Controller
public class MonCoucouControleur {

	@RequestMapping("/coucou")
	public String aQueCoucou() {
		System.out.println("Coucou ! ");
		return "vue-coucou";
	}
	
	@ModelAttribute("monTexte")
	public String getMonTexte(){
		return "Mon Texte Dynamique";
	}
	
	@ModelAttribute("camion")
	public Camion getCamion(@RequestParam(required = false) Integer id) {
		return new Camion("C'est le plus beau des camions - id=" + id);
	}
	
	@ModelAttribute("condition")
	public int getCondition() {
		return 1;
	}
	
	@ModelAttribute("liste")
	public List<Camion> getCamions(){
		Camion a = new Camion("a");
		Camion b = new Camion("b");
		Camion c = new Camion("c");
		List<Camion> liste = new ArrayList<>();
		
		liste.add(a);
		liste.add(b);
		liste.add(b);
		
		return liste;
	}
	
	@ModelAttribute("identifiant")
	public int getIdentifiant() {
		return 3;
	}
	
	@RequestMapping("/coucou/{numero}")
	public ModelAndView afficheCamionId(@PathVariable("numero") Integer num) {
		System.out.println("Coucou ! " + num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vue-coucou");
		mav.addObject("newCamion", new Camion(2, "pouet"));
		return mav;
	}
}

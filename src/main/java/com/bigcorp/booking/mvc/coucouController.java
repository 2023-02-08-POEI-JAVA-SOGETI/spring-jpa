package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigcorp.booking.service.Animaux;

@Controller
public class coucouController {
	
	@RequestMapping("/coucou")
    public String showSayHello() {
    	System.out.println("Le contrôleur de coucou agit ! ");
        return "vue-coucou";
    }
	

	
	// message dans controller
	@ModelAttribute("message")
	public String getMessage() {
		return "Ton cours est genial !";
		
	}
	
	//itérable de String (une liste par exemple)
	@ModelAttribute("stagiaire")
	public List<String> getStagiaire() {
	    List<String> stagiaires = Arrays.asList("Khadidja", "Maxime", "Lucas");
	    return stagiaires;
	}
	
	//Ajoutez dans votre page deux URLs dynamiques : une avec un paramètre de requête et une avec un paramètre dans l'URL :
	//Ex : ma-page?id=45 ma-page/45

	@ModelAttribute("listAnimaux")
	public List<Animaux> afficheListAnimaux() {
	    List<Animaux> listeAnimaux = new ArrayList<>();

	    Animaux an1 = new Animaux();
	    
	    an1.setNom("chat1");
	    an1.setId(45);
	    listeAnimaux.add(an1);

	    Animaux an2 = new Animaux();
	    an2.setNom("chien1");
	    an2.setId(45);
	    listeAnimaux.add(an2);

	    return listeAnimaux;
	}

	 
	
	 @RequestMapping("/animaux")
	 public String showAnimaux(@RequestParam(required = false) Integer id, Model model) {
	     System.out.println("Les animaux : " + id);
	     model.addAttribute("id", id);
	     return "animaux";
	 }
	 
	 @RequestMapping("/animaux/{id}")
	 public String showAnimauxWithPathVariable(@PathVariable Integer id, Model model) {
	     System.out.println("Les animaux : " + id);
	     model.addAttribute("id", id);
	     return "animaux";
	 }

}

package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.service.FournisseurService;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller //indique à spring que la classe peut traiter des requetes http
public class MonPremierControleur {
    
	@Autowired
	private FournisseurService fournisseurService; 
    
    /**
     * Intercepte les requêtes /salut , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue salut.
     * @return
     */
    @RequestMapping("/salut")
    public String showSayHello() {
    	System.out.println("Le contrôleur de salut agit ! ");
        return "vue-salut";
    }
}
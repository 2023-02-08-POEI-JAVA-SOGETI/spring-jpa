package com.bigcorp.booking.mvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class PlanetesControleur {
	
    
	/**
	 * Place dans le contexte Spring MVC l'attribut 'caRoule'.
	 * Cet attribut pourra
	 * être utilisé par (entre autres) la vue. 
	 * @return
	 */
    @ModelAttribute("caRoule")
    public String metDansLeContexteCaRoule() {
        return "Ca roule pas mal sur cette page dynamique ! ";
    }
    
	/**
	 * Place dans le contexte Spring MVC l'attribut 'planetes'
	 * qui contient une liste de planètes. Cet attribut pourra
	 * être utilisé par (entre autres) la vue. 
	 * @return
	 */
    @ModelAttribute("listePlanetes")
    public List<String> populatePlanets() {
        return Arrays.asList(
                "Mercure", "Venus", "Terre", "Mars", "Jupiter", "Saturne", "Uranus", "Neptune"
        );
    }
    
   
    @ModelAttribute("doitAfficherDiv")
    public boolean doitAfficherDiv() {
        return true;
    }
    
    /**
     * Intercepte les requêtes /planetes , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue planetes.
     * @return
     */
    @RequestMapping("/planetes")
    public String showPlanetes() {
    	System.out.println("Le contrôleur de planetes agit !");
        return "planetes";
    }
    
}
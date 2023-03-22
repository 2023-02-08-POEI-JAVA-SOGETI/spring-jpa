package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class MonPremierControleur {
    
    
    /**
     * Intercepte les requêtes /salut , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue salut.
     * @return
     */
    @RequestMapping("/pablo")
    public String showSayHello() {
    	System.out.println("Le contrôleur de salut agit ! ");
        return "vue-salut";
    }
    
    
}
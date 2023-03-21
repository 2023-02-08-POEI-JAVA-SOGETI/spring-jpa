package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class MonSecondControleur {

    /**
    * Place dans le contexte Spring MVC l'attribut 'caRoule'.
    * Cet attribut pourra
    * être utilisé par (entre autres) la vue.
    * @return
    */
    @ModelAttribute("monMessage")
    public String metDansLeMessageCaRoule() {
    	return "Ca roule pas mal sur cette page dynamique ! ";
    }
    
    /**
     * Intercepte les requêtes /salut , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue salut.
     * @return
     */
    @RequestMapping("/coucou")
    public String showSayHello() {
    	System.out.println("Le contrôleur de coucou agit ! ");
        return "vue-coucou";
    }
    
}
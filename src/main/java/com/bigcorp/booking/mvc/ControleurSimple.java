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
public class ControleurSimple {
    
    
    /** Intercepte les requêtes /salut , effectue des instructions (ici un simple System.out) puis renvoie vers la vue salut. @return*/
    @RequestMapping("/salut")
    	public String ditSalut() {
    	System.out.println("Le contrôleur de salut agit ! ");
        	return "vue-salut";
    } 
    
    /** Place dans le contexte Spring MVC l'attribut 'caRoule'. Cet attribut pourra être utilisé par (entre autres) la vue. @return */
    @ModelAttribute("monMessage")
         public String metDansLeMessageCaRoule() {
         	return "Ca roule pas mal sur cette page dynamique ! ";
    }
         
     /** Intercepte les requêtes /salut , effectue des instructions (ici un simple System.out) puis renvoie vers la vue salut. @return*/
     @RequestMapping("/coucou")
       public String ditCoucou() {
    	System.out.println("Le contrôleur de coucou agit ! ");
          return "vue-coucou";
    }
    
 	/** Place dans le contexte Spring MVC l'attribut 'heros disney' qui contient une liste de heros Disney. Cet attribut pourra être utilisé par (entre autres) la vue. @return*/
     @ModelAttribute("listeHerosDisney")
     public List<String> herosDisney() {
         return Arrays.asList(
                 "Kuzco", "Simba", "Aurore", "Merida", "Hercules", "Quasimodo", "Maribel", "Tarzan"
         );
     }

     @ModelAttribute("caRoule")
     public String metDansLeContexteCaRoule() {
         return "Ca roule pas mal sur cette page dynamique ! ";
     }
     
     @ModelAttribute("doitAfficherDiv")
     public boolean doitAfficherDiv() {
         return true;
     }    
  
}
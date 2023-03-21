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
public class ControleurListArgtUnique {
    
    @ModelAttribute("caRoule")
    public String metDansLeContexteCaRoule() {
        return "Ca roule pas mal sur cette page dynamique ! ";
    }

	
	/**
	 * Place dans le contexte Spring MVC l'attribut 'heros disney'
	 * qui contient une liste de heros Disney. Cet attribut pourra
	 * être utilisé par (entre autres) la vue. 
	 * @return
	 */
    @ModelAttribute("listeHerosDisney")
    public List<String> herosDisney() {
        return Arrays.asList(
                "Kuzco", "Simba", "Aurore", "Merida", "Hercules", "Quasimodo", "Maribel", "Tarzan"
        );
    }
    
    @ModelAttribute("doitAfficherDiv")
    public boolean doitAfficherDiv() {
        return true;
    }    
    
    /**
     
    @RequestMapping("/herosdisney")
    public String afficherHerosDisney() {
    	System.out.println("Le contrôleur de heros disney agit !");
        return "vue-herosdisney";
    }
    */

}
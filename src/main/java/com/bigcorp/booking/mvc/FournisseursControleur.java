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
public class FournisseursControleur {
	
    
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
	 * Place dans le contexte Spring MVC l'attribut 'fournisseurs'
	 * qui contient une liste de fournisseurs. Cet attribut pourra
	 * être utilisé par (entre autres) la vue. 
	 * @return
	 */
    @ModelAttribute("listeFournisseurs")
    public List<String> fournisseurs() {
        return Arrays.asList(
                
        );
    }
    
   
    @ModelAttribute("doitAfficherDiv")
    public boolean doitAfficherDiv() {
        return true;
    }
    
    /**
     * Intercepte les requêtes /fournisseurs , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue fournisseurs.
     * @return
     */
    @RequestMapping("/fournisseurs")
    public String showFournisseurs() {
    	System.out.println("Le contrôleur de fournisseurs agit !");
        return "fournisseurs";
    }
    
}
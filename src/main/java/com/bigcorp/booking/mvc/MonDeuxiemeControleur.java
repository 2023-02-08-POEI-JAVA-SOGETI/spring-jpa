package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Camion;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class MonDeuxiemeControleur {
    
    
    /**
     * Intercepte les requêtes /Resalut , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue Resalut.
     * @return
     */
    @RequestMapping("/REsalut")
    public String showSayReHello() {
    	System.out.println("Le contrôleur de RE salut agit ! ");
        return "vue-Resalut";
    }
    
    @ModelAttribute("hey") 
    public String monMessage() {
        return "Bienvenue sur ma page !"; 
    }
    
    @ModelAttribute("camionListe") 
    public List<Camion> getCamion() {
    	Camion camion = new Camion("Camion Captain America");; 
    	
    	ArrayList<Camion> CamionListe = new ArrayList<Camion>();
    	CamionListe.add(new Camion("Camion Iron Man"));
    	CamionListe.add(new Camion("Camion Hulk"));
    	CamionListe.add(new Camion("Camion Thor"));
    	CamionListe.add(new Camion("Camion Avengers"));
    	
        return  CamionListe;      		
    }
    
    
    @RequestMapping("/ma-page")
    public ModelAndView myPageWithQueryParameter(@RequestParam("id") int id) {
        System.out.println("ID récupéré de l'URL avec un paramètre de requête : " + id);
        ModelAndView mav = new ModelAndView("my-page");
        mav.addObject("id", id);
        return mav;
    }

    @RequestMapping("/ma-page/{id}")
    public ModelAndView myPageWithPathVariable(@PathVariable int id) {
        System.out.println("ID récupéré de l'URL avec un paramètre d'URL : " + id);
        ModelAndView mav = new ModelAndView("my-page");
        mav.addObject("id", id);
        return mav;
    }


    


    
  
    
}
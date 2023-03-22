package com.bigcorp.booking.mvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.spring.service.FournisseurService;

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
    @RequestMapping(path = "/salut", method = RequestMethod.GET)
    public String showSayHello() {
    	System.out.println("Le contrôleur de salut agit ! ");
        return "vue-salut";
    }
    
    
    @ModelAttribute("monTexte")
    public String afficheMonTexte()
    {
		return LocalDateTime.now().toString();
    }
    
    @ModelAttribute("monFournisseur")
    public Fournisseur afficheMonFournisseur()
    {
    	Fournisseur f = new Fournisseur();
    	f.setNom("Nom de mon Fournisseur");
		return f;
    }
    
    @ModelAttribute("listFournisseur")
    public List<Fournisseur> afficheListFournisseur()
    {
    	List<Fournisseur> list = new ArrayList<>();
    	
    	Fournisseur f1 = new Fournisseur();
    	f1.setNom("Nom de mon Fournisseur 1");
    	
    	Fournisseur f2 = new Fournisseur();
    	f2.setNom("Nom de mon Fournisseur 2");
    	
    	Fournisseur f3 = new Fournisseur();
    	f3.setNom("Nom de mon Fournisseur 3");
    	
    	list.add(f1);
    	list.add(f2);
    	list.add(f3);
    	
		return list;
    }
    
    
}
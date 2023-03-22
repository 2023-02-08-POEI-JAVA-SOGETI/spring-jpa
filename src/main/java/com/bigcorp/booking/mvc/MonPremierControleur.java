package com.bigcorp.booking.mvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    	System.out.println("Le contrôleur de Salut agit ! ");
        return "vue-salut";
    }
    
    
//    @RequestMapping("/coucou")
//    public String showCoucou() {
//    	System.out.println("Le contrôleur de Coucou agit ! ");
//        return "coucou";
//    }
    
//    private ModelAndView mavFournisseur(Integer id) {
//    	System.out.println("Le fournisseur " + id + " va s'afficher");
//    	
//    	ModelAndView mav = new ModelAndView();
//    	mav.setViewName("coucou");
//    	
//    	Fournisseur four =  new Fournisseur();
//    	four.setId(id);
//    	four.setNom("Mon nom");
//    	
//    	mav.addObject("fournisseur", four);
//    	
//    	return mav;
//    }
//    
//    
//    @RequestMapping("/fournisseur/{id}")
//    public ModelAndView afficheDetailsFournisseur(@PathVariable("id") Integer id)
//    {
//    	return mavFournisseur(id);
//    }
//
//
//    
//    @RequestMapping("/fournisseur")
//    public ModelAndView afficheDetailsFournisseur2(@RequestParam("id") Integer id)
//    {
//    	return mavFournisseur(id);
//    }
    
    
    
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
    	f1.setId(1);
    	Fournisseur f2 = new Fournisseur();
    	f2.setNom("Nom de mon Fournisseur 2");
    	f2.setId(2);
    	Fournisseur f3 = new Fournisseur();
    	f3.setNom("Nom de mon Fournisseur 3");
    	f3.setId(3);
    	list.add(f1);
    	list.add(f2);
    	list.add(f3);
		return list;
    }
    
    
  
    
    
    
}
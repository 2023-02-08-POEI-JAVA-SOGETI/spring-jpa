package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;


/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class ControleurFournisseurs {

	@Autowired
	FournisseurService fournisseurService;
    /**
     * Intercepte les requêtes /salut , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue salut.
     * @return
     */
    @RequestMapping("/fournisseurs")
    public String showFournisseurs() {
    	System.out.println("Le contrôleur Fournisseurs agit ! ");
        return "fournisseurs";
    }
    
    @ModelAttribute("fournisseursList")
    public Iterable<Fournisseur> getFournisseursList(){
    	return fournisseurService.findAll();
    }
    
    @RequestMapping("/fournisseur/{id}")
    public ModelAndView displayFournisseur(@PathVariable("id") Integer id){
    	System.out.println("J'affiche la page du fournisseur dont l'id est " + id);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("fournisseur");
    	mav.addObject("fournisseur", fournisseurService.findById(id));
    	return mav;
    }
    
    @PostMapping("/save-fournisseur")
    public ModelAndView processSubmit(@ModelAttribute("fournisseur") Fournisseur fournisseur, BindingResult result) {
    	
    	if(result.hasErrors()) {
    		ModelAndView mav = new ModelAndView();
    		mav.setViewName("fournisseur");
    		mav.addObject("fournisseur", fournisseur);
    		return mav;
    	}
    	
    	fournisseurService.save(fournisseur);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:/fournisseur/" + fournisseur.getId());
    	return mav;
    }

}
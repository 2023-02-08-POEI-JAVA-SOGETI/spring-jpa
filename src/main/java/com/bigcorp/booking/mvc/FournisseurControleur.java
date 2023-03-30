package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Fournisseurs;
import com.bigcorp.booking.service.FournisseursService;

@Controller
public class FournisseurControleur {
	
	@Autowired
	private FournisseursService fournisseurService;
	
	@RequestMapping("/liste-fournisseurs")
    public String showListFournisseurs() {
    	System.out.println("La page 'liste des fournisseurs' s'affiche mais elle est encore vide ! ");
        return "vue-fournisseurs";
    }	
	
	//liste fournisseurs avec lien hypertexte (page1)
	@ModelAttribute("fournisseurs")
	public Iterable<Fournisseurs> metDansLeContexteConnexion() {
		return fournisseurService.findAll();
	}
	
	// Affiche la page de formulaire pour un fournisseur donné (page2)
	 @RequestMapping("/formulaire-fournisseur/{id}")
	   
	 public ModelAndView afficheFournisseur(@PathVariable("id") Integer id) {
		 Fournisseurs fournisseur = fournisseurService.findById(id);
		 System.out.println("J'affiche le détail du fournisseur : " + id);
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("vue-formulaire-fournisseur");
		 mav.addObject("fournisseur", fournisseur);
		 return mav;
		 }
       	
	// formulaire de modification pour un fournisseur donné
    @PostMapping("/formulaire-fournisseur/{id}")
    public String modificationFournisseur(@PathVariable("id") Integer id,
                                         @ModelAttribute("fournisseur") Fournisseurs fournisseur,
                                         BindingResult result) {
        if (result.hasErrors()) {
            return "formulaire-fournisseur";
        }
        fournisseur.setId(id);
        fournisseurService.save(fournisseur);
        return "redirect:/formulaire-fournisseur/{id}";
    }
}

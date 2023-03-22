package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Planete;

import tp_spring_jpa_pablo.model.Fournisseur;

@Controller
public class FournisseurControleur {   
    
	@RequestMapping("/fournisseur")
    public String showSayHello() {
    	System.out.println("PAGE FOURNISSEUR ");
        return "fournisseur";
    }
	
    @ModelAttribute("listeFournisseur")
    public List<Fournisseur> getFournisseurList() {
        List<Fournisseur> fournisseurList = new ArrayList<>();
        Fournisseur fournisseur1 = new Fournisseur();        
        Fournisseur fournisseur2 = new Fournisseur();
        Fournisseur fournisseur3 = new Fournisseur();
        fournisseur1.setNom("MVC 1");
        fournisseur1.setId(1);        
        fournisseur2.setNom("MVC 2");
        fournisseur2.setId(2);        
        fournisseur3.setNom("MVC 3");
        fournisseur3.setId(3);
        fournisseurList.add(fournisseur1);
        fournisseurList.add(fournisseur2);
        fournisseurList.add(fournisseur3);
        return fournisseurList;
    }  
    
//    @PostMapping("/planete2")
//    public ModelAndView processSubmit(@Validated @ModelAttribute("planete") Planete planete, 
//    		BindingResult result) {
//    	if(result.hasErrors()) {
//    		//return new ModelAndView("planete", "planete", planete);
//    		ModelAndView mav = new ModelAndView();
//        	mav.setViewName("planete");
//        	mav.addObject("planete", planete);
//            return mav;
//    	}
//    	
//    	ModelAndView mav = new ModelAndView();
//    	mav.setViewName("redirect:/planete");
//    	mav.addObject("planete", planete);
//        return mav;
//    }
    
    
}
package com.bigcorp.booking.mvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Camion;
import com.bigcorp.booking.service.PlanetesSingleton;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class MonCoucouControleur {
    
    
    /**
     * Intercepte les requêtes /salut , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue salut.
     * @return
     */
    @RequestMapping("/coucou")
    public String showSayHello() {
    	System.out.println("Le CoucouControleur agit ! ");
        return "vue-coucou";
    }
    
    @ModelAttribute("dinamyc")
    public String partDynamyc() {    	
    	return LocalDateTime.now().toString();
    }
    
    @ModelAttribute("camion")
    public Camion getCamion() {
    	Camion camion = new Camion();
    	return camion;
    }
    
    @ModelAttribute("listeInvites")
    public List<String> getInvites() {
    	List<String> invites = new ArrayList<>();
    	invites.add("Pablo");
    	invites.add("Manon");
    	invites.add("Elhadji");
    	return invites;
    }
    
    @ModelAttribute("boolean")
    public Boolean getBoolean() {
    	Boolean myBoolean = true;
    	return myBoolean;
    }
    
    @ModelAttribute("listeCamions")
    public List<Camion> getCamionList() {
        List<Camion> camionList = new ArrayList<>();
        Camion camion1 = new Camion();        
        Camion camion2 = new Camion();
        camion2.setModel("Bumblebee");
        camion2.setId(2);
        Camion camion3 = new Camion();
        camion3.setModel("Waspinator");
        camion3.setId(3);
        camionList.add(camion1);
        camionList.add(camion2);
        camionList.add(camion3);
        return camionList;
    }
    
    @RequestMapping("/camion")
    public String afficheModelCamionParAttribut(@RequestParam("id") Integer id) {
    	System.out.println("J'affiche mon camion N° " + id + " a partir d'une requete");
        return "camion";
    }
    
    @RequestMapping("/camion/{id}")
    public ModelAndView afficheModelCamionParRoute(@PathVariable("id") Integer id) {
    	System.out.println("J'affiche le camion N°" + id + " a partir du chemin");
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("vue-coucou");
    	Camion camion4 = new Camion();
        camion4.setModel("Chemin Method");
        camion4.setId(4);
        List<Camion> camionList = getCamionList();
        camionList.add(camion4);
    	mav.addObject("camion", camion4);
        return mav;
    }
     
    
}
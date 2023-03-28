package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Planete;
import com.bigcorp.booking.service.PlanetesSingleton;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class PlaneteDetailControleur {
    
    /**
     * Intercepte les requêtes /planete , attend le paramètre de requête "id" et
     * le met dans l'argument id de la méthode.
     * @return
     */
    @RequestMapping("/planete")
    public String afficheDetailPlaneteParAttribut(@RequestParam("id") Integer id) {
    	System.out.println("J'affiche le détail de la planète à partir de son attribut : " + id);
        return "planete";
    }
    
    /**
     * Intercepte les requêtes /planetes/{id} , attend le paramètre "id" dans le chemin et
     * le met dans l'argument id de la méthode.
     * @return
     */
    @RequestMapping("/planetes/{id}")
    public ModelAndView afficheDetailPlaneteParChemin(@PathVariable("id") Integer id) {
    	System.out.println("J'affiche le détail de la planète à partir du chemin  : " + id);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("planete");
    	mav.addObject("planete", PlanetesSingleton.INSTANCE.getPlaneteById(id));
        return mav;
    }
    
    /**
     * Sauvegarde planete
     * @param planete
     * @param result
     * @return
     */
    @PostMapping("/planete")
    public ModelAndView processSubmit(@Validated @ModelAttribute("planete") Planete planete, 
    		BindingResult result) {
    	if(result.hasErrors()) {
    		return new ModelAndView("planete", "planete", planete);
    	}
    	
    	String view = "planetes";
    	if(planete != null && planete.getId() != null) {
    		view = "redirect:/planetes/" + planete.getId();
    	}
    	ModelAndView mav = new ModelAndView(view);
    	mav.addObject("planete", planete);
        if (result.hasErrors()) {
            return mav;
        }
        // else
        PlanetesSingleton.INSTANCE.savePlanete(planete);
        return mav;
    }
    
    
}
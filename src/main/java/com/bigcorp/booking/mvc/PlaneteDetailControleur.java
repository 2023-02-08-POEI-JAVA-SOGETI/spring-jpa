package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Planete;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.service.PlanetesSingleton;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class PlaneteDetailControleur {
    
	@Autowired
	private FournisseurService service;
	
    /**
     * Intercepte les requêtes /planete , attend le paramètre de requête "id" et
     * le met dans l'argument id de la méthode.
     * @return
     */
    @RequestMapping("/planete")
    public ModelAndView afficheDetailPlaneteParAttribut(@RequestParam("id") Integer id) {
    	System.out.println("J'affiche le détail de la planète à partir de son attribut : " + id);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("planete");
    	mav.addObject("planete", PlanetesSingleton.INSTANCE.getPlaneteById(id));
        return mav;
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
    @PostMapping("/save-planete")
    public ModelAndView processSubmit( @ModelAttribute("planete") Planete planete, 
    		BindingResult result) {
    	if(result.hasErrors()) {
    		//return new ModelAndView("planete", "planete", planete);
        	ModelAndView mav = new ModelAndView();
        	mav.setViewName("planete");
        	mav.addObject("planete", planete);
            return mav;
    	}
    	
    	PlanetesSingleton.INSTANCE.savePlanete(planete);
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:/planete?id=" + planete.getId());
        return mav;
    }
    
    
}
package com.bigcorp.booking.controllers.vue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.HerosFilms;
import com.bigcorp.booking.service.FilmSingleton;
import com.bigcorp.booking.service.PlanetesSingleton;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class ModeleComparatifL {
    

	@ModelAttribute("caRoule")
    public String metDansLeContexteCaRoule() {
        return "Ca roule pas mal sur cette page dynamique ! ";
    }

    @ModelAttribute("doitAfficherDiv")
    public boolean doitAfficherDiv() {
        return true;
    }   
	
	/**
	 * Place dans le contexte Spring MVC l'attribut 'heros disney'
	 * qui contient une liste de heros Disney. Cet attribut pourra
	 * être utilisé par (entre autres) la vue. 
	 * @return
	 */    
   
    @ModelAttribute("listeHerosFilms")    
    public List<HerosFilms> herosFilm() {
        List<HerosFilms> liste = new ArrayList<>();
        int id = 1;
        String[] noms = { "Kuzco", "Simba", "Aurore", "Merida", "Megara", "Quasimodo", "Mirabel", "Tarzan" };
        String[] films = {  "Kuzco, l'empereur mégalo", "Le Roi Lion", "La Belle au bois dormant", "Rebelle", "Hercule",
                "Le Bossu de Notre-Dame", "Encanto", "Tarzan" };
        for (int i = 0; i < noms.length; i++) {
            liste.add(new HerosFilms(id++, noms[i], films[i]));
        }
        return liste;
    }

    /*
     * Crée la liste de héros avec leurs identifiants (2 arguments)
     * 
    @ModelAttribute("listeHerosDisney")
    public List<HerosDisney> herosDisney() {
        List<HerosDisney> liste = new ArrayList<>();
        int id = 1;
        for (String nom : Arrays.asList(
                "Kuzco", "Simba", "Aurore", "Merida", "Hercules", "Quasimodo", "Maribel", "Tarzan"
        )) {
            liste.add(new HerosDisney(id++, nom));
        }
        return liste ;
    }
    
    /**
     * Intercepte les requêtes /herosdisney , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue herosdisney.
     * @return
     */
    
    @RequestMapping("/herosfilm")
    public String afficherHerosFilm() {
    	System.out.println("Le contrôleur de heros film agit !");
        return "vue-herosfilm";
    }

    @RequestMapping("/personnagefilm")
    public ModelAndView afficherHerosParParam(@RequestParam("id") Integer id) {    	
    	System.out.println("Je t'envoie la page du personnage " + id);
    	HerosFilms herosFilm1 = FilmSingleton.INSTANCE.getHerosFilmById(id);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("vue-details");
    	mav.addObject("heros", herosFilm1);
    	return mav; 
    }
    
 
    @RequestMapping("/personnagefilm/{id}")
    public ModelAndView afficherHerosParChemin(@PathVariable("id") Integer id) {
    	System.out.println("Je t'envoie la page du personnage " + id);
    	HerosFilms herosFilm1 = FilmSingleton.INSTANCE.getHerosFilmById(id);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("vue-details");
    	mav.addObject("heros", herosFilm1);
    	return mav; 
    }



    @PostMapping("vue-details")
    	public ModelAndView processSubmit(@Validated @ModelAttribute("herosD") HerosFilms herosD, 
    			BindingResult result) {
    		if(result.hasErrors()) {
    			return new ModelAndView("vue-herosfilm", "heros", herosD);
    		}
	
    		String view = "vue-herosfilm";
    			if(herosD != null && herosD.getId() != null) {
    				view = "redirect:/herosfilm/" + herosD.getId();
    		}

    		ModelAndView mav = new ModelAndView(view);
    			mav.addObject("heros", herosD);
    				if (result.hasErrors()) {
    					return mav;
    		}
    		// else
    			FilmSingleton.INSTANCE.saveHerosFilm(herosD);
    				return mav;
}}


package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.HerosDisney;
import com.bigcorp.booking.service.DisneySingleton;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class MonQuatriemeControleur {
    

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
   
    
    @ModelAttribute("listeHerosDisney")    
    public List<HerosDisney> herosDisney() {
        List<HerosDisney> liste = new ArrayList<>();
        int id = 1;
        String[] noms = { "Kuzco", "Simba", "Aurore", "Merida", "Megara", "Quasimodo", "Mirabel", "Tarzan" };
        String[] films = {  "Kuzco, l'empereur mégalo", "Le Roi Lion", "La Belle au bois dormant", "Rebelle", "Hercule",
                "Le Bossu de Notre-Dame", "Encanto", "Tarzan" };
        for (int i = 0; i < noms.length; i++) {
            liste.add(new HerosDisney(id++, noms[i], films[i]));
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
    
    @RequestMapping("/herosdisney")
    public String afficherHerosDisney() {
    	System.out.println("Le contrôleur de heros disney agit !");
        return "vue-herosdisney";
    }

    /*@RequestMapping("/personnagedisney")
    public String afficherHerosParParam(@RequestParam("id") Long id) {
    	System.out.println("Je t'envoie la page du personnage " + id + " par paramètre.");
        return "vue-heros";}*/

    @RequestMapping("/personnagedisney")
    public ModelAndView afficherHeros(@RequestParam("id") Integer id) {
    	
    	System.out.println("Je t'envoie la page du personnage " + id);
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("vue-details");
    	mav.addObject("personnageTest", new HerosDisney(1, "Stitch", "Lilo et Stitch"));
    	return mav; 
    }
    
 
    @RequestMapping("/personnagedisney/{id}")
    public ModelAndView afficherHerosParChemin(@PathVariable("id") Integer id) {
    	System.out.println("Je t'envoie la page du personnage " + id + " par chemin.");
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("vue-details");
    	mav.addObject("personnageTest", new HerosDisney(12, "Rey", "Star Wars"));
    	return mav; 
    }

    /* Doublon Sécurité
    @RequestMapping("/personnagedisney/{id}")
    public String afficherHerosParChemin(@PathVariable("id") Long id) {
    	System.out.println("Je t'envoie la page du personnage " + id + " par chemin.");
    	return "details"; 
    */
 

    @PostMapping("/personnagedisney/{id}")
    public ModelAndView processSubmit(@ModelAttribute("vue-details") HerosDisney herosDisney, BindingResult result)
    	
    	{ String view = "planetes"; if(herosDisney !=null && herosDisney.getId() != null) 
    		{view = "redirect:/personnagedisney/" + herosDisney.getId();}
     	
    		ModelAndView mav = new ModelAndView("vue-details");
    		mav.addObject("vue-details", herosDisney);
    			if(result.hasErrors()) 
    	   {return mav;}
    	
    		//Else
    			DisneySingleton.INSTANCE.saveHerosDisney(herosDisney);
    		return mav; }}
  

    

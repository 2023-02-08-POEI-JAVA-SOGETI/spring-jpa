package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class MonControleurTp {

    /**
     * Intercepte les requêtes /salut , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue salut.
     * @return
     */
    @RequestMapping("/coucou")
    public String showSayHello() {
    	System.out.println("Le contrôleur du TP sur coucou agit ! ");
        return "vue-coucou";
    }
    
    
    @ModelAttribute("monMessage")
    public String showText() {
    	return "Ceci est mon message";
    }
    
    @ModelAttribute("monCamion")
    public Camion camion() {
    	Camion camion = new Camion(null);
    	camion.setNom("titi");
    	return camion;
    }

    @ModelAttribute("boolean")
    public Boolean getBol() {
    	Boolean myBol = true;
    	return myBol;
    }
    
    @ModelAttribute("liste")
    public List<String> getElements(){
    	List<String> elements = new ArrayList<>();
    	elements.add("banane");
    	elements.add("pomme");
    	elements.add("poire");
    	elements.add("clementine");
    	elements.add("grenade");
    	return elements;
    }
    
    @ModelAttribute("listeCamions")
    public List<Camion> getCamions(){
    	Camion cam1 = new Camion("Camion 1");
    	Camion cam2 = new Camion("Camion 2");
    	Camion cam3 = new Camion("Camion 3");
    	Camion cam4 = new Camion("Camion 4");
    	Camion cam5 = new Camion("Camion 5");
    	
    	List<Camion> camions = new ArrayList<>();
    	camions.add(cam1);
    	camions.add(cam2);
    	camions.add(cam3);
    	camions.add(cam4);
    	camions.add(cam5);
    	return camions;
    }
    
    @ModelAttribute("lienId")
    public Integer lienId() {
    	Integer id = 8;
    	return id;
    }
    
    /**
    * Intercepte les requêtes /lien , attend le paramètre de requête "id" et
    * le met dans l'argument id de la méthode.
    * @return
    */    
    @RequestMapping("/ma-page")
    public String afficheLien(@RequestParam("id") String id) {
    	System.out.println("J'affiche la page /ma-page avec l'id : " + id);
    	return "ma-page";
    }
    
    
    /**
    * Intercepte les requêtes /lien/{id} , attend le paramètre "id"
    dans le chemin et
    * le met dans l'argument id de la méthode.
    * @return
    */
    @RequestMapping("/ma-page/{id}")
    public String afficheLienParChemin(@PathVariable("id") String id) {
    System.out.println("J'affiche le détail de ma-page à partir du chemin : " +
    id);
    return "ma-page";
    }
    
}
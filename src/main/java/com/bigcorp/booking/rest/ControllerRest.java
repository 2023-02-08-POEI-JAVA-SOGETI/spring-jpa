package com.bigcorp.booking.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bigcorp.booking.model.HerosFilms;

@RestController
public class ControllerRest {

	@GetMapping("/rest/personnagesfilms/{id}")
	public HerosFilms afficherHerosParChemin(@PathVariable("id") Integer id) {
		System.out.println("Je t'envoie la page du personnage " + id);
		HerosFilms herosFilm1 = new HerosFilms();
		herosFilm1.setId(id);
		herosFilm1.setNom("Leeloo");
		herosFilm1.setFilm("Le Cinquieme Element");
			return herosFilm1;
	}
	
	
	/* Requête par Param : ne fonctionne pas par soucis du à l'id
	@GetMapping("/personnagesfilms/{id}")
	public HerosFilms afficherHerosParParam(@RequestParam("id") Integer id) {
		HerosFilms herosFilm2 = new HerosFilms();
		herosFilm2.setId(id);
		herosFilm2.setNom("Dom");
		herosFilm2.setFilm("Inception");
			return herosFilm2;
		}*/
	
}
	
	



/*
//    @RequestMapping("/personnagefilm")
    	public ModelAndView afficherHerosParParam(@RequestParam("id") Integer id) {    	
    	System.out.println("Je t'envoie la page du personnage " + id);
    	HerosFilms herosDisney1 = FilmSingleton.INSTANCE.getHerosFilmById(id);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("vue-details");
    	mav.addObject("heros", herosDisney1);
    	return mav; 
    }

}
*/
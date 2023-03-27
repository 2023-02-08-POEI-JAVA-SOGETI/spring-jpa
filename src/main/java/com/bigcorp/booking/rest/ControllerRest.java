package com.bigcorp.booking.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bigcorp.booking.model.HerosFilms;
import com.bigcorp.booking.service.FilmSingleton;

@RestController
public class ControllerRest {

	@GetMapping("/rest/personnagesfilms/{id}") /*Simple affichage de données en forçant un ID dans l'URL*/
	public HerosFilms afficherHerosParChemin(@PathVariable("id") Integer id) {
		System.out.println("Je t'envoie la page du personnage " + id);
    	HerosFilms herosFilm2 = new HerosFilms();
		herosFilm2.setId(id);
		herosFilm2.setNom("Leeloo");
		herosFilm2.setFilm("Le Cinquieme Element");
			return herosFilm2;
	}
	
	@GetMapping("/rest/personnageFilms/{id}") /*Affichage d'une entitée provenant de la BDD*/
	public HerosFilms afficherHerosDeLaBDD(@PathVariable("id") Integer id) {
		System.out.println("Je t'envoie la page du personnage " + id);
    	HerosFilms herosFilm3 = FilmSingleton.INSTANCE.getHerosFilmById(id);		
    	herosFilm3.setId(id);
		herosFilm3.setNom(herosFilm3.getNom());
		herosFilm3.setFilm(herosFilm3.getFilm());
			return herosFilm3;
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
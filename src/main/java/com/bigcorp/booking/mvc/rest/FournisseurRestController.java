package com.bigcorp.booking.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.mvc.rest.dto.FournisseurRestDto;
import com.bigcorp.booking.mvc.rest.dto.FournisseurRestDto;
import com.bigcorp.booking.service.FournisseurService;

@RestController
public class FournisseurRestController {

	@Autowired
	private FournisseurService fournisseurService;

	// Requête n'allant pas sur la base (juste à partir du model)
//	 @GetMapping("/fournisseurs/{fournisseurId}") public Fournisseur
//	 getById(@PathVariable("fournisseurId") Integer fournisseurId) { Fournisseur
//	 fournisseur = new Fournisseur(); fournisseur.setId(fournisseurId);
//	 fournisseur.setNom("Salut !!!"); return fournisseur; }
	 
	// Requêtes CRUD sur la base
	//Get 
	@GetMapping("/fournisseurs/{fournisseurId}")
	public FournisseurRestDto getById(@PathVariable("fournisseurId") Integer fournisseurId) {
		//Trouve le fournisseur par son id et le stock dans la variable fournisseur
		Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
		// Pour générer une erreur 404 lors que l'id du fournisseur n'existe pas
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun fournisseur trouvé avec l'id : " + fournisseurId);
		}
		//Retourne le DTO préalablement chargé avec le fournisseur trouvé et stocké dans la variable fournisseur
		return new FournisseurRestDto(fournisseur);
	}
	//DELETE 
	@DeleteMapping("/fournisseurs/{fournisseurId}")
	public void supprimer(@PathVariable("fournisseurId") Integer fournisseurId) {
		// Pour générer une erreur 404 lors que l'id du fournisseur n'existe pas
		Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun fournisseur trouvé avec l'id : " + fournisseurId);
		// Si non effectuer la suppression
		} else
			fournisseurService.supprimer(fournisseurId);
	}
	
	@PostMapping("/fournisseurs")
	public FournisseurRestDto save(@Validated @RequestBody FournisseurRestDto fournisseurRestDto, BindingResult bindingResult) {
		
		// Transformer le DTO en entité
		System.out.println("Appel de la methode save pour le fournisseur : {}"+fournisseurRestDto);
		if(bindingResult.hasErrors()) {
			ObjectError objectError = bindingResult.getAllErrors().get(0);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, objectError.getDefaultMessage());
		}
		Fournisseur fournisseur = new Fournisseur();
		if (fournisseurRestDto.getId() != null) {
			fournisseur = fournisseurService.findById(fournisseurRestDto.getId());
			if(fournisseur == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouver avec l'id");
			}
		}
		fournisseurRestDto.remplisFournisseur(fournisseur);
		
		// sauvegarder l'entité
		try {
		fournisseur = fournisseurService.sauvegarde(fournisseur);
		}catch(Exception e) {};
		
		// transmetttre en réponse le DTO
		return new FournisseurRestDto(fournisseur);
		
		}
}
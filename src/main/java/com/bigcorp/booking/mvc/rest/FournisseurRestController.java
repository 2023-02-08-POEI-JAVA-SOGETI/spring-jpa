package com.bigcorp.booking.mvc.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.mvc.rest.dto.FournisseurRestDto;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.service.exception.FournisseurException;
import com.bigcorp.booking.service.exception.FournisseurInvalideException;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurRestController {

	@Autowired
	private FournisseurService fournisseurService;

	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurRestController.class);

	// Requête n'allant pas sur la base (juste à partir du model)
//	 @GetMapping("/fournisseurs/{fournisseurId}") public Fournisseur
//	 getById(@PathVariable("fournisseurId") Integer fournisseurId) { Fournisseur
//	 fournisseur = new Fournisseur(); fournisseur.setId(fournisseurId);
//	 fournisseur.setNom("Salut !!!"); return fournisseur; }

	// Requêtes CRUD sur la base
	// Get
	@GetMapping("/{fournisseurId}")
	public FournisseurRestDto getById(@PathVariable("fournisseurId") Integer fournisseurId) {
		// Trouve le fournisseur par son id et le stock dans la variable fournisseur
		Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
		// Pour générer une erreur 404 lors que l'id du fournisseur n'existe pas
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun fournisseur trouvé avec l'id : " + fournisseurId);
		}
		// Retourne le DTO préalablement chargé avec le fournisseur trouvé et stocké
		// dans la variable fournisseur
		return new FournisseurRestDto(fournisseur);
	}

	// DELETE
	@DeleteMapping("/{fournisseurId}")
	public void supprimer(@PathVariable("fournisseurId") Integer fournisseurId) {
		// Pour générer une erreur 404 lors que l'id du fournisseur n'existe pas
		Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun fournisseur trouvé avec l'id : " + fournisseurId);
			// Si non effectuer la suppression
		}
		fournisseurService.supprimer(fournisseurId);
	}

	@PostMapping
	public FournisseurRestDto save(@Validated @RequestBody FournisseurRestDto fournisseurRestDto,
			BindingResult bindingResult) {

		LOGGER.info("Appel de la méthode save pour le fournisseur : {}", fournisseurRestDto);

		// Validation du FournisseurRestDto
		if (bindingResult.hasErrors()) {
			StringBuilder stBuild = new StringBuilder();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				stBuild.append(objectError.getObjectName()).append("-").append(objectError.getDefaultMessage());
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, stBuild.toString());
		}

		// Ici, le FournisseurRestDto est bon,
		// On prépare le fournisseur que l'on va créer ou que l'on va mettre à jour
		Fournisseur fournisseur = new Fournisseur();
		if (fournisseurRestDto.getId() != null) {
			fournisseur = fournisseurService.findById(fournisseurRestDto.getId());
			if (fournisseur == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucun fournisseur trouvé avec l'id : " + fournisseurRestDto.getId());
			}
		}
		fournisseurRestDto.remplisFournisseur(fournisseur);

		
		try {
			fournisseur = fournisseurService.sauvegarde(fournisseur);
		} catch (FournisseurException e) {
			LOGGER.error("Erreur lors de la sauvegarde du fournisseur", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le fournisseur de la requête est incorrect");
		}
		
		// La sauvegarde s'est bien déroulée, le fournisseur est retransformé en 
				// DTO pour être renvoyé dans le corps de la réponse HTTP
		return new FournisseurRestDto(fournisseur);
	}
}
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.mvc.rest.dto.FournisseurRestDto;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.service.exception.FournisseurInvalideException;

/**
 * Contrôleur REST pour le fournisseur
 */
@RestController
public class FournisseurRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurRestController.class);

	@Autowired
	private FournisseurService fournisseurService;

	/**
	 * Récupère le fournisseur avec l'id passé en paramètre
	 * 
	 * @param fournisseurId
	 * @return
	 */
	@GetMapping("/fournisseurs/{fournisseurId}")
	public FournisseurRestDto getById(@PathVariable("fournisseurId") Integer fournisseurId) {
		Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : "
					+ fournisseurId);
		}
		return new FournisseurRestDto(fournisseur);
	}

	/**
	 * Supprime le fournisseur avec l'identifiant passé en paramètre
	 * 
	 * @param id
	 */
	@DeleteMapping("/fournisseurs/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		Fournisseur fournisseur = fournisseurService.findById(id);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : "
					+ id);
		}
		fournisseurService.delete(id);
	}

	/**
	 * Sauvegarde un fournisseur passé dans le corps de la réponse. Renvoie le
	 * fournisseur créé dans le corps de la réponse.
	 * 
	 * @param fournisseurRestDto
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/fournisseurs")
	public FournisseurRestDto save(@Validated @RequestBody FournisseurRestDto fournisseurRestDto,
			BindingResult bindingResult) {
		LOGGER.info("Appel de la méthode save pour le fournisseur : {}", fournisseurRestDto);
		// Validation du FournisseurRestDto
		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				sb.append(objectError.getObjectName()).append("-").append(objectError.getDefaultMessage());
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, sb.toString());
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

		// On sauvegarde l'entité, en cas de problème de fournisseur invalide
		// on renvoie une BAD_REQUEST (erreur 400)
		try {
			fournisseur = fournisseurService.save(fournisseur);
		} catch (FournisseurInvalideException e) {
			LOGGER.error("Erreur lors de la sauvegarde du fournisseur", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le fournisseur de la requête est incorrect");
		}

		// La sauvegarde s'est bien déroulée, le fournisseur est retransformé en 
		// DTO pour être renvoyé dans le corps de la réponse HTTP
		return new FournisseurRestDto(fournisseur);
	}

}
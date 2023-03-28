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
import com.bigcorp.booking.service.exception.FournisseurException;

@RestController
public class FournisseurRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurRestController.class);

	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("/fournisseurs/{fournisseurId}")
	public FournisseurRestDto getById(@PathVariable("fournisseurId") Integer fournisseurId) {
		Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : "
					+ fournisseurId);
		}
		return new FournisseurRestDto(fournisseur);
	}

	@DeleteMapping("/fournisseurs/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		Fournisseur fournisseur = fournisseurService.findById(id);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : "
					+ id);
		}
		fournisseurService.delete(id);
	}

	@PostMapping("/fournisseurs")
	public FournisseurRestDto save(@Validated @RequestBody FournisseurRestDto fournisseurRestDto,
			BindingResult bindingResult) {
		// Transformer le DTO en entité
		LOGGER.info("Appel de la méthode save pour le fournisseur : {}", fournisseurRestDto);
		if(bindingResult.hasErrors()) {
			ObjectError objectError = bindingResult.getAllErrors().get(0);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, objectError.getDefaultMessage());			
		}
		
		Fournisseur fournisseur = new Fournisseur();
		if (fournisseurRestDto.getId() != null) {
			fournisseur = fournisseurService.findById(fournisseurRestDto.getId());
			if(fournisseur == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : " + fournisseurRestDto.getId());
			}
		}
		fournisseurRestDto.remplisFournisseur(fournisseur);

		// sauvegarder l'entité
		try {
			fournisseur = fournisseurService.save(fournisseur);
		} catch (FournisseurException e) {
			LOGGER.error("Erreur lors de la sauvegarde du fournisseur", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le fournisseur de la requête est incorrect");
		}

		// transmetttre en réponse le DTO
		return new FournisseurRestDto(fournisseur);
	}

}
package com.bigcorp.booking.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.dto.UtilisateurRestDto;
import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.UtilisateurService;

@RestController
public class UtilisateurRestController {
	private static Logger LOGGER = LoggerFactory.getLogger(UtilisateurRestController.class);

	@Autowired
	UtilisateurService utilisateurService;

	@GetMapping("/utilisateurs/{utilisateurId}")
	public UtilisateurRestDto getById(@PathVariable("utilisateurId") Integer utilisateurId) {
		Utilisateur utilisateur = utilisateurService.getById(utilisateurId);

		if (utilisateur == null) {
			LOGGER.info(HttpStatus.NOT_FOUND + ": User doesn't exist.");

			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"No user with id : " + utilisateurId + " found");
		}

		LOGGER.info(HttpStatus.OK + ": User retrieved!");

		return new UtilisateurRestDto(utilisateur);
	}

	@PostMapping("/utilisateurs")
	public UtilisateurRestDto save(@RequestBody UtilisateurRestDto utilisateurRestDto, BindingResult bindingResult) {
		LOGGER.info("Calling save method for user : {}", utilisateurRestDto);

		// Validation d'UtilisateurRestDto
		if (bindingResult.hasErrors()) {

			StringBuilder sb = new StringBuilder();

			for (ObjectError objectError : bindingResult.getAllErrors()) {
				sb.append(objectError.getObjectName()).append("-").append(objectError.getDefaultMessage());
			}

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, sb.toString());
		}

		// L'utilisateur est validé
		// La méthode peut effectuer la création ou la mise à jour d'un utilisateur
		Utilisateur utilisateur = new Utilisateur();

		if (utilisateurRestDto.getId() != 0) {
			utilisateur = utilisateurService.getById(utilisateurRestDto.getId());
			
			if (utilisateur == null) {
				LOGGER.info(HttpStatus.NOT_FOUND + ": couldn't find user with id " + utilisateurRestDto.getId());

				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find user with id " + utilisateurRestDto.getId());
			}
		}

		utilisateurRestDto.build(utilisateur);

		try {
			utilisateur = utilisateurService.save(utilisateur);

			LOGGER.info(HttpStatus.OK + ": User saved successfully.");
		} catch (Exception e) {
			LOGGER.error("Something wrong happened while saving user");
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect user requested");
		}

		return new UtilisateurRestDto(utilisateur);
	}

	@RequestMapping("/utilisateurs")
	public String showUtilisateurs() {
		LOGGER.info("Controller is working.");

		return "utilisateurs";
	}

	@DeleteMapping("/utilisateurs/{utilisateurId}")
	public ResponseEntity<?> deleteById(@PathVariable("utilisateurId") Integer utilisateurId) {

		if (utilisateurService.getById(utilisateurId) == null) {
			LOGGER.info(HttpStatus.NOT_FOUND + ": User with ID " + utilisateurId + " doesn't exist");
		}

		LOGGER.info(HttpStatus.OK + ": User deleted successfully!");

		utilisateurService.delete(utilisateurId);

		return ResponseEntity.ok().body("User " + utilisateurId + " was successfully removed.");
	}
}

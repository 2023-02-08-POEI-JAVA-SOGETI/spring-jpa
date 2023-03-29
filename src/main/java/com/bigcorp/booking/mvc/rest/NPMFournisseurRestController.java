/*package com.bigcorp.booking.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.NPMFournisseurService;

@RestController
public class NPMFournisseurRestController {

	@Autowired
	private NPMFournisseurService fournisseurService;

	@GetMapping("/rest/fournisseurs/{fournisseurId}")
	public NPMFournisseurRestDto getById(@PathVariable("fournisseurId") Integer fournisseurId) {
		Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : "
					+ fournisseurId);
		}
		return new NPMFournisseurRestDto(fournisseur);
	}

	@DeleteMapping("/rest/fournisseurs/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		Fournisseur fournisseur = fournisseurService.findById(id);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : "
					+ id);
		}
		fournisseurService.delete(id);
	}

	@PostMapping("/rest/fournisseurs")
	public NPMFournisseurRestDto save(@RequestBody NPMFournisseurRestDto fournisseurRestDto) {
		
		// Transformer le DTO en entité
		Fournisseur fournisseur = new Fournisseur();
		fournisseurRestDto.remplisFournisseur(fournisseur);

		// sauvegarder l'entité
		fournisseur = fournisseurService.save(fournisseur);

		// transmetttre en réponse le DTO
		return new NPMFournisseurRestDto(fournisseur);
	}

}*/
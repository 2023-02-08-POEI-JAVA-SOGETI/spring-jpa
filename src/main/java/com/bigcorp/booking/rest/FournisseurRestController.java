package com.bigcorp.booking.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.dto.FournisseurDto;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;



@RestController
public class FournisseurRestController {
	@Autowired
	private FournisseurService fournisseurService;
	
	@GetMapping("/restFournisseur/{fournisseurId}")
	public FournisseurDto getById(@PathVariable("fournisseurId") Integer fournisseurId) {
	    Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
	    if (fournisseur == null) {
	        throw new ResponseStatusException(
	            HttpStatus.NOT_FOUND, "Fournisseur not found with ID: " + fournisseurId);
	    }
	    FournisseurDto fournisseurDto = new FournisseurDto(fournisseur);
	    return fournisseurDto;
	}
	
	@GetMapping("/restFournisseurs")
	public List<FournisseurDto> getAllFournisseur() {
		List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurService.findAll();
		List<FournisseurDto> fournisseurDtos = new ArrayList<>();
		for (Fournisseur fournisseur : fournisseurs) {
			fournisseurDtos.add(new FournisseurDto(fournisseur));
		}
		return fournisseurDtos;
	}
	
	@DeleteMapping("/restFournisseur/{fournisseurId}/delete")
	public void deleteById(@PathVariable("fournisseurId") Integer fournisseurId) {
		fournisseurService.delete(fournisseurId);
	}
	
	@PostMapping("/restFournisseur/{fournisseurId}")
	public FournisseurDto save(@RequestBody FournisseurDto fournisseurDto, @PathVariable("fournisseurId") Integer fournisseurId) {
	    Fournisseur fournisseur = new Fournisseur(fournisseurDto);
	    fournisseur.setId(fournisseurId);	
	    fournisseur = fournisseurService.save(fournisseur);
	    return new FournisseurDto(fournisseur);
	}
}




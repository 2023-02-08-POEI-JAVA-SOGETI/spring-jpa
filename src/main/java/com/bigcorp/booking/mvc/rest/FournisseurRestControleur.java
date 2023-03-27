package com.bigcorp.booking.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.mvc.rest.dto.FournisseurRestDto;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.FournisseurService;

import tp_spring_jpa_pablo.model.Fournisseur;

@RestController
public class FournisseurRestControleur {   
    
	@Autowired
    private FournisseurService fournisseurService;
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/fournisseur/get/{fournisseurId}")
	public FournisseurRestDto getByIdPath(@PathVariable("fournisseurId") Integer fournisseurId) {
		Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : "
					+ fournisseurId);
		}
		return new FournisseurRestDto(fournisseur);
	}	
    
	@GetMapping("/fournisseur/get")
	public FournisseurRestDto getByIdParameter(@RequestParam("id") Integer id) {
		Fournisseur fournisseur = fournisseurService.findById(id);
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : "
					+ id);
		}
		return new FournisseurRestDto(fournisseur);
	}
	
	@PostMapping("/fournisseur/save")
	public FournisseurRestDto saveFournisseur(@RequestBody FournisseurRestDto fournisseurRestDto) {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur = fournisseurRestDto.remplisFournisseur(fournisseur);
		fournisseur = fournisseurService.save(fournisseur);
	    return new FournisseurRestDto(fournisseur);
	}

	@Transactional
	@DeleteMapping("/fournisseur/delete/{fournisseurid}")
	public void deleteFournisseur(@PathVariable("fournisseurid") Integer fournisseurid) {
		Fournisseur fournisseur = fournisseurService.findById(fournisseurid);		
		if (fournisseur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun fournisseur trouvé avec l'id : "
					+ fournisseurid);
		}
		articleService.deleteByFournisseurId(fournisseurid);
		fournisseurService.deleteById(fournisseurid);
	}	
    
}
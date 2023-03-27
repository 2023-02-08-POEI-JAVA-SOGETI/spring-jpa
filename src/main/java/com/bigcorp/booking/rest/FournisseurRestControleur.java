package com.bigcorp.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.rest.dto.FournisseurRestDto;
import com.bigcorp.booking.service.FournisseurService;

@RestController
public class FournisseurRestControleur {

	@Autowired
	private FournisseurService fournisseurService;
	
	@PostMapping("/rest/fournisseurs")
	public FournisseurRestDto saveUpdateFournisseur(@RequestBody FournisseurRestDto fournisseur) {
		Fournisseur f = new Fournisseur();
		fournisseur.remplisFournisseur(f);
		
		return new FournisseurRestDto(fournisseurService.save(f));
	}
}

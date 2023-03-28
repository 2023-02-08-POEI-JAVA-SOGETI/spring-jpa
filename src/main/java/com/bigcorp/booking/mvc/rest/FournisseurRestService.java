package com.bigcorp.booking.mvc.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bigcorp.booking.model.Fournisseur;

@RestController
public class FournisseurRestService {

	@GetMapping("/rest/fournisseurs/{fournisseurId}")
	public Fournisseur getById(@PathVariable("fournisseurId") Integer fournisseurId) {
//		if (bean == null) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No company found");
//		}
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(fournisseurId);
		fournisseur.setNom("Leroy Merlin");
		return fournisseur;
	}

	@DeleteMapping("/rest/fournisseurs/{companyId}")
	public void deleteByCompanyUserId(@PathVariable("companyId") Long id) {
	}

	@PostMapping("/rest/fournisseurs")
	public Fournisseur postCompany(@RequestBody Fournisseur fournisseur) {
		fournisseur.setId(new Random().nextInt());
		return fournisseur;
	}

}
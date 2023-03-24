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
public class FournisseurRestController {

	@GetMapping("/fournisseurs/{fournisseurId}")
	public Fournisseur getById(@PathVariable("fournisseurId") Integer fournisseurId) {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(fournisseurId);
		fournisseur.setNom("Salut !!!");
		return fournisseur;
	}

	@DeleteMapping("/fournisseurs/{companyId}")
	public void deleteByCompanyUserId(@PathVariable("companyId") Long id) {
	}

	@PostMapping("/fournisseurs")
	public Fournisseur postCompany(@RequestBody Fournisseur fournisseur) {
		fournisseur.setId(new Random().nextInt());
		return fournisseur;
	}

}
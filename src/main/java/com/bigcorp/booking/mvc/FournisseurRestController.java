package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
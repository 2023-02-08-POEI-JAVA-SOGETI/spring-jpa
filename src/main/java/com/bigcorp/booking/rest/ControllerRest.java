package com.bigcorp.booking.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.HerosDisney;
import com.bigcorp.booking.service.DisneySingleton;

@RestController
public class ControllerRest {

	@GetMapping("/fournisseurs/{fournisseurId}")
	public Fournisseur getById(@PathVariable("fournisseurId") Integer fournisseurId) {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(fournisseurId);
		fournisseur.setNom("Salut !!!");
			return fournisseur;
	}
}



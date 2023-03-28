package com.bigcorp.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.dto.UtilisateurRestDto;
import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.UtilisateurService;

@RestController
public class UtilisateurRestController {
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@GetMapping("/utilisateurs/{utilisateurId}")
	public UtilisateurRestDto getById(@PathVariable("utilisateurId") Integer utilisateurId) {
		Utilisateur utilisateur = utilisateurService.getById(utilisateurId);
		
		if(utilisateur == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, 
					"Aucun utilisateur trouvé avec l'id : "
					+ utilisateurId
			);
		}
		
		return new UtilisateurRestDto(utilisateur);
	}
	
	@PostMapping("/utilisateurs")
	public UtilisateurRestDto save(@RequestBody UtilisateurRestDto utilisateurRestDto) {
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateurRestDto.build(utilisateur);
		
		utilisateur = utilisateurService.save(utilisateur);
		
		return new UtilisateurRestDto(utilisateur);
	}
	
	
//	@GetMapping("/utilisateurs")
//	public Utilisateur getByParamId(@RequestParam("utilisateurId") Integer utilisateurId) {
//    	
//		Utilisateur utilisateur = new Utilisateur();
//		
//		utilisateur.setId(utilisateurId);
//		utilisateur.setNom("Joestar");
//		utilisateur.setPrenom("Jodio");
//		
//		return utilisateur;
//	}
	
	@RequestMapping("/utilisateurs")
	public String showUtilisateurs() {
		return "utlisateurs";
	}
	
	@DeleteMapping("/utilisateurs/{utilisateurId}")
	public void deleteById(@PathVariable("utilisateurId") Integer utilisateurId) {
		utilisateurService.delete(utilisateurId);
	}

}

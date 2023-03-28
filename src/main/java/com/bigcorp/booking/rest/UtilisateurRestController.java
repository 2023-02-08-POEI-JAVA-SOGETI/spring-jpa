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

import com.bigcorp.booking.dto.UtilisateurDto;
import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.UtilisateurService;



@RestController
public class UtilisateurRestController {
	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping("/restUtilisateur/{utilisateurId}")
	public UtilisateurDto getById(@PathVariable("utilisateurId") Integer utilisateurId) {
	    Utilisateur utilisateur = utilisateurService.findById(utilisateurId);
	    if (utilisateur == null) {
	        throw new ResponseStatusException(
	            HttpStatus.NOT_FOUND, "Client not found with ID: " + utilisateurId);
	    }
	    UtilisateurDto utilisateurDto = new UtilisateurDto(utilisateur);
	    return utilisateurDto;
	}
	@GetMapping("/restUtilisateurs")
	public List<UtilisateurDto> getAllClient() {
		List<Utilisateur> utilisateurs =  (List<Utilisateur>) utilisateurService.findAll();
		List<UtilisateurDto> utilisateurDto = new ArrayList<>();
		for (Utilisateur utilisateur : utilisateurs) {
			utilisateurDto.add(new UtilisateurDto(utilisateur));
		}
		return utilisateurDto;
	}
	
	@DeleteMapping("/restUtilisateur/utilisateurId/delete")
	public void deleteById(@PathVariable("utilisateurId") Integer utilisateurId) {
		utilisateurService.delete(utilisateurId);
	}
	@PostMapping("/restUtilisateur/{utilisateurId}")
	public UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto) {
		Utilisateur utilisateur = new Utilisateur(utilisateurDto);		
		utilisateur = utilisateurService.save(utilisateur);
	    return new UtilisateurDto(utilisateur);
	}
}

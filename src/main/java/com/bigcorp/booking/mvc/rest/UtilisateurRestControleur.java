package com.bigcorp.booking.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.mvc.rest.dto.UtilisateurRestDto;
import com.bigcorp.booking.service.UtilisateurService;

import tp_spring_jpa_pablo.model.Utilisateur;

@RestController
public class UtilisateurRestControleur {   
    
	@Autowired
    private UtilisateurService utilisateurService;
	
	@GetMapping("/utilisateur/get/{utilisateurid}")
	public UtilisateurRestDto getByIdPath(@PathVariable("utilisateurid") Integer utilisateurid) {
		Utilisateur utilisateur = utilisateurService.findById(utilisateurid);
		if (utilisateur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun utilisateur trouvé avec l'id : "
					+ utilisateurid);
		}
		return new UtilisateurRestDto(utilisateur);
	}	

	@GetMapping("/utilisateur/get")
	public UtilisateurRestDto getByIdParam(@RequestParam("id") Integer id) {
		Utilisateur utilisateur = utilisateurService.findById(id);
		if (utilisateur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun utilisateur trouvé avec l'id : "
					+ id);
		}
		return new UtilisateurRestDto(utilisateur);
	}
	
	@PostMapping("/utilisateur/save")
	public UtilisateurRestDto saveUtilisateur(@RequestBody UtilisateurRestDto utilisateurRestDto) {
	    Utilisateur utilisateur = new Utilisateur();
	    utilisateur = utilisateurRestDto.remplisUtilisateur(utilisateur);
	    utilisateur = utilisateurService.save(utilisateur);
	    return new UtilisateurRestDto(utilisateur);
	}

	@DeleteMapping("/utilisateur/delete/{utilisateurid}")
	public void deleteUtilisateur(@PathVariable("utilisateurid") Integer utilisateurid) {
		Utilisateur utilisateur = utilisateurService.findById(utilisateurid);
		if (utilisateur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun utilisateur trouvé avec l'id : "
					+ utilisateurid);
		}
		utilisateurService.deleteById(utilisateurid);
	}
	
	// Coder la méthode dans votre RestController qui permette de supprimer une ressource.
	// Methode avec EntityManager
	@DeleteMapping("/utilisateur/delete-fait-maison1/{utilisateurid}")
	public void deleteUtilisateur2(@PathVariable("utilisateurid") Integer utilisateurid) {
		Utilisateur utilisateur = utilisateurService.findById(utilisateurid);
		if (utilisateur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun utilisateur trouvé avec l'id : "
					+ utilisateurid);
		}
		utilisateurService.deleteById2(utilisateurid);
	}
	
//	// Coder la méthode dans votre RestController qui permette de supprimer une ressource.
//		// Methode avec EntityManager
//		@DeleteMapping("/utilisateur/delete-fait-maison2/{id}")
//		public void deleteUtilisateur3(@PathVariable("id") Integer id) {
//		    utilisateurService.deleteById3(id);
//		}
	

    
}
package com.bigcorp.booking.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final Logger logger = LoggerFactory.getLogger(UtilisateurRestController.class);

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/restUtilisateur/{utilisateurId}")
    public ResponseEntity<UtilisateurDto> getById(@PathVariable("utilisateurId") Integer utilisateurId) {
        logger.info("Récupération de l'utilisateur avec l'ID: {}", utilisateurId);
        Utilisateur utilisateur = utilisateurService.findById(utilisateurId);
        if (utilisateur == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur introuvable avec l'ID: " + utilisateurId);
        }
        UtilisateurDto utilisateurDto = new UtilisateurDto(utilisateur);
        return ResponseEntity.ok(utilisateurDto);
    }

    @GetMapping("/restUtilisateurs")
    public ResponseEntity<List<UtilisateurDto>> getAllClient() {
        logger.info("Récupération de tous les utilisateurs");
        List<Utilisateur> utilisateurs = (List<Utilisateur>) utilisateurService.findAll();
        List<UtilisateurDto> utilisateurDto = new ArrayList<>();
        for (Utilisateur utilisateur : utilisateurs) {
            utilisateurDto.add(new UtilisateurDto(utilisateur));
        }
        return ResponseEntity.ok(utilisateurDto);
    }

    @DeleteMapping("/restUtilisateur/{utilisateurId}/delete")
    public void deleteById(@PathVariable("utilisateurId") Integer utilisateurId) {
        logger.info("Suppression de l'utilisateur avec l'ID: {}", utilisateurId);
        Utilisateur utilisateur = utilisateurService.findById(utilisateurId);
        if (utilisateur == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Utilisateur introuvable avec l'ID: " + utilisateurId);
        }
        utilisateurService.delete(utilisateurId);
    }

    @PostMapping("/restUtilisateur")
    public ResponseEntity<UtilisateurDto> save(@RequestBody UtilisateurDto utilisateurDto) {
        logger.info("Enregistrement d'un nouvel utilisateur");
        if (utilisateurDto.getId() != null) {
            logger.warn("Un nouvel utilisateur ne peut pas déjà avoir un ID");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Un nouvel utilisateur ne peut pas déjà avoir un ID");
        }
        Utilisateur utilisateur = new Utilisateur(utilisateurDto);
        utilisateur = utilisateurService.save(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UtilisateurDto(utilisateur));
    }
}

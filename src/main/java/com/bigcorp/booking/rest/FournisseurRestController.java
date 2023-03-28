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

import com.bigcorp.booking.dto.FournisseurDto;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;




@RestController
public class FournisseurRestController {

    private static final Logger logger = LoggerFactory.getLogger(FournisseurRestController.class);

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("/restFournisseur/{fournisseurId}")
    public ResponseEntity<FournisseurDto> getById(@PathVariable("fournisseurId") Integer fournisseurId) {
        logger.info("Récupération du fournisseur par ID: {}", fournisseurId);
        Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
        if (fournisseur == null) {
            logger.warn("Fournisseur non trouvé avec l'ID: {}", fournisseurId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fournisseur non trouvé avec l'ID: " + fournisseurId);
        }
        FournisseurDto fournisseurDto = new FournisseurDto(fournisseur);
        return ResponseEntity.ok(fournisseurDto);
    }

    @GetMapping("/restFournisseurs")
    public ResponseEntity<List<FournisseurDto>> getAllFournisseur() {
        logger.info("Récupération de tous les fournisseurs");
        List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurService.findAll();
        List<FournisseurDto> fournisseursDto = new ArrayList<>();
        for (Fournisseur fournisseur : fournisseurs) {
            fournisseursDto.add(new FournisseurDto(fournisseur));
        }
        return ResponseEntity.ok(fournisseursDto);
    }

    @DeleteMapping("/restFournisseur/{fournisseurId}/delete")
    public void deleteById(@PathVariable("fournisseurId") Integer fournisseurId) {
        logger.info("Suppression du fournisseur par ID: {}", fournisseurId);
        Fournisseur fournisseur = fournisseurService.findById(fournisseurId);
        if (fournisseur == null) {
            logger.warn("Fournisseur non trouvé avec l'ID: {}", fournisseurId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fournisseur non trouvé avec l'ID: " + fournisseurId);
        }
        fournisseurService.delete(fournisseurId);
    }

    @PostMapping("/restFournisseur")
    public ResponseEntity<FournisseurDto> save(@RequestBody FournisseurDto fournisseurDto) {
        logger.info("Enregistrement d'un nouveau fournisseur");
        if (fournisseurDto.getId() != null) {
            logger.warn("Un nouveau fournisseur ne peut pas déjà avoir un ID");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Un nouveau fournisseur ne peut pas déjà avoir un ID");
        }
        Fournisseur fournisseur = new Fournisseur(fournisseurDto);
        fournisseur = fournisseurService.save(fournisseur);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FournisseurDto(fournisseur));
    }
}

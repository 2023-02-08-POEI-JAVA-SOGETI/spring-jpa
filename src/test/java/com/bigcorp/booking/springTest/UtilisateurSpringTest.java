package com.bigcorp.booking.springTest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.UtilisateurService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class UtilisateurSpringTest {

    @Autowired
    private UtilisateurService utilisateurService;

    @Test
    public void testSaveAndFindById() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Doe");
        utilisateur.setPrenom("John");
        utilisateur.setEmail("johndoe@example.com");

        Utilisateur savedUtilisateur = utilisateurService.save(utilisateur);

        Utilisateur foundUtilisateur = utilisateurService.findById(savedUtilisateur.getId());

        assertEquals(savedUtilisateur.getId(), foundUtilisateur.getId());
        assertEquals(savedUtilisateur.getNom(), foundUtilisateur.getNom());
        assertEquals(savedUtilisateur.getPrenom(), foundUtilisateur.getPrenom());
        assertEquals(savedUtilisateur.getEmail(), foundUtilisateur.getEmail());
    }

    @Test
    public void testDelete() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Doe");
        utilisateur.setPrenom("John");
        utilisateur.setEmail("johndoe@example.com");

        Utilisateur savedUtilisateur = utilisateurService.save(utilisateur);

        utilisateurService.delete(savedUtilisateur.getId());

        assertNull(utilisateurService.findById(savedUtilisateur.getId()));
    }

    @Test
    public void testFindAll() {
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setNom("Doe");
        utilisateur1.setPrenom("John");
        utilisateur1.setEmail("johndoe@example.com");

        Utilisateur utilisateur2 = new Utilisateur();
        utilisateur2.setNom("Smith");
        utilisateur2.setPrenom("Jane");
        utilisateur2.setEmail("janesmith@example.com");

        utilisateurService.save(utilisateur1);
        utilisateurService.save(utilisateur2);

        List<Utilisateur> utilisateurs = (List<Utilisateur>) utilisateurService.findAll();

        assertEquals(2, utilisateurs.size());
        assertEquals("Doe", utilisateurs.get(0).getNom());
        assertEquals("John", utilisateurs.get(0).getPrenom());
        assertEquals("johndoe@example.com", utilisateurs.get(0).getEmail());
        assertEquals("Smith", utilisateurs.get(1).getNom());
        assertEquals("Jane", utilisateurs.get(1).getPrenom());
        assertEquals("janesmith@example.com", utilisateurs.get(1).getEmail());
    }
}
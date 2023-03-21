package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateurSpringDao;
import com.bigcorp.booking.model.Utilisateur;

/**
 * Service pour l'entité Utilisateur.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurSpringDao utilisateurSpringDao;
	
	
	
	public List<Utilisateur> findByNom(String nom) {
		return this.utilisateurSpringDao.maMethodeDeRechercheAvecUneQueryExplicite(nom);
	}


	/**
	 * Sauvegarde utilisateur
	 * @param utilisateur
	 * @return 
	 */
	
	
	@Transactional
	public Utilisateur sauvegarde(Utilisateur utilisateur) {
		return this.utilisateurSpringDao.save(utilisateur);
	}
	
	@Transactional
	public void supprimer(Integer id) {
		this.utilisateurSpringDao.deleteById(id);
	}
	
	
	public Utilisateur get(Integer id) {
		return this.utilisateurSpringDao.findById(id).orElse(null);
	}
	
	

	/**
	 * Récupère Utilisateur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	/*
	public Utilisateur findById(Long id) {
		return this.utilisateurSpringDao.findById(id).orElse(null);
	} */
	

	/**
	 * Renvoie tous les Utilisateur présents en base
	 */
	
	/*
	public Iterable<Utilisateur> findAll(){
		return this.utilisateurSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Utilisateur présentes en base
	 * @return
	 */
	
	/*
	public long count() {
		return this.utilisateurSpringDao.count();
	}

	/**
	 * Supprime un Utilisateur par son identifiant.
	 * @param id
	 */
	
	/*
	@Transactional
	public void delete(Long id) {
		this.utilisateurSpringDao.deleteById(id);
	}
*/
}
package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateurDao;
import com.bigcorp.booking.model.Utilisateur;

/**
 * Service pour l'entité Utilisateur.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurDao utilisateurDao;

	/**
	 * Sauvegarde utilisateur
	 * @param utilisateur
	 */
	@Transactional
	public Utilisateur save(Utilisateur utilisateur) {
		return this.utilisateurDao.save(utilisateur);
	}

	/**
	 * Récupère Utilisateur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Utilisateur findById(Integer id) {
		return this.utilisateurDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Utilisateur présents en base
	 */
	public Iterable<Utilisateur> findAll(){
		return this.utilisateurDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Utilisateur présentes en base
	 * @return
	 */
	public long count() {
		return this.utilisateurDao.count();
	}

	/**
	 * Supprime un Utilisateur par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		this.utilisateurDao.deleteById(id);
	}

	/**
	 * Récupère Utilisateur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	

}
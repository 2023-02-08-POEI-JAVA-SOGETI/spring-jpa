package com.bigcorp.booking.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateurSpringDao;
import com.bigcorp.booking.model.Utilisateur;

@Service
public class UtilisateurService {
	@Autowired
	private  UtilisateurSpringDao utilisateurSpringDao ;
	private static final Logger logger = LoggerFactory.getLogger(FournisseurService.class);
	
	@Transactional
	public Utilisateur save(Utilisateur utilisateur) {
		logger.info("Save utilisateur: {}", utilisateur);
		return this.utilisateurSpringDao.save(utilisateur);
	}
	
	public void delete(Long  id) {
		logger.info("Delete utilisateur: {}", id);
		utilisateurSpringDao.deleteById(id);
	}
	
	public Optional<Utilisateur> findById(Long id) {
		logger.info("Find utilisateur: {}", id);
		return utilisateurSpringDao.findById(id);
	}
	
	public Iterable<Utilisateur> ListArticles(){
		logger.info("List utilisateurs:");
		return utilisateurSpringDao.findAll();
	}
	
	public Utilisateur findByName(String name) {
		logger.info("Find utilisateur: {}", name);
		return utilisateurSpringDao.findByNom(name);
	}
}

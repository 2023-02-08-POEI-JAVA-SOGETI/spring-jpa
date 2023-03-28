package com.bigcorp.booking.service;

import java.util.List;


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
	
	public void delete(Integer  id) {
		logger.info("Delete utilisateur: {}", id);
		utilisateurSpringDao.deleteById(id);
	}
	
	public Utilisateur findById(Integer id) {
		logger.info("Find utilisateur: {}", id);
		return utilisateurSpringDao.findById(id).orElse(null);
	}
	
	public Iterable<Utilisateur> ListArticles(){
		logger.info("List utilisateurs:");
		return utilisateurSpringDao.findAll();
	}
	
	public List<Utilisateur> findByName(String name) {
		logger.info("Find utilisateur: {}", name);
		return utilisateurSpringDao.findByNom(name);
	}

	public Iterable<Utilisateur> findAll() {
		return utilisateurSpringDao.findAll();
		}
}

package com.bigcorp.booking.service.spring;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateurSpringDao;

import com.bigcorp.booking.model.Utilisateur;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UtilisateurSpringService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurSpringService.class);
	@Autowired
	private UtilisateurSpringDao utilisateurSpringDao;

	@Transactional
	public void save(Utilisateur utilisateur) {
		LOGGER.info("Saving");
		this.utilisateurSpringDao.save(utilisateur);
		LOGGER.info("Saved");
	}

	public Utilisateur findById(Integer id) {
		LOGGER.info("Searching");
		return this.utilisateurSpringDao.findById(id).orElse(null);	
	}

	public List<Utilisateur> findContainingName(String name) {
		LOGGER.info("Searching");
		return this.utilisateurSpringDao.findByNomContaining(name);
	}

	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Deleting");
		this.utilisateurSpringDao.deleteById(id);
		LOGGER.info("Deleted");
	}
}

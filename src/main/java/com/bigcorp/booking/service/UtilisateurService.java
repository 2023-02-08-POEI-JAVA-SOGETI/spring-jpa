package com.bigcorp.booking.service;

import com.bigcorp.booking.dao.spring.UtilisateurDao;
import com.bigcorp.booking.model.Utilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UtilisateurService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurService.class);

	@Autowired
	private UtilisateurDao utilisateurDao;

	@Transactional
	public Utilisateur save(Utilisateur utilisateur)  {
			LOGGER.info("User successfully saved!");
			
			return this.utilisateurDao.save(utilisateur);
	}

	@Transactional
	public void delete(int id) throws IllegalArgumentException {
		if (id != 0) {
			this.utilisateurDao.deleteById(id);
			
			LOGGER.info("User successfully removed!");
		} else {
			LOGGER.info("User couldn't be removed.");
		}
	}

	@Transactional
	public Utilisateur getById(int id) {
		if (id == 0) return null;

		return this.utilisateurDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Aucun utilisateur avec l'id " + id));
	}

	@Transactional
	public List<Utilisateur> getByName(String name) {
		if (name == "") return null;

		List<Utilisateur> utilisateurs = this.utilisateurDao.findByName(name);

		return utilisateurs.isEmpty() ? null : utilisateurs;
	}
}

package com.bigcorp.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Fournisseur;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurService.class);

	@Transactional
	public Fournisseur save(Fournisseur fournisseur) {
		LOGGER.info("save : " + fournisseur.getId() + " - " + fournisseur.getNom());
		return this.fournisseurSpringDao.save(fournisseur);
	}

	public Fournisseur findById(Integer id) {
		LOGGER.info("findById : " + id);
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}

	public List<Fournisseur> findAll(){
		LOGGER.info("findAll fournisseur");
		return (List<Fournisseur>) this.fournisseurSpringDao.findAll();
	}
	
	@Transactional
	public void deleteById(Integer id) {
		LOGGER.info("deleteById : " + id);
		this.fournisseurSpringDao.deleteById(id);
	}

}
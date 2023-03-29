package com.bigcorp.booking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Fournisseur;

/**
 * Service pour l'entité Fournisseur.
 */
@Service
public class FournisseurService{
	
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	@SuppressWarnings("unused")
	@Autowired
	private  ArticleSpringDao articleSpringDao;
	private static final Logger logger = LoggerFactory.getLogger(FournisseurService.class);
	
	@Transactional
	public Fournisseur save(Fournisseur fournisseur) {
		logger.info("Save fournisseur: {}", fournisseur);
		return this.fournisseurSpringDao.save(fournisseur);
	}
	
	public void delete(Integer  id) {
		logger.info("Delete fournisseur: {}", id);
		fournisseurSpringDao.deleteById(id);
	}
	
	public Fournisseur findById(Integer id) {
		logger.info("Find fournisseur: {}", id);
		return fournisseurSpringDao.findById(id).orElse(null);
	}
	
	public Iterable<Fournisseur> findAll(){
		logger.info("list fournisseurs: ");
		return fournisseurSpringDao.findAll();
	}
	
	public List<Fournisseur> findByName(String name) {
		logger.info("Find fournisseur: {}", name);
		return fournisseurSpringDao.findByNom(name);
	}
	
	public Fournisseur findByIdWithArticles(Integer id) {
		logger.info("Find fournisseur: {}", id);
		return fournisseurSpringDao.findByIdWithArticles(id);
	}

}

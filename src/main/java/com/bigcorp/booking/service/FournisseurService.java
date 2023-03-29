package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurSpringDao;

import tp_spring_jpa_pablo.model.Fournisseur;

@Service
public class FournisseurService {
	
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	
	public Iterable<Fournisseur> findAll(){
		return this.fournisseurSpringDao.findAll();
	}
	
	@Transactional
	public Fournisseur save(Fournisseur fournisseur) {
		return this.fournisseurSpringDao.save(fournisseur);
	}
	
	public Fournisseur findById(Integer id) {
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		this.fournisseurSpringDao.deleteById(id);
	}
	
	// Crée dans le cours
	public void findByNom(String nomFournisseur) {
		this.fournisseurSpringDao.findByNom(nomFournisseur);
	}	

	

}

package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurSDao;

import tp_spring_jpa_pablo.model.Fournisseur;

@Service
public class FournisseurService {
	
	@Autowired
	private FournisseurSDao fournisseurSDao;
	
	public Iterable<Fournisseur> findAll(){
		return this.fournisseurSDao.findAll();
	}
	
	@Transactional
	public Fournisseur save(Fournisseur User) {
		return this.fournisseurSDao.save(User);
	}
	
	public Fournisseur findById(Integer id) {
		return this.fournisseurSDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void delete(Integer id) {
		this.fournisseurSDao.deleteById(id);
	}
	
	// Crée dans le cours
		public void findByNom(String nomFournisseur) {
			this.fournisseurSDao.findByNom(nomFournisseur);
		}
	

}

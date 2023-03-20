package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateurSDao;

import tp_spring_jpa_pablo.model.Utilisateur;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurSDao utilisateurSDao;
	
	public Iterable<Utilisateur> findAll(){
		return this.utilisateurSDao.findAll();
	}
	
	@Transactional
	public Utilisateur save(Utilisateur User) {
		return this.utilisateurSDao.save(User);
	}
	
	public Utilisateur findById(Integer id) {
		return this.utilisateurSDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void delete(Integer id) {
		this.utilisateurSDao.deleteById(id);
	}	
	

}

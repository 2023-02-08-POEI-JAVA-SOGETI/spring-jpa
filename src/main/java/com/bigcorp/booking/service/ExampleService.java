package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ExampleSpringDao;
import com.bigcorp.booking.model.Example;

/**
 * Service pour l'entité Example.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class ExampleService {

	@Autowired
	private ExampleSpringDao exampleSpringDao;

	/**
	 * Sauvegarde example
	 * @param example
	 */
	@Transactional
	public void save(Example example) {
		this.exampleSpringDao.save(example);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Example findById(Long id) {
		return this.exampleSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Example présents en base
	 */
	public Iterable<Example> findAll(){
		return this.exampleSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Example présentes en base
	 * @return
	 */
	public long count() {
		return this.exampleSpringDao.count();
	}

	/**
	 * Supprime un Example par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		this.exampleSpringDao.deleteById(id);
	}

}
package com.bigcorp.booking.service;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.TypeRestaurantSpringDao;
import com.bigcorp.booking.model.TypeRestaurant;


/**
 * Service pour l'entité TypeRestaurant.
 */
@Service
public class TypeRestaurantService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TypeRestaurantService.class);
	
	@Autowired
	private TypeRestaurantSpringDao typeRestaurantSpringDao;

	/**
	 * Sauvegarde typeRestaurant
	 * @param typeRestaurant
	 * @return le typeRestaurant sauvegardé : instance à utiliser car
	 * potentiellement différente de l'argument typeRestaurant
	 * @throws TypeRestaurantException 
	 */
	@Transactional
	public TypeRestaurant save(TypeRestaurant typeRestaurant) {
		LOGGER.info("Sauvegarde de : {}" , typeRestaurant);
		
			return this.typeRestaurantSpringDao.save(typeRestaurant);

	}

	/**
	 * Récupère TypeRestaurant par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public TypeRestaurant findById(Integer id) {
		LOGGER.info("Récupération de typeRestaurant avec l'id : {}" , id);
		return this.typeRestaurantSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les TypeRestaurant présents en base
	 */
	public Iterable<TypeRestaurant> findAll(){
		LOGGER.info("Récupération de tous les typeRestaurants");
		return this.typeRestaurantSpringDao.findAll();
	}
	
	/**
	 * Supprime un TypeRestaurant par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Suppression de typeRestaurant avec l'id : {}" , id);
		this.typeRestaurantSpringDao.deleteById(id);
	}

}
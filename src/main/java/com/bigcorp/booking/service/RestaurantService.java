package com.bigcorp.booking.service;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.RestaurantSpringDao;
import com.bigcorp.booking.model.Restaurant;


/**
 * Service pour l'entité Restaurant.
 */
@Service
public class RestaurantService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);
	
	@Autowired
	private RestaurantSpringDao restaurantSpringDao;

	/**
	 * Sauvegarde restaurant
	 * @param restaurant
	 * @return le restaurant sauvegardé : instance à utiliser car
	 * potentiellement différente de l'argument restaurant
	 * @throws RestaurantException 
	 */
	@Transactional
	public Restaurant save(Restaurant restaurant) {
		LOGGER.info("Sauvegarde de : {}" , restaurant);
		
			return this.restaurantSpringDao.save(restaurant);

	}

	/**
	 * Récupère Restaurant par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Restaurant findById(Integer id) {
		LOGGER.info("Récupération de restaurant avec l'id : {}" , id);
		return this.restaurantSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Restaurant présents en base
	 */
	public Iterable<Restaurant> findAll(){
		LOGGER.info("Récupération de tous les restaurants");
		return this.restaurantSpringDao.findAll();
	}
	
	/**
	 * Supprime un Restaurant par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Suppression de restaurant avec l'id : {}" , id);
		this.restaurantSpringDao.deleteById(id);
	}

}
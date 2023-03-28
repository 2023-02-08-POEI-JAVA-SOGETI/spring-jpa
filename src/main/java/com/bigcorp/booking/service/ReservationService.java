package com.bigcorp.booking.service;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ReservationSpringDao;
import com.bigcorp.booking.model.Reservation;


/**
 * Service pour l'entité Reservation.
 */
@Service
public class ReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);
	
	@Autowired
	private ReservationSpringDao reservationSpringDao;

	/**
	 * Sauvegarde reservation
	 * @param reservation
	 * @return le reservation sauvegardé : instance à utiliser car
	 * potentiellement différente de l'argument reservation
	 * @throws ReservationException 
	 */
	@Transactional
	public Reservation save(Reservation reservation) {
		LOGGER.info("Sauvegarde de : {}" , reservation);
		
			return this.reservationSpringDao.save(reservation);

	}

	/**
	 * Récupère Reservation par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Reservation findById(Integer id) {
		LOGGER.info("Récupération de reservation avec l'id : {}" , id);
		return this.reservationSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Reservation présents en base
	 */
	public Iterable<Reservation> findAll(){
		LOGGER.info("Récupération de tous les reservations");
		return this.reservationSpringDao.findAll();
	}
	
	/**
	 * Supprime un Reservation par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Suppression de reservation avec l'id : {}" , id);
		this.reservationSpringDao.deleteById(id);
	}

}
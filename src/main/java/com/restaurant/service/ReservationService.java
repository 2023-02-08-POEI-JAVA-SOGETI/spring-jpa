package com.restaurant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;
import com.restaurant.dao.ReservationDao;
import com.restaurant.model.Reservation;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationDao reservationDaoSpring;
//	@Autowired
//	private RestaurantDaoSpring restaurantDaoSpring;
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
	
	@Transactional
	public Reservation save(Reservation reservation) {
		logger.info("Save reservation : {}", reservation);
		return this.reservationDaoSpring.save(reservation);
	}
	
	public void delete(Integer  id) {
		logger.info("Delete reservation : {}", id);
		reservationDaoSpring.deleteById(id);
	}
	
	public Iterable<Reservation> findAll() {
		return reservationDaoSpring.findAll();
	}
	
	public Reservation findById(Integer id) {
		logger.info("Find reservation: {}", id);
		return reservationDaoSpring.findById(id).orElse(null);
	}
	
	public Iterable<Reservation> ListReservation(){
		logger.info("List reservation : ");
		return reservationDaoSpring.findAll();
	}
	
//	public Reservation linkRestaurantToReservation(Integer reservationId, Integer restaurantId) {
//		if (reservationId == null) {
//			throw new IllegalArgumentException("id reservation ne peut etre null");
//		} else if (restaurantId == null) {
//			throw new IllegalArgumentException("id restaurant ne peut etre null");		
//		}		
//		Reservation reservation = reservationDaoSpring.findById(reservationId).orElseThrow(IllegalArgumentException::new);
//		Restaurant restaurant = restaurantDaoSpring.findById(restaurantId).orElse(null);
//		
//		reservation.setrestaurant(restaurant);
//        return reservationDaoSpring.save(reservation);
//	}	
}

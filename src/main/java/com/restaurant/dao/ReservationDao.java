package com.restaurant.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.Reservation;

@Repository
public interface ReservationDao extends CrudRepository<Reservation, Integer> {

	


}

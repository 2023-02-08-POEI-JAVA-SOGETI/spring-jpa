package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Reservation;


@Repository
public interface ReservationSpringDao extends CrudRepository<Reservation, Integer>  {
	
	

}
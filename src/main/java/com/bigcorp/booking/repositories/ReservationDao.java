package com.bigcorp.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.models.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer> {
	
}

package com.bigcorp.booking.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.booking.models.Reservation;
import com.bigcorp.booking.repositories.ReservationDao;

@Service
public class ReservationService {

	@Autowired
	private ReservationDao reservationDao;

}
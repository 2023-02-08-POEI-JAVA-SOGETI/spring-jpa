package com.bigcorp.booking.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bigcorp.booking.services.ReservationService;

@RestController
public class ReservationRestControleur {

	@Autowired
	private ReservationService reservationService;

	
}
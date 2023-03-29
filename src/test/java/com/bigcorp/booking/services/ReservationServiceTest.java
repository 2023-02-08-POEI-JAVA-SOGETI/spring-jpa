package com.bigcorp.booking.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.dto.ReservationDto;
import com.bigcorp.booking.models.Reservation;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ReservationServiceTest {

	@Autowired
	private ReservationService reservationService;

	@Test
	@DisplayName("service saves a booking correctly")
	void testSave() {
		Reservation reservation = new Reservation.Builder()
				.withNomReservant("Bond")
				.withPrenomReservant("James")
				.withTelephoneReservant("010203")
				.build();
		ReservationDto reservationDto = new ReservationDto(reservation);	
		reservation = reservationService.save(reservationDto);

		Assertions.assertNotNull(reservation);
		Assertions.assertNotNull(reservation.getId());
	}

	@Test
	@DisplayName("service deletes a booking correctly")
	void testDelete() {
		ReservationDto reservationDto = reservationService.findById(1);

		reservationService.deleteById(reservationDto.getId());

		Assertions.assertNull(reservationService.findById(1));
	}

	@Test
	@DisplayName("service finds a booking by its id correctly")
	void testFindById() {
		ReservationDto reservationDto = reservationService.findById(1);

		Assertions.assertNotNull(reservationDto);
	}
}
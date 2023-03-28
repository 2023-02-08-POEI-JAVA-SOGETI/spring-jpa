package com.restaurant.controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.spring.SpringConfiguration;
import com.restaurant.model.Reservation;
import com.restaurant.service.ReservationService;

@SpringJUnitConfig(SpringConfiguration.class)
class ReservationServiceTest {

	@Autowired
	private ReservationService reservationService;
	
//	@Autowired
//	private RestaurantService restaurantService;
	
	
	@BeforeEach
    public void setUp() throws Exception {
        // Ajouter des réservations pour tester les méthodes
        Reservation r1 = new Reservation("nom1", "prenom1", "1234567890", LocalDateTime.now());
        Reservation r2 = new Reservation("nom2", "prenom2", "0987654321", LocalDateTime.now());
        reservationService.save(r1);
        reservationService.save(r2);
    }
	@Test
	public void testSaveGet() {
		Reservation r1 = new Reservation("nom1", "prenom1", "1234567890", LocalDateTime.now());
		Reservation reservationRecupere = this.reservationService.findById(r1.getId());
		Assertions.assertNotNull(reservationRecupere);
	}

	@Test
	public void testDelete() {
		Reservation r1 = new Reservation("nom1", "prenom1", "1234567890", LocalDateTime.now());
		reservationService.save(r1);
		reservationService.delete(r1.getId());
		Assertions.assertNull(r1);
	}

	@Test
	public void testFindAll() {
		Iterable<Reservation> reservations = reservationService.findAll();
		Integer compteur = 0;
		for (Reservation r : reservations ) 
			compteur++;			
		Assertions.assertEquals(2, compteur);
	}
	
	@Test
	public void testFindById() {
		Reservation r1 = new Reservation("nom1", "prenom1", "1234567890", LocalDateTime.now());
		reservationService.save(r1);
		Reservation reservationRecupere = this.reservationService.findById(r1.getId());
		Assertions.assertEquals(r1.getId(), reservationRecupere.getId());
	}
	
}

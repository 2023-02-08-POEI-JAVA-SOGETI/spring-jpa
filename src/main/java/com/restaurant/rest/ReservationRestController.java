package com.restaurant.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.restaurant.dto.ReservationDto;
import com.restaurant.model.Reservation;
import com.restaurant.model.Restaurant;
import com.restaurant.service.ReservationService;
import com.restaurant.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/reservation")
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/list-reservations")
    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations = (List<Reservation>) reservationService.findAll();
        return reservations.stream().map(ReservationDto::new).collect(Collectors.toList());
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ReservationDto getReservationById(@PathVariable("id") Integer id) {
		Reservation r = reservationService.findById(id);
		if (r == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun restaurant trouvé avec l'id " + id);			
		}
		return new ReservationDto(r);
	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("")
	public ReservationDto createReservation(@Valid @RequestBody ReservationDto reservationDto, BindingResult result) {
		if (result.hasErrors()) {
			//concaténation des erreurs liées aux champs non valides
			String reason = "Erreur : " + result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(" "));
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, reason);
		}
		
		Reservation reservation = new Reservation();
		reservationDto.remplisReservation(reservation);
		
		Restaurant restaurant = this.restaurantService.findById(reservationDto.getRestaurantId());
		if (restaurant == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "RestaurantId inconnu");
		}
		reservation.setRestaurant(restaurant);
		
		return new ReservationDto(reservationService.save(reservation));
	}
}

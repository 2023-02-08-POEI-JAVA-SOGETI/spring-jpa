package com.bigcorp.booking.mvc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.bigcorp.booking.model.Reservation;
import com.bigcorp.booking.mvc.rest.dto.ReservationRestDto;
import com.bigcorp.booking.service.ReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservationsrest")
public class ReservationRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

	@Autowired
	private ReservationService reservationService;

	@GetMapping("/{reservationId}")
	public ReservationRestDto getById(@PathVariable("reservationId") Integer reservationId) {
		LOGGER.info("Recherche du reservation avec l'id : {}", reservationId);
		Reservation reservation = reservationService.findById(reservationId);
		if (reservation == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucune réservation trouvée avec l'id : " + reservationId);
		}
		return new ReservationRestDto(reservation);
	}

	@GetMapping
	public List<ReservationRestDto> getAll() {
		Iterable<Reservation> reservations = reservationService.findAll();
		List<ReservationRestDto> reservationDtos = new ArrayList<>();
		for (Reservation reservation : reservations) {
			reservationDtos.add(new ReservationRestDto(reservation));
		}
		return reservationDtos;
	}

	/*
	 * @GetMapping public ReservationRestDto getByIdParamsEdition(@RequestParam("id")
	 * Integer reservationId) { Reservation reservation =
	 * reservationService.findById(reservationId);
	 * LOGGER.info("Recherche du reservation avec l'id : {}", reservationId); if
	 * (reservation == null) { throw new
	 * ResponseStatusException(HttpStatus.NOT_FOUND,
	 * "Aucun reservation trouvé avec l'id : " + reservationId); }
	 *
	 * return new ReservationRestDto(reservation); }
	 */
	// fonctionnel si besoin
	@DeleteMapping("/{reservationId}")
	public void deleteById(@PathVariable("reservationId") Integer reservationId) {
		Reservation reservation = reservationService.findById(reservationId);
		LOGGER.info("Suppression de la réservation avec l'id : {}", reservationId);
		if (reservation == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucune réservation trouvé avec l'id : " + reservationId + ", pas de suppression effectuée.");
		}
		reservationService.delete(reservationId);
		LOGGER.info("Réservation avec l'id : {} supprimée avec succès", reservationId);
	}

	@PostMapping
	public ReservationRestDto post(@RequestBody ReservationRestDto reservationRestDto) {
		LOGGER.info("Création ou modification d'une réservation");
		Reservation reservation = new Reservation();
		if (reservationRestDto.getId() != null) {
			reservation = reservationService.findById(reservationRestDto.getId());
			if (reservation == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun reservation trouvé avec l'id : "
						+ reservationRestDto.getId() + ", vous ne pouvez pas définir manuellement un id.");
			}

		}
		reservationRestDto.remplisReservation(reservation);
		reservation = reservationService.save(reservation);
		LOGGER.info("Réservation créée ou modifiée avec succès au nom de : {}", reservation.getNomReservant());
		return new ReservationRestDto(reservation);
	}

	@PutMapping("/{reservationId}")

	public ReservationRestDto update(@PathVariable("reservationId") Integer reservationId,

			@RequestBody ReservationRestDto reservationRestDto) {

		LOGGER.info("Mise à jour de la réservation avec l'id : {}", reservationId);

		Reservation reservation = reservationService.findById(reservationId);

		if (reservation == null) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND,

					"Aucune réservation trouvée avec l'id : " + reservationId);

		}

		reservation.setNomReservant(reservationRestDto.getNomReservant());

		reservation.setPrenomReservant(reservationRestDto.getPrenomReservant());

		reservation.setTelephoneReservant(reservationRestDto.getTelephoneReservant());
		
		reservation.setDateHeure(reservationRestDto.getDateHeure());

		try {

			reservationService.save(reservation);

		} catch (PersistenceException e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,

					"Erreur lors de la mise à jour de la réservation avec l'id : " + reservationId, e);

		}

		return new ReservationRestDto(reservation);

	}

}

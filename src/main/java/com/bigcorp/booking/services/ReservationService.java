package com.bigcorp.booking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.booking.dto.ReservationDto;
import com.bigcorp.booking.models.Reservation;
import com.bigcorp.booking.repositories.ReservationDao;

@Service
public class ReservationService {

	@Autowired
	private ReservationDao reservationDao;

	@Transactional
	public List<Reservation> findAll() {

		return this.reservationDao.findAll();
	}

	@Transactional
	public Reservation save(ReservationDto reservationDto) {
		Reservation reservation = new Reservation();
		reservation = reservationDto.rempliReservation(reservation);
		return this.reservationDao.save(reservation);
	}

	@Transactional
	public ReservationDto findById(Integer id) {
		Reservation reservation = reservationDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Aucune reservation avec l'id" + id));
		ReservationDto reservationDto = new ReservationDto(reservation);
		return reservationDto;
	}

	@Transactional
	public Reservation update(ReservationDto reservationDto) {
		if (reservationDto.getId() == null) {
			throw new IllegalArgumentException("Mise à jour impossible, la reservation n'existe pas");
		} else {
			Reservation reservation = reservationDto.rempliReservation(new Reservation());
			Reservation savedReservation = reservationDao.save(reservation);
			return savedReservation;
		}
	}

	@Transactional
	public void deleteById(Integer id) {
		reservationDao.deleteById(id);
	}

}
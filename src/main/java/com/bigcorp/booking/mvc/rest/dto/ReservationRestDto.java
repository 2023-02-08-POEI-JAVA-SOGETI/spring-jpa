package com.bigcorp.booking.mvc.rest.dto;

import com.bigcorp.booking.model.Reservation;

import java.time.LocalDateTime;



public class ReservationRestDto {

	private Integer id;
	private String nomReservant;
	private String prenomReservant;
	private String telephoneReservant;
	private LocalDateTime dateHeure;

	public ReservationRestDto() {

	}
	
	
	public ReservationRestDto(Reservation reservation) {
		this.id = reservation.getId();
		this.nomReservant = reservation.getNomReservant();
		this.prenomReservant = reservation.getPrenomReservant();
		this.telephoneReservant = reservation.getTelephoneReservant();
		this.dateHeure = reservation.getDateHeure();
		
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomReservant() {
		return nomReservant;
	}

	public void setNomReservant(String nomReservant) {
		this.nomReservant = nomReservant;
	}

	public String getPrenomReservant() {
		return prenomReservant;
	}

	public void setPrenomReservant(String prenomReservant) {
		this.prenomReservant = prenomReservant;
	}

	public String getTelephoneReservant() {
		return telephoneReservant;
	}

	public void setTelephoneReservant(String telephoneReservant) {
		this.telephoneReservant = telephoneReservant;
	}

	public LocalDateTime getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(LocalDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}
	

	public void remplisReservation(Reservation reservation) {
		reservation.setId(this.id);
		reservation.setNomReservant(this.nomReservant);
		reservation.setPrenomReservant(this.prenomReservant);
		reservation.setTelephoneReservant(this.telephoneReservant);
		reservation.setDateHeure(this.dateHeure);
		
	}
}

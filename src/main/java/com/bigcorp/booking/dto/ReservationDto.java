package com.bigcorp.booking.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

import com.bigcorp.booking.models.Reservation;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ReservationDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@NotEmpty
	private String nomReservant;
	@NotEmpty
	private String prenomReservant;
	@NotEmpty
	private String telephoneReservant;
	@NotEmpty
	private LocalDateTime dateHeureDebut;
	
	
	
	
	public Reservation rempliReservation(Reservation reservation)
	{
		reservation.setId(this.id);
		reservation.setNomReservant(this.nomReservant);
		reservation.setPrenomReservant(this.prenomReservant);
		reservation.setTelephoneReservant(this.telephoneReservant);
		reservation.setDateHeureDebut(this.dateHeureDebut);
		return reservation;
	}
	
	
	
	
	// CONSTRUCTEURS
	
	public ReservationDto() {
		super();
	}
	
	
	public ReservationDto(Reservation reservation) {
		this.id = reservation.getId();
		this.nomReservant = reservation.getNomReservant();
		this.prenomReservant = reservation.getPrenomReservant();
		this.telephoneReservant = reservation.getTelephoneReservant();
		this.dateHeureDebut = reservation.getDateHeureDebut();
	}
	
	
	
	public ReservationDto(Integer id, @NotEmpty String nomReservant, @NotEmpty String prenomReservant,
			@NotEmpty String telephoneReservant, @NotEmpty LocalDateTime dateHeureDebut) {
		super();
		this.id = id;
		this.nomReservant = nomReservant;
		this.prenomReservant = prenomReservant;
		this.telephoneReservant = telephoneReservant;
		this.dateHeureDebut = dateHeureDebut;
	
	
	
	
	// GETTER SETTER
	
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
	public LocalDateTime getDateHeureDebut() {
		return dateHeureDebut;
	}
	public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}
	
	
	

}

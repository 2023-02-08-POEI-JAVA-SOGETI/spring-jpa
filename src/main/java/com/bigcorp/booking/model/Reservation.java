package com.bigcorp.booking.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomReservant;
	private String prenomReservant;
	private String telephoneReservant;
	private LocalDateTime dateHeure;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	
	public Reservation() {
	}

	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNomReservant() {
		return this.nomReservant;
	}
	public void setNomReservant(String nomReservant) {
		this.nomReservant = nomReservant;
	}

	
	public String getPrenomReservant() {
		return this.prenomReservant;
	}
	public void setPrenomReservant(String prenomReservant) {
		this.prenomReservant = prenomReservant;
	}

	
	public String getTelephoneReservant() {
		return this.telephoneReservant;
	}
	public void setTelephoneReservant(String telephoneReservant) {
		this.telephoneReservant = telephoneReservant;
	}

	
	public LocalDateTime getDateHeure() {
		return this.dateHeure;
	}
	public void setDateHeure(LocalDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
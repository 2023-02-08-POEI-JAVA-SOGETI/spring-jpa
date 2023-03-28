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
	private String nom_reservant;
	private String prenom_reservant;
	private String telephone_reservant;
	private LocalDateTime date_heure;
	
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

	
	public String getNom_reservant() {
		return this.nom_reservant;
	}
	public void setNom_reservant(String nom_reservant) {
		this.nom_reservant = nom_reservant;
	}

	
	public String getPrenom_reservant() {
		return this.prenom_reservant;
	}
	public void setPrenom_reservant(String prenom_reservant) {
		this.prenom_reservant = prenom_reservant;
	}

	
	public String getTelephone_reservant() {
		return this.telephone_reservant;
	}
	public void setTelephone_reservant(String telephone_reservant) {
		this.telephone_reservant = telephone_reservant;
	}

	
	public LocalDateTime getDate_heure() {
		return this.date_heure;
	}
	public void setDate_heure(LocalDateTime date_heure) {
		this.date_heure = date_heure;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
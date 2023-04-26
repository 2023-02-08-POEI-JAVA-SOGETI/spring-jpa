package com.restaurant.dto;

import com.restaurant.model.Reservation;

public class ReservationDto {
	private Integer id;
	private String nom;
	private String prenom;
	private String telephone;
	private String dateHeureDebut;
	private Integer restaurantId;
	
	public ReservationDto() {
		
	}

	public ReservationDto(Reservation r) {
		this.id = r.getId();
		this.nom = r.getNom();
		this.prenom = r.getPrenom();
		this.telephone = r.getTelephone();
		this.dateHeureDebut = r.getDateHeureDebut();
		this.restaurantId = r.getRestaurant().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDateHeureDebut() {
		return dateHeureDebut;
	}

	public void setDateHeureDebut(String dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void remplisReservation(Reservation r) {
		r.setId(id);
		r.setPrenom(prenom);
		r.setNom(nom);
		r.setDateHeureDebut(dateHeureDebut);
		r.setTelephone(telephone);
	}
}

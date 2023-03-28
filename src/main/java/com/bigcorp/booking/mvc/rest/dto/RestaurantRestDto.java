package com.bigcorp.booking.mvc.rest.dto;

import com.bigcorp.booking.model.Restaurant;

import com.bigcorp.booking.model.PrixRestaurant;

public class RestaurantRestDto {

	private Integer id;
	private String nom;
	private String adresse;
	private PrixRestaurant prix;

	public RestaurantRestDto() {

	}

	public RestaurantRestDto(Restaurant restaurant) {
		this.id = restaurant.getId();
		this.nom = restaurant.getNom();
		this.adresse = restaurant.getAdresse();

		this.prix = restaurant.getPrix();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public PrixRestaurant getPrix() {
		return prix;
	}

	public void setPrix(PrixRestaurant prix) {
		this.prix = prix;
	}

	public void remplisRestaurant(Restaurant restaurant) {
		restaurant.setId(this.id);
		restaurant.setNom(this.nom);
		restaurant.setAdresse(this.adresse);
		restaurant.setPrix(this.prix);
	}
}

package com.bigcorp.booking.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bigcorp.booking.models.Prix;
import com.bigcorp.booking.models.Restaurant;
import com.bigcorp.booking.models.TypeRestaurant;

public class RestaurantDto {

	private Integer id;
	private String nom;
	private Prix prix;
	private String adresse;
	
//	private TypeRestaurant typeRestaurant;
	
	
	
	public Restaurant rempliRestaurant(Restaurant restaurant)
	{
		restaurant.setId(this.id);
		restaurant.setNom(this.nom);
		restaurant.setPrix(this.prix);
		restaurant.setAdresse(this.adresse);
		return restaurant;
	}
	
	
	
	
	// CONSTRUCTEURS
	
	public RestaurantDto() {
	super();
}
	
	
	public RestaurantDto(Restaurant restaurant) {
		this.id = restaurant.getId();
		this.nom = restaurant.getNom();
		this.adresse = restaurant.getAdresse();
		this.prix = restaurant.getPrix();
		
}
	
	
	// GETTER SETTER

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

	public Prix getPrix() {
		return prix;
	}

	public void setPrix(Prix prix) {
		this.prix = prix;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	
}

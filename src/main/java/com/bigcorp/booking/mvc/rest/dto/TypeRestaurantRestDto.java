package com.bigcorp.booking.mvc.rest.dto;

import com.bigcorp.booking.model.TypeRestaurant;



public class TypeRestaurantRestDto {

	private Integer id;
	private String nom;
	

	public TypeRestaurantRestDto() {

	}

	public TypeRestaurantRestDto(TypeRestaurant typeRestaurant) {
		this.id = typeRestaurant.getId();
		this.nom = typeRestaurant.getNom();
		

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

	

	public void remplisTypeRestaurant(TypeRestaurant typeRestaurant) {
		typeRestaurant.setId(this.id);
		typeRestaurant.setNom(this.nom);
	}
}

package com.bigcorp.booking.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

import com.bigcorp.booking.models.TypeRestaurant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TypeRestaurantDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty
	private String nom;
	
	// Constructeurs

	public TypeRestaurantDto() {
		super();
	}
	
	
	public TypeRestaurantDto(TypeRestaurant typeRestaurant) {
		this.id = typeRestaurant.getId();
		this.nom = typeRestaurant.getNom();
	}
	
	
	public TypeRestaurantDto(Integer id, @NotEmpty String nom) {
		super();
		this.id = id;
		this.nom = nom;
	
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
	
	// Conversion objet TypeRestaurant
	public TypeRestaurant rempliTypeRestaurant(TypeRestaurant typeRestaurant)
	{
		typeRestaurant.setId(this.id);
		typeRestaurant.setNom(this.nom);
		return typeRestaurant;
	}
	
	

}

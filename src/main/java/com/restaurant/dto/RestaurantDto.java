package com.restaurant.dto;

import com.restaurant.model.Prix;
import com.restaurant.model.Restaurant;

import jakarta.validation.constraints.NotNull;

public class RestaurantDto {
	private Integer id;
	@NotNull (message="Le nom est une donnée obligatoire")
	private String nom;
	private String prix; 
	private String adresse;
	private Integer typeId;
	
	public RestaurantDto() {
		
	}

	public RestaurantDto(Restaurant r) {
		this.id = r.getId();
		this.nom = r.getNom();
		this.prix = r.getPrix().name();
		this.adresse = r.getAdresse();
		if (r.getType() != null)
			this.typeId = r.getType().getId();
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

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	public void remplisRestaurant(Restaurant r) {
		r.setId(id);
		r.setNom(nom);
		r.setPrix(Prix.getPrixFromString(prix));
		r.setAdresse(adresse);
	}
}

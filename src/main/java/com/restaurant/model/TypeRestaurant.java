package com.restaurant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import jakarta.validation.constraints.NotNull;


@Entity
public class TypeRestaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String nom;
	@OneToMany (mappedBy="type")
	private List<Restaurant> restaurants;
	
	
	//getters et setters
	
	public Integer getId() {	
		return id;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
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
	
	
	

}

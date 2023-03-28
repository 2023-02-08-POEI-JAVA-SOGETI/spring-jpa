package com.bigcorp.booking.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type_restaurant")
public class TypeRestaurant {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nom;
	@OneToMany(mappedBy = "typeRestaurant")
	private Set<Restaurant> restaurants = new HashSet<>();
	
	
	
	// CONSTRUCTEURS
	
	public TypeRestaurant() {
		super();
	}
	public TypeRestaurant(String nom, Set<Restaurant> restaurants) {
		super();
		this.nom = nom;
		this.restaurants = restaurants;
	
	
	
	// GETTER / SETTER
	
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
	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	
	
	
	

}

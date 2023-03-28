package com.bigcorp.booking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String adresse;
	
	@Enumerated(EnumType.STRING)
	private PrixRestaurant prix;
	
	@OneToMany(mappedBy = "restaurant")
	private Set<Reservation> reservations = new HashSet<>();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_restaurant_id")
	private TypeRestaurant typeRestaurant;

	
	public Restaurant() {
	}


	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public PrixRestaurant getPrix() {
		return this.prix;
	}
	public void setPrix(PrixRestaurant prix) {
		this.prix = prix;
	}


	public Set<Reservation> getReservations() {
		return this.reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}


	public TypeRestaurant getTypeRestaurant() {
		return this.typeRestaurant;
	}
	public void setTypeRestaurant(TypeRestaurant typeRestaurant) {
		this.typeRestaurant = typeRestaurant;
	}
	
}

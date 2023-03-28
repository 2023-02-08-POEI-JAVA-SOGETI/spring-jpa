package com.restaurant.model;

import java.util.List;

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

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "restaurant")
public class Restaurant{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nom;
	@Enumerated(EnumType.STRING)
	private Prix prix; 
	private String adresse;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private TypeRestaurant type;
	
	@OneToMany(mappedBy = "restaurant")
	private List<Reservation> reservations;


	// getters et setter
	
	public Restaurant() {
		
	}
	
	public Restaurant(@NotNull String nom, Prix prix, String adresse) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.adresse = adresse;
	}

	public Restaurant(@NotNull String nom, Prix prix, String adresse, TypeRestaurant type) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.adresse = adresse;
		this.type= type;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public TypeRestaurant getType() {
		return type;
	}
	public void setType(TypeRestaurant type) {
		this.type = type;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Prix getPrix() {
		return prix;
	}
	public void setPrix(Prix prix) {
		this.prix = prix;
	}
	
	// constructeur 


	
	
	
	
	
}
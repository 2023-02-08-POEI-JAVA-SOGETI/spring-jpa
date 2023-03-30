package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * POJO d'un Héros Disney
 */

@Entity 
public class HerosFilms {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	private String film;

	public HerosFilms(Integer id, String nom, String film) {
		this.id = id;
		this.nom = nom;
		this.film = film;
	}

	public HerosFilms() {}

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

	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}

	
}

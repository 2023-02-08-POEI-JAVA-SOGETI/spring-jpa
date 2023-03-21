package com.bigcorp.booking.model;

/**
 * POJO d'un Héros Disney
 */
public class HerosDisney {

	private Integer id;
	
	private String nom;
	
	private String film;

	public HerosDisney(Integer id, String nom, String film) {
		this.id = id;
		this.nom = nom;
		this.film = film;
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

	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}

	
}

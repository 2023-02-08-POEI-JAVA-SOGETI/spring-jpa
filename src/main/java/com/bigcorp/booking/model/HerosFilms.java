package com.bigcorp.booking.model;

/**
 * POJO d'un Héros Disney
 */
public class HerosFilms {

	private Integer id;
	
	private String nom;
	
	private String film;

	public HerosFilms(Integer id, String nom, String film) {
		this.id = id;
		this.nom = nom;
		this.film = film;
	}

	public HerosFilms() {/*TODO Auto-generated constructor stub*/}

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

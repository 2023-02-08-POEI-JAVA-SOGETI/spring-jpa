package com.bigcorp.booking.model;

import jakarta.validation.constraints.Min;

/**
 * POJO d'une planète
 */
public class Planete {

	private Integer id;
	
	private String nom;
	
	@Min(34)
	private Integer masse;

	public Planete() {

	}

	public Planete(Integer id, String nom, Integer masse) {
		this.id = id;
		this.nom = nom;
		this.masse = masse;
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

	public Integer getMasse() {
		return masse;
	}

	public void setMasse(Integer masse) {
		this.masse = masse;
	}

}

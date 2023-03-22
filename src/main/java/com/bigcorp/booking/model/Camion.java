package com.bigcorp.booking.model;

public class Camion {
	private Integer id;
	private String nom;
	
	public Camion(String nom) {
		this.id = 0;
		this.nom = nom;
	}
	
	public Camion(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}

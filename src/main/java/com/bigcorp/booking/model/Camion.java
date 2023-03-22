package com.bigcorp.booking.model;

public class Camion {
	
	private int id;
	private String nom;

	public Camion(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Camion() {
		super();
	}
	
	public int getId() {
		return id;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
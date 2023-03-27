package com.bigcorp.booking.mvc.bean;

public class Invite {

	private Integer id;

	private String nom;

	public Invite(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

}

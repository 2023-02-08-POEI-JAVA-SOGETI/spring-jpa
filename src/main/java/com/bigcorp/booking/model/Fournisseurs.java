package com.bigcorp.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fournisseurs")
public class Fournisseurs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iD;
	@Column(name = "numeroUnique")
	private Integer numeroUnique;
	private String nom;
	private String email;
	private String adresse;

	// Getters
	public Integer getiD() {
		return this.iD;
	}

	public Integer getNumeroUnique() {
		return this.numeroUnique;
	}

	public String getNom() {
		return this.nom;
	}

	public String getMail() {
		return this.email;
	}

	public String getAdresse() {
		return this.adresse;
	}

	// Setters

	public void setiD(Integer iD) {
		this.iD = iD;
	}

	public void setNumeroUnique(Integer numeroUnique) {
		this.numeroUnique = numeroUnique;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setMail(String email) {
		this.email = email;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}

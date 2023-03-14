package com.bigcorp.booking.model;

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
	private Integer numeroUnique;
	private String nom;
	private String mail;
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
		return this.mail;
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

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}

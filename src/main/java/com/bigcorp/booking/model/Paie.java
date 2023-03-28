package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Décrit une entité persistable
public class Paie  {

	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private String statut;

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getStatut() {
		return statut;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	

}

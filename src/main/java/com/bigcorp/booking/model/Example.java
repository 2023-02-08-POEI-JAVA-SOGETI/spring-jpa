package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Décrit une entité persistable
@Table(name = "EXAMPLE") // Optionnel : explicite la Table en BDD
public class Example  {

	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.TABLE) // optionnel
	// décrit la méthode de génération de l’identifiant
	private Long id;
<<<<<<< HEAD
	private String nom;
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
=======
	
	private String nom;
	
	private Float taille;
>>>>>>> 46727f927865fcedfbdff18528ff56986a6cbd34

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getTaille() {
		return taille;
	}

	public void setTaille(Float taille) {
		this.taille = taille;
	}
	
	
	

}

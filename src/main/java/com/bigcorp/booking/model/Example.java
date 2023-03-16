package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // Décrit une entité persistable
@Table(name = "Example") // Optionnel : explicite la Table en BDD
public class Example  {

	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// optionnel
	// décrit la méthode de génération de l’identifiant
	private Long id;
	
	private String nom;
	
	private Float taille;
	
	@Enumerated(EnumType.STRING)
	private Severite severite;
	
	@ManyToOne
	@JoinColumn(name="LECON_ID")
	private Lecon lecon;
	
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

	public Severite getSeverite() {
		return severite;
	}

	public void setSeverite(Severite severite) {
		this.severite = severite;
	}

	public Lecon getLecon() {
		return lecon;
	}

	public void setLecon(Lecon lecon) {
		this.lecon = lecon;
	}

	public void associateWith(Lecon lecon) {
		this.lecon = lecon;
		lecon.getExamples().add(this);
	}

}

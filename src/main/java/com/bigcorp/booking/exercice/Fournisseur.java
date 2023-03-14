package com.bigcorp.booking.exercice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fournisseur")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	
	private String nom;
	private Integer num;
	private String email;
	private String adresse;
	
	
	
	public Fournisseur() {
		super();
	}
	
	
	
	public Fournisseur(String nom, Integer num, String email, String adresse) {
		super();
		this.nom = nom;
		this.num = num;
		this.email = email;
		this.adresse = adresse;
	}




	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + ", num=" + num + ", email=" + email + ", adresse=" + adresse
				+ "]";
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	

}

package com.bigcorp.booking.exercice.model.many_to_one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;



// LES VALIDATIONS SONT A FAIRE SUR LE DTO et non l'entité



@Entity
@Table(name="fournisseur")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String nom;
	
	@Min(0)
	private Integer num;
	
	@Email
	private String email;
	
	@NotEmpty
	private String adresse;
	
	@OneToMany(mappedBy = "fournisseur")
	private Set<Article> articles = new HashSet<>();
	


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
	

	public Set<Article> getArticles() {
		return articles;
	}
	
	


}

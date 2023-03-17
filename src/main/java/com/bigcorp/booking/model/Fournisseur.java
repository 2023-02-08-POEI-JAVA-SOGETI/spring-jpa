package com.bigcorp.booking.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Array;



@Entity
@Table(name = "FOURNISSEURS")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero_fournisseur;
	private String nom;
	private String email;
	private String adresse;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Article> articles = new ArrayList<>();
	
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero_fournisseur() {
		return numero_fournisseur;
	}
	public void setNumero_fournisseur(Integer numero_fournisseur) {
		this.numero_fournisseur = numero_fournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	
	
	public static void main(String[] args){
		
	}
}


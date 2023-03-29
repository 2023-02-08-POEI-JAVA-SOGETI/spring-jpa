package com.bigcorp.booking.model;

import java.util.HashSet;
import java.util.Set;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bigcorp.booking.dto.FournisseurDto;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;





@Entity
@Table(name = "FOURNISSEURS")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Min(0)
	private Integer numero_fournisseur;
	@Size(min=1, max=50)
	private String nom;
	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$", message="Must be an email address")
	private String email;
	@Size(min=1, max=255)
	private Integer numero;
	private String adresse;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Article> articles = new ArrayList<>();
	
	
	public Fournisseur(FournisseurDto fournisseurDto) {

	}
	
	public Fournisseur() {
		
	}
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
	

	/*public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}*/

}


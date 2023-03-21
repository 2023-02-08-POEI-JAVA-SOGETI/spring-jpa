package com.bigcorp.booking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOURNISSEUR")
public class Fournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private String nom;
	private String email;
	private String adresse;
	@OneToMany(mappedBy = "fournisseur")
	private Set<Article> articles;
	@OneToMany(mappedBy = "fournisseur")
	private Set<Client> clients;


	public Fournisseur() {
		this.numero = 0;
		this.nom = "NOM";
		this.email = "EMAIL";
		this.adresse = "ADRESSE";
		this.articles = new HashSet<Article>();
		this.clients = new HashSet<Client>();
	}

	public Fournisseur(Integer numero, String nom, String email, String adresse) {
		this.numero = numero;
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
		this.articles = new HashSet<Article>();
		this.clients = new HashSet<Client>();
	}
	
	public Fournisseur(Integer numero, String nom, String email, String adresse, HashSet<Client> clients) {
		this.numero = numero;
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
		this.articles = new HashSet<Article>();
		this.clients = clients;
	}

	public Fournisseur(Integer id, Integer numero, String nom, String email, String adresse) {
		this.id = id;
		this.numero = numero;
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
		this.articles = new HashSet<Article>();
		this.clients = new HashSet<Client>();
	}

	public Integer getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getNom() {
		return nom;
	}

	public String getEmail() {
		return email;
	}

	public String getAdresse() {
		return adresse;
	}

	public Set<Article> getArticles() {
		return articles;
	}
	
	public Set<Client> getClients() {
		return clients;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public void associateWithArticle(Article article) {
		this.articles.add(article);
		article.setFournisseur(this);
	}
	
	public void associateWithClient(Client client) {
		this.clients.add(client);
		client.setFournisseur(this);
	}
}
package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="utilisateurs")
public class Utilisateurs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String mdp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTS_ID")
	private Clients client;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Clients getClients() {
		return client;
	}

	public void setClients(Clients client) {
		this.client = client;
	}
	
	/**
	 * Associe this à client.
	 * Modifie client.utilisateur pour rendre les deux
	 * relations cohérentes
	 * @param client not null
	 */
	public void associe(Clients clients) {
		this.client = clients;
		this.client.getUtilisateurs().add(this);
	}

}

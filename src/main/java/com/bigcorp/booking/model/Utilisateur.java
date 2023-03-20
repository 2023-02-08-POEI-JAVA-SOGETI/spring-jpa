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
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iD;
	private Integer numeroEmploye;
	private String nom;
	private String prenom;
	private String mail;
	private String login;
	private String password;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

	public Integer getId() {
		return iD;
	}

	public void setId(Integer iD) {
		this.iD = iD;
	}

	public Integer getNumero() {
		return numeroEmploye;
	}

	public void setNumero(Integer numeroEmploye) {
		this.numeroEmploye = numeroEmploye;
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
		return mail;
	}

	public void setEmail(String mail) {
		this.mail = mail;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return password;
	}

	public void setMdp(String password) {
		this.password = password;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * Associe this à client.
	 * Modifie client.utilisateur pour rendre les deux
	 * relations cohérentes
	 * @param client not null
	 */
	public void associe(Client client) {
		this.client = client;
		this.client.getUtilisateurs().add(this);
	}

}

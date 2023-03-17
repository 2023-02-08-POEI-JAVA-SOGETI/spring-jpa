package com.bigcorp.booking.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = -1912226135224432621L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String mdp;
	@OneToMany(mappedBy = "utilisateur")
	private Set<Client> clients;

	public Utilisateur() {
		this.numero = 0;
		this.nom = "NOM";
		this.prenom = "PRENOM";
		this.email = "EMAIL";
		this.login = "LOGIN";
		this.mdp = "MDP";
		this.clients = new HashSet<Client>();
	}

	public Utilisateur(Integer numero, String nom, String prenom, String email, String login, String mdp) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.mdp = mdp;
		this.clients = new HashSet<Client>();
	}

	public Utilisateur(Integer id, Integer numero, String nom, String prenom, String email, String login, String mdp) {
		this.id = id;
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.mdp = mdp;
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

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getMdp() {
		return mdp;
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

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	public void associateWith(Client client) {
		this.clients.add(client);
		client.setUtilisateur(this);
	}
}

package com.bigcorp.booking.dto;

import com.bigcorp.booking.model.Client;


public class ClientRestDto {
	private int id;
	private String nom;
	private String prenom;
	private int numero;
	private String adresse;
	private int utilisateurId;
	
	public ClientRestDto() {
		
	}
	
	public ClientRestDto(Client client) {
		this.id = client.getId();
		this.nom = client.getNom();
		this.prenom = client.getPrenom();
		this.numero = client.getNumero();
		this.adresse = client.getAdresse();
		
		if(client.getUtilisateur() != null) {
			this.utilisateurId = client.getUtilisateur().getId();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public Client build(Client client) {
		client.setId(id);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setNumero(numero);
		
		return client;
	}

	@Override
	public String toString() {
		return "ClientRestDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", adresse="
				+ adresse + "]";
	}
	
}

package com.bigcorp.booking.dto;



import com.bigcorp.booking.model.Client;

public class ClientDto {
	
	private Integer id;
	private Integer numero;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	
	public ClientDto() {
		
	}
	
	public ClientDto(Client client) {
		this.id = client.getId();
		this.numero = client.getNumero();
		this.nom = client.getNom();
		this.prenom = client.getPrenom();
		this.adresse = client.getAdresse();
		this.email = client.getEmail();	
	}

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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}

package com.bigcorp.booking.mvc.rest.dto;

import tp_spring_jpa_pablo.model.Client;

public class ClientRestDto {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	
	public ClientRestDto(Client client) {
		this.id = client.getId();		
		this.nom = client.getNom();
		this.prenom = client.getPrenom();
		this.email = client.getEmail();
		this.adresse = client.getAdresse();
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

	public Client remplisClient(Client clientLu) {
		clientLu.setId(this.id);		
		clientLu.setNom(this.nom);
		clientLu.setPrenom(this.prenom);
		clientLu.setEmail(this.email);
		clientLu.setAdresse(this.adresse);
		return clientLu;
	}
	
	public ClientRestDto() {		
	}

}

package com.bigcorp.booking.dto;


import com.bigcorp.booking.model.Utilisateur;


public class UtilisateurDto {
	
	private Integer id;
	private Integer numero_employe;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String mot_de_passe;
	
	public UtilisateurDto() {
		
	}

	public UtilisateurDto (Utilisateur utilisateur) {
		this.id = utilisateur.getId();
		this.numero_employe = utilisateur.getNumero_employe();
		this.nom = utilisateur.getNom();
		this.prenom = utilisateur.getPrenom();
		this.login = utilisateur.getLogin();
		this.mot_de_passe = utilisateur.getMot_de_passe();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero_employee() {
		return numero_employe;
	}
	public void setNumero_employee(Integer numero_employee) {
		this.numero_employe = numero_employee;
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
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	
	
}

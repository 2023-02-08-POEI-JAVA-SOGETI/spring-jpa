package com.bigcorp.booking.mvc.rest.dto;

import tp_spring_jpa_pablo.model.Utilisateur;

public class UtilisateurRestDto {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	
	public UtilisateurRestDto(Utilisateur utilisateur) {
		this.id = utilisateur.getId();		
		this.nom = utilisateur.getNom();
		this.prenom = utilisateur.getPrenom();
		this.email = utilisateur.getEmail();
		this.password = utilisateur.getPassword();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Utilisateur remplisUtilisateur(Utilisateur utilisateurLu) {
		utilisateurLu.setId(this.id);		
		utilisateurLu.setNom(this.nom);
		utilisateurLu.setPrenom(this.prenom);
		utilisateurLu.setEmail(this.email);
		utilisateurLu.setPassword(this.password);
		return utilisateurLu;
	}
	
	public UtilisateurRestDto() {
	}


}

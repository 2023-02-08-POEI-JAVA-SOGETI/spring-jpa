package com.bigcorp.booking.dto;

import com.bigcorp.booking.model.Utilisateur;

public class UtilisateurRestDto {
	private int id;
	private String nom;
	private String prenom;
	
	public UtilisateurRestDto() {

	}
	
	public UtilisateurRestDto(Utilisateur utilisateur) {
		this.setId(utilisateur.getId());
		this.nom = utilisateur.getNom();
		this.prenom = utilisateur.getPrenom();
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
	
	public Utilisateur build(Utilisateur utilisateur) {
		utilisateur.setId(id);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		
		return utilisateur;
	}

}

package com.bigcorp.booking.dto;

import java.util.List;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurRestDto {
	private Integer id;
	private Integer numero;
	private String nom;
	private String email;
	private String adresse;
	private List<ArticleRestDto> articlesDto;
	
	public FournisseurRestDto() {
		
	}
	
	public FournisseurRestDto(Fournisseur f) {
		this.id = f.getId();
		this.numero = f.getNumero();
		this.nom = f.getNom();
		this.email = f.getEmail();
		this.adresse = f.getAdresse();
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

	public List<ArticleRestDto> getArticlesDto() {
		return articlesDto;
	}

	public void setArticlesDto(List<ArticleRestDto> articlesDto) {
		this.articlesDto = articlesDto;
	}

	public void remplisFournisseur(Fournisseur f) {
		f.setId(id);
		f.setNumero(numero);
		f.setNom(nom);
		f.setEmail(email);
		f.setAdresse(adresse);
	}
}

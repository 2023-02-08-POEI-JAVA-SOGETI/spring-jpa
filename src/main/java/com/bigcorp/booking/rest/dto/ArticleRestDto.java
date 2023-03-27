package com.bigcorp.booking.rest.dto;


import com.bigcorp.booking.model.Article;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class ArticleRestDto {

	 private Integer id;
	 private Integer numero;
	 
	 @NotBlank (message = "Nom obligatoire.")
	 private String nom;
	 @NotBlank (message = "Etat obligatoire.")
	 private String etat;
	 private String description;
	 private Integer fournisseurId;
	 
	 public ArticleRestDto() {
		 
	 }
	 
	 public ArticleRestDto(Article a) {
		 this.id = a.getId();
		 this.numero = a.getNumero();
		 this.nom = a.getNom();
		 this.etat = a.getEtat();
		 this.description = a.getDescription();
		 if (a.getFournisseur() != null)
			 this.fournisseurId = a.getFournisseur().getId();
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

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFournisseurId() {
		return fournisseurId;
	}

	public void setFournisseurId(Integer fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	public void updateArticleWith(Article article) {
		article.setId(id);
		article.setNumero(numero);
		article.setNom(nom);
		article.setEtat(etat);
		article.setDescription(description);
	}
	
}

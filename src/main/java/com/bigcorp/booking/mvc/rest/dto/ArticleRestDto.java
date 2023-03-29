package com.bigcorp.booking.mvc.rest.dto;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;

//La class ArticlerestDto
public class ArticleRestDto {

	// definition des propriétés de la class
	private Integer id;
	private String nom;
	private Integer numero;
	private String fc;
	private String description;
	private EtatArticle etatArticle;
	private Integer fournisseurId;

	public ArticleRestDto() {
		super();
	}

	// Methode constructeur permettant d'initialiser les propriétés de la class
	// a partir du modele Article.
	public ArticleRestDto(Article article) {
		this.id = article.getId();
		this.nom = article.getNom();
		this.numero = article.getNumero();
		this.fc = article.getFC();
		this.description = article.getDescription();
		this.etatArticle = article.getEtatArticle();
		if (article.getFournisseur() != null) {
			this.fournisseurId = article.getFournisseur().getId();
		}
	}

	// Les getters et setters

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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getFC() {
		return fc;
	}

	public void setFC(String fc) {
		this.fc = fc;
	}

	public EtatArticle getEtatArticle() {
		return etatArticle;
	}

	public void setEtatArticle(EtatArticle etatArticle) {
		this.etatArticle = etatArticle;
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

	// Methode permettant de remplir les propriétés de la table à persister
	// A partir des proprietes chargées du DTO
	public Article remplisArticle(Article articleLu) {
		articleLu.setId(this.id);
		articleLu.setNom(this.nom);
		articleLu.setNumero(this.numero);
		articleLu.setFC(this.fc);
		articleLu.setDescription(this.description);
		articleLu.setEtatArticle(this.etatArticle);

		return articleLu;
	}
	
	@Override
	public String toString() {
		return "ArticleRestDto [id=" + id + ", nom=" + nom + "]";
	}

}
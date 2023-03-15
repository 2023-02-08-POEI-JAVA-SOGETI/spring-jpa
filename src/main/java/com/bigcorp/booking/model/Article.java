package com.bigcorp.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // Décrit une entité persistable
@Table(name = "Articles")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iD;
    private Integer numeroUnique;
    private String fournOuClient;
    private String nom;
    private String description;
    @ManyToOne
    @JoinColumn(name = "FOURNISSEUR_ID")
    private Fournisseurs fournisseur;
    public Fournisseurs getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseurs fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Enumerated(EnumType.STRING)
    private EtatArticle etat;
    
    
	// Getters
    public Integer getiD() {
        return this.iD;
    }

    public Integer getNumeroUnique() {
        return this.numeroUnique;
    }

    public String getFournOuClient() {
        return this.fournOuClient;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }
    @Column(name = "etat")
    public EtatArticle getEtat() {
		return this.etat;
	}

    // Setters
    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public void setNumeroUnique(Integer numeroUnique) {
        this.numeroUnique = numeroUnique;
    }

    public void setFournOuClient(String fournOuClient) {
        this.fournOuClient = fournOuClient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setEtat(EtatArticle etat) {
		this.etat = etat;
	}

	

}

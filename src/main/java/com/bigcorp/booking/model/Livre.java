package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Livres")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	private String auteur;
	private String description;
	private Integer anneeedition;

	
	@Enumerated(EnumType.STRING)
	private EtatLivre etatLivre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOURNISSEUR_ID")
	private Fournisseur fournisseur;

	
	/*Getter Setter Id*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	/*Getter Setter Annee Edition*/
	public Integer getAnneeEdition() {
		return anneeedition;
	}
	public void setAnneeEdition(Integer anneeedition) {
		this.anneeedition = anneeedition;
	}


	/*Getter Setter Titre*/
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	
	/*Getter Setter Auteur*/
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	/*Getter Setter Description*/
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	/*Getter Setter Etat Livre*/
	public EtatLivre getEtatLivre() {
		return etatLivre;
	}
	public void setEtatLivre(EtatLivre etatLivre) {
		this.etatLivre = etatLivre;
	}

	/*Getter Setter Fournisseur*/
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	/**
	 * Associe this à fournisseur.
	 * Modifie fournisseur.livres pour rendre les deux
	 * relations cohérentes
	 * @param fournisseur not null
	 */
	
	public void associe(Fournisseur fournisseur) {
		if (fournisseur != null) {
			this.fournisseur = fournisseur;
			this.fournisseur.getLivres().add(this);
		}
	}

}
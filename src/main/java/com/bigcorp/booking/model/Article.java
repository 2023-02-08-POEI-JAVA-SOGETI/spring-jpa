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

@Entity // Décrit une entité persistable
@Table(name = "Article") // Optionnel : explicite la Table en BDD
public class Article {

	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Proprietes
	private Integer id;
	private Integer numero;
	private String fc;
	private String nom;
	private String description;

	@Enumerated(EnumType.STRING)
	private EtatArticle etatArticle;

	// @ManyToOne
	// @JoinColumn(name = "FOURNISSEUR_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOURNISSEUR_NUMERO")

	private Fournisseur fournisseur;

	/**
	 * Constructeur sans param�tre
	 */
	/*
	 * public Article() { this.id = 0; this.numero = 0; this.fc = ""; this.nom =
	 * "NOM"; this.description = "DESCRIPTION"; }
	 * 
	 * /** Constructeur avec param�tres sauf Id
	 * 
	 * @param numero : numero d'un article
	 * 
	 * @param fc : artcile vendu � un client ou acheter � un fournisseur
	 * 
	 * @param nom : nom d'un article
	 * 
	 * @param description : description d'un article
	 */

	/*
	 * public Article(Integer numero, String fc, String nom, String description) {
	 * this.id = 0; this.numero = numero; this.fc = fc; this.nom = nom;
	 * this.description = description; }
	 */

	/**
	 * Constructeur avec tous les param�tres
	 * 
	 * @param id          : num�ro de l'enregistrement dans la table
	 * @param numero      : numero d'un article
	 * @param fc          : artcile vendu � un client ou acheter � un fournisseur
	 * @param nom         : nom d'un article
	 * @param description : description d'un article
	 */

	/*
	 * public Article(Integer id, Integer numero, String fc, String nom, String
	 * description) { this.id = id; this.numero = numero; this.fc = fc; this.nom =
	 * nom; this.description = description; }
	 */
	// Getters

	/**
	 * Getter Id
	 * 
	 * @return Id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * getter Numero
	 * 
	 * @return Numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * getter fc
	 * 
	 * @return fc
	 */
	public String getFC() {
		return fc;
	}

	/**
	 * getter Nom
	 * 
	 * @return Nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	// Setters

	/**
	 * Setter id
	 * 
	 * @param id : num�ro de l'enregistrement dans la table
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Setter numero
	 * 
	 * @param numero : numero de l'article
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * Setter fc
	 * 
	 * @param fc : artcile vendu � un client ou acheter � un fournisseur
	 */
	public void setFC(String fc) {
		this.fc = fc;
	}

	/**
	 * Setter nom
	 * 
	 * @param nom : nom de l'article
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Setter description
	 * 
	 * @param description : description de l'article
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public EtatArticle getEtatArticle() {
		return etatArticle;
	}

	public void setEtatArticle(EtatArticle etatArticle) {
		this.etatArticle = etatArticle;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	
	public static void main(String[] args) {
		Article article = new Article();

	}
	
	public void associateWith(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
		fournisseur.getArticles().add(this);
	}
	
	

}
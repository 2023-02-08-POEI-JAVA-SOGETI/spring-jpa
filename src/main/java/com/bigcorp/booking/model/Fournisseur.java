package com.bigcorp.booking.model;

//Import de Serializable pour creer un JavaBean
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* JavaBean d'un Fournisseur
* @author Twixy
*/
@Entity
@Table(name = "fournisseurs")
public class Fournisseur implements Serializable {
	 // Proprietes
	 private static final long serialVersionUID = -1912226135224432621L;
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
	 private Integer id;
	 private Integer numero;
	 private String nom;
	 private String email;
	 private String adresse;
	 
	 @OneToMany (mappedBy = "fournisseur")
	 private List<Article> articles;
	 
	 /**
	  * Constructeur sans paramètre
	  */
	 public Fournisseur() {
	     this.id = 0;
	     this.numero = 0;
	     this.nom = "NOM";
	     this.email = "EMAIL";
	     this.adresse = "ADRESSE";
	     this.articles = new ArrayList<>();
	 }
	
	 /**
	  * Constructeur avec paramètres sauf Id
	  * @param numero : numero du fournisseur
	  * @param nom : nom du fournisseur
	  * @param email : email du fournisseur
	  * @param adresse : adresse du fournisseur
	  */
	 public Fournisseur(Integer numero, String nom, String email, String adresse) {
	     this.id = 0;
	     this.numero = numero;
	     this.nom = nom;
	     this.email = email;
	     this.adresse = adresse;
	     this.articles = new ArrayList<>();
	 }
	 
	 /**
	  * Constructeur avec tous les paramètres
	  * @param id : numéro de l'enregistrement dans la table
	  * @param numero : numero du fournisseur
	  * @param nom : nom du fournisseur
	  * @param email : email du fournisseur
	  * @param adresse : adresse du fournisseur
	  */
	 public Fournisseur(Integer id, Integer numero, String nom, String email, String adresse) {
	     this.id = id;
	     this.numero = numero;
	     this.nom = nom;
	     this.email = email;
	     this.adresse = adresse;
	     this.articles = new ArrayList<>();
	 }
	 // Getters
	
	 /**
	  * Getter Id
	  * @return Id
	  */
	 public Integer getId() {
	     return id;
	 }
	
	 /**
	  * getter Numero
	  * @return Numero
	  */
	 public Integer getNumero() {
	     return numero;
	 }
	
	 /**
	  * getter Nom
	  * @return Nom
	  */
	 public String getNom() {
	     return nom;
	 }
	
	 /**
	  * Getter Email
	  * @return Email
	  */
	 public String getEmail() {
	     return email;
	 }
	
	 /**
	  * Getter Adresse
	  * @return Adresse
	  */
	 public String getAdresse() {
	     return adresse;
	 }
	
	 // Setters
	
	 /**
	  * Setter id
	  * @param id : numéro de l'enregistrement dans la table
	  */
	 public void setId(Integer id) {
	     this.id = id;
	 }
	 
	 /**
	  * Setter numero
	  * @param numero : numero du fournisseur
	  */
	 public void setNumero(Integer numero) {
	     this.numero = numero;
	 }
	 
	 /**
	  * Setter nom
	  * @param nom : nom du fournisseur
	  */
	 public void setNom(String nom) {
	     this.nom = nom;
	 }
	
	 /**
	  * Setter email
	  * @param email : email du fournisseur
	  */
	 public void setEmail(String email) {
	     this.email = email;
	 }
	
	 /**
	  * Setter adresse
	  * @param adresse : adresse du fournisseur
	  */
	 public void setAdresse(String adresse) {
	     this.adresse = adresse;
	 }
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public void updateFournisseur(Fournisseur f) {
	     this.id = f.getId();
	     this.numero = f.getNumero();
	     this.nom = f.getNom();
	     this.email = f.getEmail();
	     this.adresse = f.getAdresse();
	     this.articles = f.getArticles();
	}
}
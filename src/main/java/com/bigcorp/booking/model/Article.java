package com.bigcorp.booking.model;


//Import de Serializable pour creer un JavaBean
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* JavaBean d'un Article
* @author Twixy
*/
@Entity
@Table (name = "articles") 
public class Article implements Serializable {
 // Proprietes
 private static final long serialVersionUID = -1912226135224432621L;
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
 private Integer id;
 private Integer numero;
 private String nom;
 private String etat;
 private String description;
 @ManyToOne
 @JoinColumn (name = "fournisseur_id")
 private Fournisseur fournisseur;


 
 /**
  * Constructeur sans paramètre
  */
 public Article() {
     this.id = 0;
     this.numero = 0;
     this.etat = Etat.NEUF.name();
     this.nom = "NOM";
     this.description = "DESCRIPTION";
 }

 /**
  * Constructeur avec paramètres sauf Id
  * @param numero : numero d'un article
  * @param fc : artcile vendu à un client ou acheter à un fournisseur
  * @param nom : nom d'un article
  * @param description : description d'un article
  */
 public Article(Integer numero, String e, String nom, String description) {
     this.id = 0;
     this.numero = numero;
     this.etat = e;
     this.nom = nom;
     this.description = description;
 }
 
 /**
  * Constructeur avec tous les paramètres
  * @param id : numéro de l'enregistrement dans la table
  * @param numero : numero d'un article
  * @param fc : artcile vendu à un client ou acheter à un fournisseur
  * @param nom : nom d'un article
  * @param description : description d'un article
  */
 public Article(Integer id, Integer numero, String e, String nom, String description) {
     this.id = id;
     this.numero = numero;
     this.etat = e;
     this.nom = nom;
     this.description = description;
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
  * getter fc
  * @return fc
  */
 public String getEtat() {
     return etat;
 }
 
 /**
  * getter Nom
  * @return Nom
  */
 public String getNom() {
     return nom;
 }


 /**
  * Getter description
  * @return description
  */
 public String getDescription() {
     return description;
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
  * @param numero : numero de l'article
  */
 public void setNumero(Integer numero) {
     this.numero = numero;
 }

 /**
  * Setter fc
  * @param fc : artcile vendu à un client ou acheter à un fournisseur
  */
 public void setEtat(String etat) {
     this.etat = etat;
 }
 
 /**
  * Setter nom
  * @param nom : nom de l'article
  */
 public void setNom(String nom) {
     this.nom = nom;
 }

 /**
  * Setter description
  * @param description : description de l'article
  */
 public void setDescription(String description) {
     this.description = description;
 }

public Fournisseur getFournisseur() {
	return fournisseur;
}

public void setFournisseur(Fournisseur fournisseur) {
	this.fournisseur = fournisseur;
}
}
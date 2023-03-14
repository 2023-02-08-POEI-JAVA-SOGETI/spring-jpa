package com.bigcorp.booking.model;

//Import de Serializable pour creer un JavaBean
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 
 /**
  * Constructeur sans paramètre
  */
 public Fournisseur() {
     this.id = 0;
     this.numero = 0;
     this.nom = "NOM";
     this.email = "EMAIL";
     this.adresse = "ADRESSE";
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
}
package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Import de Serializable pour creer un JavaBean


/**
 * JavaBean d'un Client
 * @author Twixy
 */

@Entity // Décrit une entité persistable
@Table(name = "CLIENT") // Optionnel : explicite la Table en BDD
public class Client {
	
	@Id
    // Proprietes
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Integer id;
    private Integer numero;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    
    /**
     * Constructeur sans param�tre
     */
    public Client() {
        this.id = 0;
        this.numero = 0;
        this.nom = "NOM";
        this.prenom = "PRENOM";
        this.email = "EMAIL";
        this.adresse = "ADRESSE";
    }

    /**
     * Constructeur avec param�tres sauf Id
     * @param numero : numero d'un client
     * @param nom : nom d'un client
     * @param prenom : prenom d'un client
     * @param email : email d'un client
     * @param adresse : adresse d'un client
     */
    public Client(Integer numero, String nom, String prenom, String email, String adresse) {
        this.id = 0;
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
    }
    
    /**
     * Constructeur avec tous les param�tres
     * @param id : num�ro de l'enregistrement dans la table
     * @param numero : numero d'un client
     * @param nom : nom d'un client
     * @param prenom : prenom d'un client
     * @param email : email d'un client
     * @param adresse : adresse d'un client
     */
    public Client(Integer id, Integer numero, String nom, String prenom, String email, String adresse) {
        this.id = id;
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
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
     * getter Prenom
     * @return Prenom
     */
    public String getPrenom() {
        return prenom;
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
     * @param id : num�ro de l'enregistrement dans la table
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Setter numero
     * @param numero : numero du client
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    /**
     * Setter nom
     * @param nom : nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Setter prenom
     * @param prenom : pr�nom du client
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Setter email
     * @param email : email du client
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter adresse
     * @param adresse : adresse du client
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
package com.bigcorp.booking.tp;

// Creation d'un JavaBean
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Décrit une entité persistable
@Table(name = "Articles") // Optionnel : explicite la Table en BDD
public class Articles implements Serializable {

    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	// Proprietes
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    private Integer iD;
    private Integer numeroUnique;
    private String nom;
    private String description;
    private String fournisseur;
 
    // Constructeur sans parametres
    public Articles() {
        this.iD = 0;
        this.numeroUnique = 0;
        this.nom = "";
        this.description = "";
        this.fournisseur = "";
    }

    public Articles(Integer numeroUnique, String nom, String mail, String adresse) {
        this.numeroUnique = numeroUnique;
        this.nom = nom;
        this.description = description;
        this.fournisseur = fournisseur;
    }

    // Getters
    public Integer getiD() {
        return this.iD;
    }

    public Integer getNumeroUnique() {
        return this.numeroUnique;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFournisseur() {
        return this.fournisseur;
    }

    // Setters

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public void setNumeroUnique(Integer numeroUnique) {
        this.numeroUnique = numeroUnique;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }
    
}

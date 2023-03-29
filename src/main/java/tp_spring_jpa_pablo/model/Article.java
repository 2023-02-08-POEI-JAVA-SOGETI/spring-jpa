package tp_spring_jpa_pablo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tp_spring_jpa_pablo.dao.EtatArticle;

import javax.persistence.Enumerated;

@Entity
public class Article {
	
	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
	// décrit la méthode de génération de l’identifiant	
	private Integer id;	
	private String nom = "Spring Data";
    private String type = "test@java_jpa.com";
    private String description = "Article Sprint Data already!!";    
    
    @Enumerated(EnumType.STRING)
    private EtatArticle etat = EtatArticle.OCCASION;  
    
    @ManyToOne
    @JoinColumn(name="fournisseur")
    private Fournisseur fournisseur;	
    
	public EtatArticle getEtat() {
		return etat;
	}
	public void setEtat(EtatArticle etat) {
		this.etat = etat;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	
	
	
}

package tp_spring_jpa_pablo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Client {
	
	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
	// décrit la méthode de génération de l’identifiant	
	private Integer id;	
	private String nom = "Test";
    private String prenom = "test@java_jpa.com";
    private String email = "Anywhere near ORM";
    private String adresse = "Rue du percebe n 13";
    
    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private Set<Utilisateur> utilisateurs = new HashSet<>();

	
    public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}

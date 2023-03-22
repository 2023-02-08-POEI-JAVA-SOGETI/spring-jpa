package tp_spring_jpa_pablo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // Décrit une entité persistable
@Table(name = "fournisseur") // Optionnel : explicite la Table en BDD
public class Fournisseur {
	
	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
	// décrit la méthode de génération de l’identifiant
	private Integer id;	
	private String nom;
    private String email;
    private String adresse;
    
    @OneToMany(mappedBy = "fournisseur")
    private Set<Article> articles = new HashSet<>();
          
    public Set<Article> getArticles() {
		return articles;
	}

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
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

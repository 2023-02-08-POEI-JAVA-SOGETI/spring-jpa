package com.bigcorp.booking.models;

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
@Table(name = "restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nom;
	@Enumerated(EnumType.STRING)
	private Prix prix;
	private String adresse;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "type_restaurant_id")
	private TypeRestaurant typeRestaurant;
	

	
	
	public void associeAvecType (TypeRestaurant typeRestaurant)
	{
		this.typeRestaurant = typeRestaurant;
		typeRestaurant.getRestaurants().add(this);
	}
	
	
	
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", nom=" + nom + ", prix=" + prix + ", adresse=" + adresse + ", typeRestaurant="
				+ typeRestaurant + "]";
	}
	
	
	public Restaurant(Builder builder) {
		this.nom = builder.nom;
		this.prix = builder.prix;
		this.adresse = builder.adresse;
		this.typeRestaurant = builder.typeRestaurant;
		
	}

	
	
	public Restaurant() {
		super();
	}



	public static class Builder {
		

		private String nom = "Nom inconnu";
		private Prix prix = Prix.INCONNU;
		private String adresse = "Adresse inconnue";
		private TypeRestaurant typeRestaurant = new TypeRestaurant();
		
		
		
		
		
		public Builder withNom(String nom)
		{
			this.nom = nom;
			return this;
		}
		
		public Builder withPrix(Prix prix)
		{
			this.prix = prix;
			return this;
		}
		
		public Builder withAdresse(String adresse)
		{
			this.adresse = adresse;
			return this;
		}
		
		public Builder withTypeRestaurant(TypeRestaurant typeRestaurant)
		{
			this.typeRestaurant = typeRestaurant;
			return this;
		}
		
		public Restaurant build()
		{
			return new Restaurant(this);
		}
		
		public Builder() {
		}
		
		
	}
	
	
	

	// GETTER SETTER
	
	
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

	public Prix getPrix() {
		return prix;
	}

	public void setPrix(Prix prix) {
		this.prix = prix;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public TypeRestaurant getTypeRestaurant() {
		return typeRestaurant;
	}

	public void setTypeRestaurant(TypeRestaurant typeRestaurant) {
		this.typeRestaurant = typeRestaurant;
	}
	
	
	

}

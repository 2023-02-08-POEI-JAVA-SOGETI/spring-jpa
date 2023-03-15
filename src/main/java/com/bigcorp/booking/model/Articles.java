package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   //@Entity": j'indique à JPA que cette classe = entité persistante
@Table(name = "Articles")    //Je lui dis aussi que la table que j'utise c'est Articles

public class Articles {  
	@Id //Je dit JPA que cette variable est la PK de l'entité
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //et je lui dit comment la PK sera générée lors d'insertion d'un nouvel element dans la table. 
	
		private long id;
		private String numero;
		private String etat;
		private String nom;
		private String description;
		
		//constructeur, getter, setter
		public Articles(long id, String numero, String etat, String nom, String description) {
			this.id = id;
			this.numero = numero;
			this.etat = etat;
			this.nom = nom;
			this.description = description;
		}
		
		public Articles() {
		}


		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

}

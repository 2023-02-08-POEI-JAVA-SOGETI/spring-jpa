package com.bigcorp.booking.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Entity
@Table(name =  "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nom_reservant")
	private String nomReservant;
	@Column(name = "prenom_reservant")
	private String prenomReservant;
	@Column(name = "telephone_reservant")
	private String telephoneReservant;
	@Column(name = "date_heure_debut")
	private LocalDateTime dateHeureDebut;
//	Restaurant restaurant;
	
	
	
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", nomReservant=" + nomReservant + ", prenomReservant=" + prenomReservant
				+ ", telephoneReservant=" + telephoneReservant + ", dateHeureDebut=" + dateHeureDebut + "]";
	}
	
	
	
	
	
	
	// CONSTRUCTEURS
	
	
	public Reservation() {
	super();
}
	
	


	public Reservation(Builder builder) {
		this.nomReservant = builder.nomReservant;
		this.prenomReservant = builder.prenomReservant;
		this.telephoneReservant = builder.telephoneReservant;
		this.dateHeureDebut = builder.dateHeureDebut;
}


	public static class Builder
	{
		
		private String nomReservant = "nom inconnu";
		private String prenomReservant= "prenom inconnu";
		private String telephoneReservant = "telephone inconnu";
		private LocalDateTime dateHeureDebut = null;
		
		
		public Builder withNomReservant(String nom)
		{
			this.nomReservant = nom;
			return this;
		}
		
		public Builder withPrenomReservant(String prenom)
		{
			this.prenomReservant = prenom;
			return this;
		}
		
		public Builder withTelephoneReservant(String telephoneReservant)
		{
			this.telephoneReservant = telephoneReservant;
			return this;
		}
		
		public Builder withDateHeureDebut(LocalDateTime dateHeureDebut)
		{
			this.dateHeureDebut = dateHeureDebut;
			return this;
		}
		
		public Reservation build()
		{
			return new Reservation(this);
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
	public String getNomReservant() {
		return nomReservant;
	}
	public void setNomReservant(String nomReservant) {
		this.nomReservant = nomReservant;
	}
	public String getPrenomReservant() {
		return prenomReservant;
	}
	public void setPrenomReservant(String prenomReservant) {
		this.prenomReservant = prenomReservant;
	}
	public String getTelephoneReservant() {
		return telephoneReservant;
	}
	public void setTelephoneReservant(String telephoneReservant) {
		this.telephoneReservant = telephoneReservant;
	}
	public LocalDateTime getDateHeureDebut() {
		return dateHeureDebut;
	}
	public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}
	

	
	

}

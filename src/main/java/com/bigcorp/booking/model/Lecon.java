package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lecon {
	
	@Id
	private Long id;

	private String titre;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
}

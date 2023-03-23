package com.bigcorp.booking.mvc;


import java.util.Arrays;
import java.util.List;

public class PojoSpring {
	private String nom;
	private Boolean goose = true;
	private List<String> gooseList = Arrays.asList("oie", "poule", "canard");
	private int iD;
	

	public int getiD() {
		return this.iD;
	}

	public void setiD(int i) {
		this.iD = i;
	}

	public String getNom() {
		return this.nom;
	}

	public Boolean getGoose() {
		return this.goose;
	}

	public void setGoose(Boolean goose) {
		this.goose = goose;
	}

	public List<String> getGooseList() {
		return this.gooseList;
	}

	public void setGooseList(List<String> gooseList) {
		this.gooseList = gooseList;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}

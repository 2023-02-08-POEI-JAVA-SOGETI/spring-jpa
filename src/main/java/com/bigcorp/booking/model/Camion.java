package com.bigcorp.booking.model;

public class Camion {
	
	private Integer id = 1;
	private String model = "Optimus Prime";
	private  String moto = "Tu est bo comme un Camion !";
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMoto() {
		return moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}

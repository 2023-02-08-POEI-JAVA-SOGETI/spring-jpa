package com.bigcorp.booking.model;

import java.io.Serializable;

public class Stand implements Serializable {
	
	private static final long serialVersionUID = 45L;
	private int id;
	private String name;

	public Stand() {

	}

	public Stand(String name) {
		this.name = name;
	}
	
	public Stand(int id, String name) {
		this.setId(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

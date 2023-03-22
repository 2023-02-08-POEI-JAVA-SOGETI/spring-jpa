package com.bigcorp.booking.model;

import java.io.Serializable;

public class Game implements Serializable {
	private static final long serialVersionUID = 2L;
	private int id;
	private String name;
	private String description;
	private String publisher;

	/**
	 * Class Game will need more properties (releaseDate, unitPrice etc) in the
	 * future So a builder might be important to instantiate an object
	 * 
	 * @author ynsdi
	 *
	 */
	public class Builder {
		// Required parameters
		private final int id;
		private final String name;
		private final String publisher;

		// Optional parameters
		private String description = "No description";

		public Builder(int id, String name, String publisher) {
			this.id = id;
			this.name = name;
			this.publisher = publisher;
		}

		public Builder description(String description) {
			this.description = description;

			return this;
		}

		public Game build() {
			return new Game(this);
		}
	}

	private Game(Builder builder) {
		setId(builder.id);
		name = builder.name;
		description = builder.description;
		publisher = builder.publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}

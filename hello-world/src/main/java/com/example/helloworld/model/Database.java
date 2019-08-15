package com.example.helloworld.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Database {
	
	@Id
	private long id;
	
	private String mood;

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}
	
}

package com.tech.entity;

import java.sql.Timestamp;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private Timestamp rdate;
	private String profile;

	public User() {
	}



	public User(int id, String name, String email, String password, String gender, Timestamp rdate, String profile) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.rdate = rdate;
		this.profile = profile;
	}



	public User(String name, String email, String password, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getRdate() {
		return rdate;
	}

	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}



	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, email=%s, password=%s, gender=%s, rdate=%s, profile=%s]", id, name,
				email, password, gender, rdate, profile);
	}


	
}

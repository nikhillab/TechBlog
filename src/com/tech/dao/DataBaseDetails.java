package com.tech.dao;

public class DataBaseDetails {
	
	private final static String dbUrl = "jdbc:mysql://localhost:3306/techblog";
	private final static String user = "root";
	private final static String pass = "nikhil810202";

	public static String getDburl() {
		return dbUrl;
	}

	public static String getUser() {
		return user;
	}

	public static String getPass() {
		return pass;
	}

}

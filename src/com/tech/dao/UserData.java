package com.tech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tech.entity.User;

public class UserData {

	private Connection connection = null;

	public UserData(Connection connection) {
		this.connection = connection;
	}

	public boolean saveUser(User user) throws SQLException {

		boolean isSave = false;
		String query = "insert into user(name,email,password,gender) values(?,?,?,?)";

		if (connection != null) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getGender());
			preparedStatement.executeUpdate();
			isSave = true;
			preparedStatement.close();
			connection.close();

		}

		return isSave;
	}

	public boolean isValidUser(String email, String password) {

		boolean isValid = false;
		try {
			if (connection != null) {
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery("select email,password from user");

				while (resultSet.next()) {

					if (resultSet.getString("email").equals(email)
							&& resultSet.getString("password").equals(password)) {
						isValid = true;
					}
				}
				resultSet.close();
				statement.close();
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isValid;
	}

	public User getUser(String email, String password) {
		User user = null;
		final String query = "select * from user WHERE email=? AND password=?";

		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, password);

				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"),
							resultSet.getString("password"), resultSet.getString("gender"),
							resultSet.getTimestamp("rdate"), resultSet.getString("profile"));
					// System.out.println(user);
				}
				resultSet.close();
				preparedStatement.close();
				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return user;

	}

	public boolean updateUser(User user) {
		boolean isUpadated = false;
		final String query = "update user set name=?,password=?,profile=? where id=?";
		
		if (connection != null) {
			try {
				
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, user.getName());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getProfile());
				statement.setInt(4, user.getId());

				statement.executeUpdate();
				statement.close();
				connection.close();
				
				isUpadated = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isUpadated;
	}
}

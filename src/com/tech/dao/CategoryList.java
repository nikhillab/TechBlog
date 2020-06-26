package com.tech.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tech.entity.Category;

public class CategoryList {
	private Connection connection = null;

	public CategoryList(Connection connection) {
		this.connection = connection;
	}

	public List<Category> getCategoryList() {
		
		List<Category> categoryList = new ArrayList();
		final String query = "select * from category";
		
		if (connection != null) {
			
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String type = resultSet.getString("type");
					String description = resultSet.getString("description");
					Category category = new Category(id, type, description);
					categoryList.add(category);

				}
				resultSet.close();
				statement.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return categoryList;
	}

}

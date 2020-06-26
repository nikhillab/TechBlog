package com.tech.helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tech.dao.CategoryList;
import com.tech.entity.Category;

public class GetCategoryList {

	public static List<Category> categoryList() {
		List<Category> categoryList = new ArrayList();
		try {
			Connection connection = new ConnectDao().getDataBaseConnection();
			
			CategoryList list = new CategoryList(connection);
			
			categoryList = list.getCategoryList();

			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categoryList;

	}

}

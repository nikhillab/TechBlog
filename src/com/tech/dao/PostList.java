package com.tech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tech.entity.Post;

public class PostList {
	private static final String List = null;
	private Connection connection;

	public PostList(Connection connection) {
		this.connection = connection;
	}

	public List<Post> getAllPost() {

		final String query = "select * from post order by pid";
		List<Post> arrayList = new ArrayList<>();
		try {

			if (connection != null) {

				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);

				while (resultSet.next()) {
					Post post = new Post();

					post.setCategoryid(resultSet.getInt("categoryid"));
					post.setPid(resultSet.getInt("pid"));
					post.setContent(resultSet.getString("content"));
					post.setPhoto(resultSet.getString("photo"));
					post.setTime(resultSet.getTimestamp("time"));
					post.setUserid(resultSet.getInt("userid"));
					post.setTitle(resultSet.getString("title"));

					arrayList.add(post);
				}
				resultSet.close();
				statement.close();
				connection.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	public List<Post> getPostByCategoryId(int categoryId) {

		final String query = "select * from post where categoryid=?";
		List<Post> arrayList = new ArrayList<>();

		try {

			if (connection != null) {

				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, categoryId);
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Post post = new Post();

					post.setCategoryid(resultSet.getInt("categoryid"));
					post.setPid(resultSet.getInt("pid"));
					post.setContent(resultSet.getString("content"));
					post.setPhoto(resultSet.getString("photo"));
					post.setTime(resultSet.getTimestamp("time"));
					post.setUserid(resultSet.getInt("userid"));
					post.setTitle(resultSet.getString("title"));

					arrayList.add(post);
				}
				resultSet.close();
				statement.close();
				connection.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayList;
	}

	public Post getPost(int postId) {

		final String query = "select * from post where pid=?";
		Post post = null;

		try {

			if (connection != null) {

				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, postId);
				ResultSet resultSet = statement.executeQuery();

				if (resultSet.next()) {

					post = new Post();

					post.setCategoryid(resultSet.getInt("categoryid"));
					post.setPid(resultSet.getInt("pid"));
					post.setContent(resultSet.getString("content"));
					post.setPhoto(resultSet.getString("photo"));
					post.setTime(resultSet.getTimestamp("time"));
					post.setUserid(resultSet.getInt("userid"));
					post.setTitle(resultSet.getString("title"));
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return post;
	}

}

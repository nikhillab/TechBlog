package com.tech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tech.entity.Post;

public class UpdatePost {
	private Connection connection = null;

	public UpdatePost(Connection connection) {
		this.connection = connection;
	}

	public boolean savePost(Post post) {
		boolean isSaved = false;
		final String query ="insert into post(content, photo, categoryid, userid, title) values(?,?,?,?,?)";
		try {
			if(connection!=null) {
				
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1,post.getContent());
				statement.setString(2,post.getPhoto());
				statement.setInt(3,post.getCategoryid());
				statement.setInt(4,post.getUserid());
				statement.setString(5,post.getTitle());
				statement.executeUpdate();
				
				isSaved=true;
				statement.close();
				connection.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSaved;
	}

}

package com.tech.helper;

import java.sql.Connection;
import java.sql.SQLException;

import com.tech.dao.UpdatePost;
import com.tech.entity.Post;

public class SavePost {

	public static boolean savePost(Post post) {
		boolean saved = false;
		Connection connection = new ConnectDao().getDataBaseConnection();
		UpdatePost updatePost = new UpdatePost(connection);
		saved = updatePost.savePost(post);
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}

}

package com.tech.helper;

import java.util.List;

import com.tech.dao.PostList;
import com.tech.entity.Post;

public class GetPost {

	public static List<Post> getPosts() {

		ConnectDao connectDao = new ConnectDao();
		PostList postList = new PostList(connectDao.getDataBaseConnection());
		List<Post> post = postList.getAllPost();
		connectDao.closeConnection();

		return post;
	}

	public static List<Post> getPostById(int id) {
		ConnectDao connectDao = new ConnectDao();
		PostList postList = new PostList(connectDao.getDataBaseConnection());
		List<Post> post = postList.getPostByCategoryId(id);
		connectDao.closeConnection();

		return post;
	}

	public static Post getFullPost(int postId) {
		
		ConnectDao connectDao = new ConnectDao();
		PostList postList = new PostList(connectDao.getDataBaseConnection());
		Post post = postList.getPost(postId);
		connectDao.closeConnection();

		return post;
	}
}

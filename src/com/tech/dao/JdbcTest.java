package com.tech.dao;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

import com.tech.entity.Post;
public class JdbcTest {

	public static void main(String []args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog", "root" , "nikhil810202");
			
			System.out.println("Database connection successful!\n");
			PostList postList= new PostList(myConn);
			List<Post> allPost = postList.getPostByCategoryId(1);
		for(Post post:allPost) {
			System.out.println(post);
		}
		
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}

}

package com.tech.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.dao.PhotoUpdate;
import com.tech.entity.Message;
import com.tech.entity.Post;
import com.tech.entity.User;
import com.tech.helper.GetCategoryList;
import com.tech.helper.SavePost;

@WebServlet("/NewPost")
@MultipartConfig
public class NewPost extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Part part = request.getPart("photo");
		String photo = part.getSubmittedFileName();

		Post post = new Post(category, user.getId(), content, photo, title);
		
		System.out.println(post);

		final String path = "C:\\Users\\nikhil\\eclipse-workspace\\TechBlog\\WebContent\\img\\blog" + File.separator
				+ photo;
		boolean update = PhotoUpdate.update(part.getInputStream(), path);
		
		boolean savePost = SavePost.savePost(post);

		if (savePost && update) {
			Message message = new Message("success", "Post Published", "alert alert-success");
			session.setAttribute("msg", message);
			response.sendRedirect("profile.jsp");
		} else {
			Message message = new Message("error", "Post Not Published", "alert alert-warning");
			session.setAttribute("msg", message);
			response.sendRedirect("profile.jsp");
		}

	}

}

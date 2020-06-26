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
import javax.sound.midi.Soundbank;

import com.tech.dao.PhotoUpdate;
import com.tech.entity.Message;
import com.tech.entity.User;
import com.tech.helper.UserUpdateService;

@WebServlet("/UpdateUser")
@MultipartConfig
public class UpdateUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		System.out.println(user);

		Part profilePic = request.getPart("profile");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String profile = profilePic.getSubmittedFileName();

		UserUpdateService.deletePhoto(user);

		user.setName(name);
		user.setPassword(password);
		user.setProfile(profile);

		System.out.println(user);
		
		boolean updatePhoto = UserUpdateService.updatePhoto(user, profilePic);
		
		boolean upadateUser = UserUpdateService.upadateUser(user);
		System.out.println(updatePhoto);
		System.out.println(upadateUser);
		if(updatePhoto && upadateUser ) {
			Message message=new Message("success","Profile Updated","alert alert-success");
			session.setAttribute("msg", message);
			response.sendRedirect("profile.jsp");
		}
		else {
			Message message=new Message("error","Profile  Not Updated ","alert alert-warning");
			session.setAttribute("msg", message);
			response.sendRedirect("profile.jsp");
		}

	}

}

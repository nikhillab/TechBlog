package com.tech.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.entity.Message;
import com.tech.entity.User;
import com.tech.helper.LoginAuth;



@WebServlet("/Login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean authenticateUser =LoginAuth.authenticateUser(email, password);
		if (authenticateUser) {
			User user = LoginAuth.getauthenticateUser(email, password);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("profile.jsp");

		} else {

			Message message = new Message("error", "Invalid Email or Password", "alert alert-warning");
			HttpSession session = request.getSession();
			session.setAttribute("msg", message);

			response.sendRedirect("login.jsp");

		}

	}

}

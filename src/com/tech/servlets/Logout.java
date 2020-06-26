package com.tech.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.entity.Message;

@WebServlet("/Logout")
public class Logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.removeAttribute("user");
		Message message = new Message("Logout", "Logout success", "alert alert-success");
		HttpSession session = request.getSession();
		session.setAttribute("msg", message);
		response.sendRedirect("login.jsp");
	}

}

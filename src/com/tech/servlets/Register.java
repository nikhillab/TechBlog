package com.tech.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.dao.JdbcTest;
import com.tech.dao.UserData;
import com.tech.entity.Message;
import com.tech.entity.User;
import com.tech.helper.ConnectDao;

@WebServlet("/Register")
@MultipartConfig
public class Register extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String errormessag = null;
		boolean saveUser = false;
//		System.out.println(name);
//		System.out.println(email);
//
//		System.out.println(password);
//
//		System.out.println(gender);

		User user = new User(name, email, password, gender);
		ConnectDao connectDao = new ConnectDao();
		// System.out.println(user);
		UserData data = new UserData(connectDao.getDataBaseConnection());
		try {
			saveUser = data.saveUser(user);
		} catch (SQLException e) {
			errormessag = e.getMessage();

		}
		connectDao.closeConnection();
		HttpSession session = request.getSession();
		if (errormessag != null) {
			Message message = new Message("error", errormessag, "alert alert-warning");
			session.setAttribute("msg", message);
		}
		if (saveUser) {
			response.getWriter().print("done");
		}
		else {
			response.getWriter().print(errormessag);

		}
		
	}

}

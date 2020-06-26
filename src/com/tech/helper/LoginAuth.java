package com.tech.helper;

import com.tech.dao.UserData;
import com.tech.entity.User;

public class LoginAuth {

	public static boolean authenticateUser(String email, String password) {

		ConnectDao connectDao = new ConnectDao();
		UserData userdata = new UserData(connectDao.getDataBaseConnection());
		boolean isValid = userdata.isValidUser(email, password);
		connectDao.closeConnection();

		return isValid;
	}

	public static User getauthenticateUser(String email, String password) {
		ConnectDao connectDao = new ConnectDao();
		UserData userdata = new UserData(connectDao.getDataBaseConnection());
		User user = userdata.getUser(email, password);

		connectDao.closeConnection();
		return user;
	}

}

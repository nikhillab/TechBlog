package com.tech.helper;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;

import com.tech.dao.PhotoUpdate;
import com.tech.dao.UserData;
import com.tech.entity.User;

public class UserUpdateService {

	public static boolean upadateUser(User user) {

		boolean updateSucces = false;
		ConnectDao connectDao = new ConnectDao();
		UserData userData = new UserData(connectDao.getDataBaseConnection());

		boolean updateUser = userData.updateUser(user);

		if (updateUser)
			updateSucces = true;
		connectDao.closeConnection();

		return updateSucces;
	}

	public static boolean deletePhoto(User user) {

		final String path = "C:\\Users\\nikhil\\eclipse-workspace\\TechBlog\\WebContent\\img\\profile" + File.separator
				+ user.getProfile();

		boolean delete = PhotoUpdate.delete(path);
		System.out.println(delete);
		
		return delete;
	}

	public static boolean updatePhoto(User user, Part part) {
		
		final String path = "C:\\Users\\nikhil\\eclipse-workspace\\TechBlog\\WebContent\\img\\profile" + File.separator
				+ user.getProfile();
		boolean update=false;
		try {

			 update = PhotoUpdate.update(part.getInputStream(), path);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return update;
	}
}

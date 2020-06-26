package com.tech.helper;

import java.sql.*;

import com.tech.dao.DataBaseDetails;

public class ConnectDao {
	
	private  Connection myConn = null;
	private DataBaseDetails dataBaseDetails;
	
	
	public ConnectDao() {
		this.dataBaseDetails = new DataBaseDetails();
	}


	public  Connection getDataBaseConnection() {

		try {
			if (myConn == null)
                Class.forName("com.mysql.cj.jdbc.Driver");
				myConn = DriverManager.getConnection(dataBaseDetails.getDburl(), dataBaseDetails.getUser(),dataBaseDetails.getPass());

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return myConn;
	}
	
	public  void closeConnection() {
		if(myConn!=null) {
			try {
				myConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

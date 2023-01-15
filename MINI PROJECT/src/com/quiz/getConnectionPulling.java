package com.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class getConnectionPulling { // Collections Pulling
	
	Connection connection=null;
	public Connection getConnectionDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

 }

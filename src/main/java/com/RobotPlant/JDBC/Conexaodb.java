package com.RobotPlant.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexaodb {

	public Connection getConnection() {
	     try {

	         return DriverManager.getConnection("jdbc:mysql://localhost:3306/RobotPlant?useTimezone=true&serverTimezone=UTC", "root", "");

	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

}

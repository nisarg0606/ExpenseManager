package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/expence_manager";
		String userName = "root";
		String password = "";
		Connection con = null;
		try {
			Class.forName(driver);// load driver into memory
			con = DriverManager.getConnection(url, userName, password);
			if (con != null) {
				System.out.println("database connected.....");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong...." + e.getMessage());
		}
		return con;
	}

	public static void main(String[] args) {
		//
		getConnection();
	}
}
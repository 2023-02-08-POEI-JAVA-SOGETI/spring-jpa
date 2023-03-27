package com.bigcorp.booking.mainapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainApp {
	
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3308/test_francois";
		String userName ="root";
		String password ="a";
		
	try {
		Connection con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
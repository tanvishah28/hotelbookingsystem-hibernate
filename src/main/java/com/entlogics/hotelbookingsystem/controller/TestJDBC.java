package com.entlogics.hotelbookingsystem.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	public static void main(String[] args) {

		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hoteldb?useSSL=false&serverTimezone=UTC";
		String user = "hoteldbuser";
		String pass = "tanvi";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Class.forName(driver);

			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection Successful");

			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

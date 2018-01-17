package com.generation.jwd.p1.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conectandchecklogin {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String db_user = "root";
		String db_pass = "1234";
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bananagestp2",db_user,db_pass);
		System.out.println("Conexion exitosa");
		
		try {
			stmt = (PreparedStatement) connection.prepareStatement("SELECT*FROM users");
			rs = stmt.executeQuery();
			System.out.println("Conexion exitosa2");
			while (rs.next()) {
				String s = rs.getString("email");
				String j = rs.getString("password");
				if (s.equals("mariov@gmail.com")) {
					System.out.println(s);

				}
				
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e){
			System.out.println("Connection Failed! Check output console");
			connection.rollback();
			return;
		}
	}
	
	
	}








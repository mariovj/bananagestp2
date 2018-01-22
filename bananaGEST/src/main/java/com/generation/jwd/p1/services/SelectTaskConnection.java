package com.generation.jwd.p1.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;


public class SelectTaskConnection {

	public static void main(String[] args) throws SQLException {

		        try {
		            Class.forName("com.mysql.jdbc.Driver");
		        } catch (ClassNotFoundException e) {
		            System.out.println("Where is your MySQL JDBC Driver?");
		            e.printStackTrace();
		            return;
		        }
		        System.out.println("MySQL JDBC Driver Registered!");
		        
		        Connection connection = null;
		        Statement stmt = null;
		        ResultSet rs = null;
		        String tarea []= new String [5];
		        String db_user = "root";
		        String db_pass = "asteroideb612";
//		        ArrayList<Task> taskList = new ArrayList<Task>();
		        
		        try {
			        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bananaGESTp2",db_user,db_pass);
			        System.out.println("Conexion exitosa");
//		            connection.setAutoCommit(false);
//		            System.out.println("Conexion exitosa2");
		        	stmt = connection.createStatement();
		        	rs = stmt.executeQuery("SELECT * FROM tasks");
		        	
		        	while(rs.next()) {
		        		tarea [0]= rs.getString(1);
		        		tarea [1]= rs.getString(2);
		        		tarea [2]= rs.getString(3);
		        		tarea [3]= rs.getString(4);
		        		tarea [4]= rs.getString(5);
		        		
//		        	 	System.out.println("idtasks=" + rs.getString("idtask") +
//		        	 			"descricpion" + rs.getString("descricpion") +
//		        	 			"responsable" + rs.getString("responsable") +
//		        	 			"fechainicio" + rs.getString("fechainicio") +
//		        	 			"fechafin" + rs.getString("fechafin"));
		        		System.out.println(rs.getString(2));
		        	}
		       
		            System.out.println("Conexion exitosa3");
//		            Timestamp fechaInicio = Date.valueOf("2018-02-16 00:00:00.00000000");
//		            Timestamp fechaFin = Date.valueOf("2018-02-19 00:00:00.00000000");
//		            System.out.println("Conexion exitosa4");
//		            stmt.setInt(1,102);
//		            stmt.setString(2,"mi descripcion2");
//		            stmt.setString(3,"mi responsable2");
//		            stmt.setInt(4,24);
//		            stmt.setTimestamp(5, fechaInicio);
//		            System.out.println("Conexion exitosa5");
//		            stmt.setTimestamp(6, fechaFin);
//		            System.out.println("Conexion exitosa6");
//		            stmt.executeUpdate();
//		            System.out.println("Conexion exitosa7");
//		            System.out.println("Se ha pasado por el segundo statement");
//		            connection.commit();
//		            System.out.println("Statements commiteados");
//		            
//		            if (rs.next()) {
//		                System.out.println("No records found");
//		            } else {
//		                while(rs.next(){

		//
//		            }
		           
		            stmt.close();
		            connection.close();
		        } catch (SQLException e) {
		            System.out.println("Connection Failed! Check output console");
		        }
		        finally {
		        	if (rs !=null) {
		        	try {
		        		rs.close();
		        	} catch (SQLException sqlEx){
		        		rs = null;
		        		System.out.println("result not found");
		        	}
		        	}
		        }
		        
		      	if (stmt !=null) {
		        	try {
		        		stmt.close();
		        	} catch (SQLException sqlEx){
		        		stmt = null;
		        		System.out.println("statement not found");
		        	}
		        	}
		        }
	}

		        


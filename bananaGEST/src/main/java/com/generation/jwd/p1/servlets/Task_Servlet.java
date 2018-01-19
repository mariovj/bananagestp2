package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createtask")

public class Task_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("createtask.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String db_pass = "mnr1988";
//        ArrayList<Task> taskList = new ArrayList<Task>();
        
        try {
	        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bananaGESTp2",db_user,db_pass);
	        System.out.println("Conexion exitosa");
//            connection.setAutoCommit(false);
//            System.out.println("Conexion exitosa2");
        	stmt = connection.createStatement();
        	rs = stmt.executeQuery("SELECT * FROM tasks");
        	
        	while(rs.next()) {
        		tarea [0]= rs.getString(1);
        		tarea [1]= rs.getString(2);
        		tarea [2]= rs.getString(3);
        		tarea [3]= rs.getString(4);
        		tarea [4]= rs.getString(5);
        		
//        	 	System.out.println("idtasks=" + rs.getString("idtask") +
//        	 			"descricpion" + rs.getString("descricpion") +
//        	 			"responsable" + rs.getString("responsable") +
//        	 			"fechainicio" + rs.getString("fechainicio") +
//        	 			"fechafin" + rs.getString("fechafin"));
        		System.out.println(rs.getString(2));
        	}
       
            System.out.println("Conexion exitosa3");
           
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
		



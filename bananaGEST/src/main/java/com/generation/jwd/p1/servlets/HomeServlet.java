package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.generation.jwd.p1.beans.TaskBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/homeuser")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HomeServlet() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        ArrayList tarea = new ArrayList ();
        String db_user = "root";
        String db_pass = "Admin123.";
        
        try {
	        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bananagestp2",db_user,db_pass);
	        	System.out.println("########### Conexion exitosa ################");
        	stmt = connection.createStatement();
        	rs = stmt.executeQuery("SELECT * FROM tasks");
   	 
        	HttpSession session = request.getSession();
        	
        	while(rs.next()) {
        		TaskBean taskbean = new TaskBean (rs.getInt(1),rs.getString(2), 
        										  rs.getString(3), rs.getInt(4),
        										  rs.getDate(5),rs.getDate(6));
        		
        		 System.out.println("############ estamos en el while ##############");
        		
//        		 for(int x = 0; x < tarea.size() ; x++) {
//        			 int size = tarea.size();
//        			 if(taskbean != null) {
        		 
	        		 taskbean.setidtasks(rs.getInt(1));
	        		 taskbean.setnombretarea(rs.getString(2));
	        		 taskbean.setdescripcion(rs.getString(3));
	        		 taskbean.setresponsable(rs.getInt(4));
	        		 taskbean.setfechainicio(rs.getDate(5));
	        		 taskbean.setfechafin(rs.getDate(6));	
        	
        		System.out.println((rs.getString(3)));
        		
        		 	request.setAttribute("taskbean", taskbean);
        		 	request.getRequestDispatcher("homeuser.jsp").forward(request, response);
        		 
        		System.out.println(" ############ Conexion exitosa3 ########");
        	 	}
        	
        	rs.close();
        	stmt.close();
        	connection.close();
        	
       } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
        	
       } finally {
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

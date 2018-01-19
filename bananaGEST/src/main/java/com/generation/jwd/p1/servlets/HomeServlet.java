package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.generation.jwd.p1.beans.TaskBean2;

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
        String tarea []= new String [0];
        String db_user = "root";
        String db_pass = "asteroideb612";
//        ArrayList<Task> taskList = new ArrayList<Task>();
        
        try {
	        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bananaGESTp2",db_user,db_pass);
	        System.out.println("Conexion exitosa");
//            connection.setAutoCommit(false);
//            System.out.println("Conexion exitosa2");
        	stmt = connection.createStatement();
        	rs = stmt.executeQuery("SELECT * FROM tasks");
        	 String idtasks =request.getParameter("idtasks");
        	 String nombretarea =request.getParameter("nombretarea");
        	 String descripcion =request.getParameter("descripcion");
        	 String responsable =request.getParameter("responsable");
        	 String fechainicio =request.getParameter("fechainicio");
        	 String fechafin =request.getParameter("fechafin");
        	 
        	 TaskBean2 task = new TaskBean2 (idtasks, nombretarea, descripcion, responsable, fechainicio, fechafin);
        	 
        	 HttpSession session = request.getSession();
        	while(rs.next()) {
        		tarea [0]= rs.getString(1);
        		tarea [1]= rs.getString(2);
        		tarea [2]= rs.getString(3);
        		tarea [3]= rs.getString(4);
        		tarea [4]= rs.getString(5);
        		tarea [5] = rs.getString(6);
        		
        		System.out.println(rs.getString(2));
        	}
       
            System.out.println("Conexion exitosa3");
           
            stmt.close();
            connection.close();
            request.getRequestDispatcher("homeuser.jsp").forward(request, response);
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
	
	 
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

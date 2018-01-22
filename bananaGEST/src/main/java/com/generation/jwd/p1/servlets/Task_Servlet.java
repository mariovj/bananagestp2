package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String db_user = "root";
        String db_pass = "Admin123.";
//        ArrayList<Task> taskList = new ArrayList<Task>();
        
        try {
	        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bananaGESTp2",db_user,db_pass);
	        System.out.println("Conexion exitosa");
//            connection.setAutoCommit(false);
//            System.out.println("Conexion exitosa2");
        	stmt = (PreparedStatement) connection.createStatement();
        	rs = stmt.executeQuery("SELECT * FROM tasks");
        	
        	Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/bananagestp2");
            Connection conn = (Connection) ds.getConnection();
            stmt = (PreparedStatement)conn.prepareStatement
            		("INSERT INTO tasks VALUES (?,?,?,?,?,?)");
            		  stmt.setInt(1, 001);
            		  stmt.setString(2, "Mario");
            		  stmt.setString(3, "My first task");
            		  stmt.setString(4, "Claudia");
           		      stmt.setDate(5, java.sql.Date.valueOf("2017/03/03 20:18:23"));
//            		  stmt.setDate(6, "2017/04/03");
            		 
            		  DateFormat dateFormatYMD = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            	      Date now = new Date();
            	      String vDateYMD = dateFormatYMD.format(now);
//            	      String vDateMDYSQL =  vDateYMD;
//            	      Date date = new Date(0000-00-00);
        	
        	while(rs.next()) {
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
        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		



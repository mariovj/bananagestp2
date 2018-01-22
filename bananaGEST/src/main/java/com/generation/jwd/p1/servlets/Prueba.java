package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.generation.jwd.p1.beans.LoginBean;

@WebServlet("/login")
public class Prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Prueba() {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("login.jsp");
    	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Connection conn= null;
    	PreparedStatement st = null;
    	ResultSet rs = null;
    	String db_url = "jdbc:mysql://127.0.0.1:3306/bananagestp2";
    	String db_user = "root";
    	String db_password = "Admin123.";
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		conn = DriverManager.getConnection(db_url, db_user, db_password);
    		System.out.println("##################  ALELUYA!!!! #############################");
    	
    	}catch(ClassNotFoundException e) {
    		System.out.println("#######################Dónde está mi drive?r##########");
    	
    	} catch (InstantiationException e) {
    	
    	} catch (IllegalAccessException e) {
    	
    		e.printStackTrace();
    	} catch (SQLException e) {
    	
    		e.printStackTrace();
    	}

    }
 }
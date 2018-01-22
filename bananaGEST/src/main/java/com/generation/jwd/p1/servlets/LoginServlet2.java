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

public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet2() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginBean loginBean = new LoginBean();
        String user = request.getParameter("user");
        String password =request.getParameter("password");
        try {
            if (this.logged(user)) {
                System.out.println("##################### entro ################");
                HttpSession sesion = request.getSession();
                loginBean.setUser(request.getParameter("user"));
                loginBean.setPassword(request.getParameter("password"));
                sesion.setAttribute("User", loginBean.getUser());
                request.getRequestDispatcher("homeuser.jsp").forward(request, response);
    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("###### error #####");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public boolean logged(String user) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       
        boolean resultado = false;
        
        try {
            System.out.println("###################### ENTRO EN EL TRY DE LOGGED ##########################");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException es) {
            System.out.println("Where is your MySQL JDBC Driver?");
            es.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String db_user = "root";
        String db_pass = "Admin123.";
        //connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bananagestp2",db_user,db_pass);
        
        
        try {
            System.out.println("#####################################  ENTRO EN EL TRY DEL logged ##############################");
            //Class.forName("com.mysql.jdbc.Driver");
            System.out.println("#####################################  HAGOS CLAS FOR NAME ##############################");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bananagestp2",db_user,db_pass);
            System.out.println("MySQL JDBC Driver Registered!");
            stmt = (PreparedStatement) connection.prepareStatement("SELECT*FROM users");
            rs = stmt.executeQuery();
            //System.out.println("Conexion exitosa2");
            
            while (rs.next()) {
                String s = rs.getString("email");
                String j = rs.getString("password");
           
                if (s.equals(user)) {
                    System.out.println("holi");
                     resultado =  true;
                     return resultado;
                } else {;
                     resultado =  false;
                }
            }
            
            rs.close();
            stmt.close();
            connection.close();
            return resultado;
            
        } catch (SQLException e){
            System.out.println("Connection Failed! Check output console");
            connection.rollback();
            return resultado;
        
        }
    }
}

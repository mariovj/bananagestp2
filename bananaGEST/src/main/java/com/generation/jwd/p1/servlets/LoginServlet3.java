package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.generation.jwd.p1.beans.Conectandchecklogin;
import com.generation.jwd.p1.beans.LoginBean;


@WebServlet("/login")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet3() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}



	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBean loginBean = new LoginBean();
		loginBean.setUser(request.getParameter("user"));
		loginBean.setPassword(request.getParameter("password"));
		HttpSession session = request.getSession();
		Conectandchecklogin lg = new Conectandchecklogin ();
		System.out.println(lg);
		
		
		

	}

}

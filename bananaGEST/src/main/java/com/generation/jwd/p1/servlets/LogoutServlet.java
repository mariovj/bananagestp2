package com.generation.jwd.p1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/homeuser")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LogoutServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("homeuser.jsp").include(request, response);
		
		HttpSession session = request.getSession();
		session.invalidate();
		
	}




}

package com.atmecs.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public logoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession();
	        if (session != null) {
	            try {
	                //session.setAttribute("name", null);
	                //if (session.getAttribute("name") == null) {
	                    session.invalidate();
	                    //request.setAttribute("Error", "Session has ended.  Please login.");
	                    //request.getRequestDispatcher("index.jsp").forward(request, response);
	                    response.sendRedirect("index.jsp");
	                //}
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	                System.out.println(e);
	            }

	        } else {
	        	
	        }
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

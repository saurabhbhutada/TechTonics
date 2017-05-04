package com.atmecs.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.connections.ConnectionDB;
import com.mysql.jdbc.Connection;
import java.sql.*;

public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	

	private Connection con = null;
    private Statement statement = null;	
    ResultSet rs;
	public void init() throws ServletException {
		con = ConnectionDB.getConnection();
		}
  
    public registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String role  = request.getParameter("role");
		String password = request.getParameter("password");
		String query1 = "SELECT email from members where email='"+email+"'";
		String query = "INSERT INTO members (username, email, password,role) VALUES ('"+username+"', '"+email+"', '"+password+"', '"+role+"')";
		
		
		     try {
			 rs = con.createStatement().executeQuery(query1);
			 
			    if(rs.next()){
					
					
						 //session.setAttribute("email", "Email Id Already Register");
			    	     request.setAttribute("email", "Email Id Already Register");
					 	 request.getRequestDispatcher("register.jsp").forward(request, response);
						 
					
				
					
						
						

			     }
			    else{
			    	
			    	statement = con.createStatement();
					int i = statement.executeUpdate(query);
				
			   // session.setAttribute("Regmsg", "sucessfully Register");
					request.setAttribute("Regmsg", "sucessfully Register");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			    }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		     
		 
		     
		   /*  if(rs != null)
		     {
		    	 session.setAttribute("email", "Email Id Already Register");
		 		request.getRequestDispatcher("register.jsp").forward(request, response);
		     }
		*/
		
		/*	try {
					statement = con.createStatement();
					int i = statement.executeUpdate(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/

		
	
		/*session.setAttribute("Regmsg", "sucessfully Register");
		request.getRequestDispatcher("login.jsp").forward(request, response);*/
	}

}

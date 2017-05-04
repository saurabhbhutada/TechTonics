package com.atmecs.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.connections.ConnectionDB;
import com.atmecs.pojos.Employee;

public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	Statement statement=null;
	Connection connection = ConnectionDB.getConnection();
	String Dbname;
	String dbemail;
	
	
	
	
    public RegisterEmployeeServlet() {
        super();
    }


   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		String title = request.getParameter("title");

		String name = (String) session.getAttribute("name");
		
		String qry = "select * from members where username ="+"'"+name+"'";

		
		try{
			ResultSet resultSet = connection.createStatement().executeQuery(qry);
			
			
			if(resultSet.next()){
				
			String Dbname=resultSet.getString("username");
			String dbemail=resultSet.getString("email");
			String query = "INSERT INTO registeredemployee (name, email,title) VALUES ('"+Dbname+"', '"+dbemail+"', '"+title+"')";
			statement = connection.createStatement();
			int i = statement.executeUpdate(query);
			
			request.getRequestDispatcher("techTalkDetails.jsp").forward(request, response);

					
			}
				
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	
		
	 
  

   
		

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

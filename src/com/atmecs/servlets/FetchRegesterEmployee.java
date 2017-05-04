package com.atmecs.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.connections.ConnectionDB;
import com.atmecs.pojos.RegEmp;
import com.mysql.jdbc.Connection;

public class FetchRegesterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
Connection connection = ConnectionDB.getConnection();
	
    ArrayList<RegEmp> regList = new ArrayList<RegEmp>();
   
  
    public FetchRegesterEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
    String query = "select * from registeredemployee";
		
		if(!regList.isEmpty())
			regList.clear();
		
		try{
			ResultSet resultSet = connection.createStatement().executeQuery(query);
			
			while(resultSet.next()){
                  RegEmp regEmp = new RegEmp();
				
                  
				    regEmp.setName(resultSet.getString("name"));
				    regEmp.setEmail(resultSet.getString("email"));
				    regEmp.setTitle(resultSet.getString("title"));
				    regList.add(regEmp);
					
				
			}
				
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		
		
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("regList", regList);
		
		
		
	    request.getRequestDispatcher("registeredEmployee.jsp").forward(request, response);
	  

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

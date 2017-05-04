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
import com.atmecs.pojos.TechTalk;
import com.mysql.jdbc.Connection;


public class FetchTechTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
Connection connection = ConnectionDB.getConnection();
	
    ArrayList<TechTalk> techList = new ArrayList<TechTalk>();
   
    public FetchTechTalkServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String query = "select * from techtalkdetails";
		
		if(!techList.isEmpty())
			techList.clear();
		
		try{
			ResultSet resultSet = connection.createStatement().executeQuery(query);
			
			while(resultSet.next()){
                  TechTalk tech = new TechTalk();
				
                    tech.setSrNo(resultSet.getString("SrNo"));
				    tech.setDate(resultSet.getString("date"));
				    tech.setTitle(resultSet.getString("title"));
				    tech.setDescription(resultSet.getString("description"));
				    tech.setPresenter(resultSet.getString("presenter"));
				    techList.add(tech);
					
				
			}
				
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		
		
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("list", techList);
		
	  
		

	
	
	request.getRequestDispatcher("techTalkDetails.jsp").forward(request, response);
	  

		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

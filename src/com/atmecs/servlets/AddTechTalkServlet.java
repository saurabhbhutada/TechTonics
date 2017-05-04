package com.atmecs.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.connections.ConnectionDB;
import com.mysql.jdbc.Connection;

public class AddTechTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	private Connection con = null;
    private Statement statement = null;	
	public void init() throws ServletException {
		con = ConnectionDB.getConnection();
		}
  
	
	
    public AddTechTalkServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String presenter = request.getParameter("presenter");
		String date = request.getParameter("date");
		
		String query = "INSERT INTO techtalkdetails (title, description, presenter,date) VALUES ('"+title+"', '"+description+"', '"+presenter+"', '"+date+"')";

		try {
			statement = con.createStatement();
			int i = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("AdminFetchTechTalkServlet").forward(request, response);
		
	
	}

}

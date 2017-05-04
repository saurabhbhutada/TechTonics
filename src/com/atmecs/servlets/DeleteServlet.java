package com.atmecs.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.connections.ConnectionDB;
import java.sql.Connection;

import java.sql.PreparedStatement;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Connection connection = ConnectionDB.getConnection();
    //private Statement statement = null;	
    PreparedStatement st;

    
	
    public DeleteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String srNo = request.getParameter("srNo");
		
		System.out.println("SR NO =====>>>>>>=====>>>>"+srNo);
		
		//String query = "delete from techtalkdetails where SrNo = '"+srNo+"'";
		
		
		/*try {
			statement = connection.createStatement();
			int i = statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			

			st= connection.prepareStatement("delete from techtalkdetails where SrNo = ?");
			st.setString(1, srNo);
			st.executeUpdate();
			int i = st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("AdminFetchTechTalkServlet").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

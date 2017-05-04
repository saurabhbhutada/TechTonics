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




public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private Statement statement = null;	


	private Connection con = null;
    private java.sql.PreparedStatement ps;	
	public void init() throws ServletException {
		con = ConnectionDB.getConnection();
		}
	
    public UpdateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String srNo = request.getParameter("srNo");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String presenter = request.getParameter("presenter");
		String date = request.getParameter("date");
		
		
		System.out.println("UPDATE===================");
		System.out.println(srNo);
		System.out.println(title);
		System.out.println(description);
		
		/*try {
			
			  ps = con.prepareStatement("update techtalkdetails set title=?,description=?,presenter=?,date=? where SrNo=?");

		        ps.setString(1, title);
		        ps.setString(2, description);
		        ps.setString(3, presenter);
		        ps.setString(4, date);
		        ps.setString(5, srNo);
		        
		        int i = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		String query = "update techtalkdetails set title='"+title+"',description='"+description+"',presenter='"+presenter+"',date='"+date+"'where SrNo='"+srNo+"'";

		try {
			statement = con.createStatement();
			int i = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("AdminFetchTechTalkServlet").forward(request, response);
		//response.sendRedirect("techTalkDetails.jsp");  
		
		
	}

}

package com.atmecs.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.atmecs.connections.ConnectionDB;
import com.mysql.jdbc.Connection;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection connection= null;
	public void init() throws ServletException {
		connection = ConnectionDB.getConnection();
		System.out.println(connection);
	}
   
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("user email=>>>>>>>>>>>>>>>>>"+email);
		System.out.println("user password=>>>>>>>>>>>>>>>>>"+password);
		
		//String qry = "select * from members where email ="+"'"+email+"' and password ="+"'"+password+"'" ;
		
		String qry = "select * from members where email ="+"'"+email+"' and password ="+"'"+password+"'" ;
		try{
			ResultSet resultSet = connection.createStatement().executeQuery(qry);
			System.out.println("inside try");
			System.out.println("resultset:"+resultSet);
			//System.out.println("check:"+resultSet.next());
			if(resultSet.next()){
				
					String name=resultSet.getString("username");
					String dbemail=resultSet.getString("email");
					String dbpassword=resultSet.getString("password");
					String role = resultSet.getString("role");
					System.out.println("db email=>>>>>>>>>>>>>>>>>"+dbemail);
					System.out.println("db password=>>>>>>>>>>>>>>>>>"+dbpassword);
					System.out.println("ROLE=>>>>>>>>>>>>>>>>>>"+role);
					

					
					HttpSession session = request.getSession();
					session.setAttribute("name", name);
					
					System.out.println("NAMe========>>>>>>>>>>"+name);
					
					
					if(dbpassword.equals(password) && dbemail.equals(email))
					{
						//HttpSession session = request.getSession();
						if(role.equals("employee")) {
							//session.setAttribute(name, name);
							System.out.println("EMPLOYEEEEEEEEEEEEEEEEEEEEEEEE");
							request.getRequestDispatcher("employee.jsp").forward(request, response);
						}
						else if(role.equals("admin")) {
							//session.setAttribute("name", name);

							System.out.println("ADMINNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
							request.getRequestDispatcher("admin.jsp").forward(request, response);
						}
					}
			} 
			
			else {
				request.setAttribute("msg", "Sorry wrong credentials!!!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
				
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	
		
		

}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

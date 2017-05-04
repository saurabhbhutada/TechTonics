package com.atmecs.connections;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionDB {

	private static Connection connection= null;
	
	 public static Connection getConnection()
	 {
		  try {
			  Class.forName("com.mysql.jdbc.Driver");  
			 connection= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/techtalk", "root", "phugu");
			
		} catch (Exception e) {
			System.out.println("exception:"+ e);
		}
		 return connection;
	 }
	 public static void close(){
		 try {
			connection.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

}

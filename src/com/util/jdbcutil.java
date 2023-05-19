package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcutil {

private jdbcutil() {
		
		
	}
	static {
		  try {
			//1. load register
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("driver loaded sucessfully");
			}
		catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public static Connection getjdbcConnection() throws SQLException, IOException {
		
		      FileInputStream fis=new FileInputStream("C:\\Users\\SHUBHAM\\eclipse-workspace\\com.app\\src\\com\\properties\\application.properties");
		      
		      Properties properties=new Properties();
		      properties.load(fis);   
		      
		Connection connection= DriverManager.getConnection(properties.getProperty("url"),
			    		     properties.getProperty("username"),properties.getProperty("password") );
		 
			    System.out.println("connection establish sucessfully");
			
			    return connection;
		
		  /*String url ="jdbc:mysql://localhost:3306/wscube";   OR LIKETHIS
		    String username ="root";
		    String password ="Shubham1998@";
		    Connection   connection= DriverManager.getConnection(url,username, password);
		    System.out.println("connection establish sucessfully");
		
		    return connection;*/
	}

	public static void cleanUp(Connection connection,Statement statement,ResultSet resultset  )throws SQLException {
		if(connection!=null) {
			connection.close();
		}
		
		if(statement!=null) {
			statement.close();
		}
		if(resultset!=null) {
			resultset.close();
		}
	}

	
	
}

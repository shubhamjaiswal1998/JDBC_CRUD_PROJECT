package com.apps;

import java.io.IOException;

import java.util.Scanner;

// imported package com.util & class jdbcutil=>com.util.jdbcutil;
import com.util.jdbcutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertsqlDATAindb {
    
	public  void insertsqldata( )  {
		Connection   connection=null;
		PreparedStatement pstmt=null; 
		Scanner sc=null;
		
		    try {
		    	  connection=jdbcutil.getjdbcConnection();
String sqlquery="insert into wscube.wsuser(`id`,`name`,`email`,`age`)values(?,?,?,?)";
		    	 if(connection!=null) {
		    		 
		    		 pstmt= connection.prepareStatement(sqlquery);
		    	 }
		    	 if(pstmt!=null){
		    	// take user input
		    		   sc=new Scanner(System.in);
		    		 System.out.print("enter the id ");
		    		int id=sc.nextInt(); 
		    		System.out.print("enter the name ");
		    		 String name=sc.next();
		    		 System.out.print("enter the email ");
		    		 String email=sc.next();
		    		 System.out.print("enter the age ");
		    		 int age=sc.nextInt();
		    		 
		    		 // use precompiled query to set the value
		    		 pstmt.setInt(1, id);
		    		 pstmt.setString(2, name);
		    		 pstmt.setString(3,email);
		    		 pstmt.setInt(4, age);
		    		 // excute the query
		    		 System.out.println(sqlquery);
		    		 int rowffected=pstmt.executeUpdate();
		    		 System.out.println("no of row affecteded "+ rowffected);
		    	 }
		    }
		    catch(IOException ce) {
		    	ce.printStackTrace();
		    }
		    catch(SQLException ce) {
		    	ce.printStackTrace();
		    }
		    catch(Exception ce) {
		    	ce.printStackTrace();
		    }
		    finally {
		    	  try {
		    		  System.out.println("close resourse");
					jdbcutil.cleanUp(connection, pstmt, null);
					  sc.close();
		    	  }catch(SQLException ce) {
		    		  ce.printStackTrace();
		    	  }
		    }
		
			

}
	
	
}

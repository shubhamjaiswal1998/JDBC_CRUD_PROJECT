package com.apps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.jdbcutil;

public class deletesqlrecord {

	public void deletesql() {
	
	Connection   connection=null;
		PreparedStatement pstmt=null;
	
		Scanner sc=null;
		
		    try {
		    	  connection=jdbcutil.getjdbcConnection();
String sqlquery=" delete from wscube.wsuser  where id= ?"; 
		    	 if(connection!=null) {
		    		 
		    		 pstmt= connection.prepareStatement(sqlquery);
		    	 }
		    	 if(pstmt!=null){
		    	// take user input
		    		  sc=new Scanner(System.in);
		    		  
		    		 System.out.print("enter the id ");
		    	     int id=sc.nextInt();
		    	   /*   System.out.print("enter the name ");
		    		String  name=sc.next();*/
		    		  
		    		 // use precompiled query to set the value
		    		 pstmt.setInt(1, id);
		    		// pstmt.setString(2,name);
		    		 
		    		
		    		 // excute the query
		    		 System.out.println(sqlquery);
		    		 int rowcount =pstmt.executeUpdate();
		    		 System.out.println("no of row deleted "+rowcount);
		    		}
		    	 
		    	 // process resultset  not apply for update
		    /*	 if(resultset!=null) {
		    		 if(resultset.next()) {
		   System.out.printf("%d%15s%20s%10d",resultset.getInt(1),resultset.getString(2),
	    			  resultset.getString(3),resultset.getInt(4));
		   System.out.println();
		    		 }else {
		    			 System.out.println("record not found"); 
		    		 }
		    	 }*/
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

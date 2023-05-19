package com.apps;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

// imported package com.util & class jdbcutil=>com.util.jdbcutil;
import com.util.jdbcutil;


public class selectsqldata {

	public  void showsql() {
		
		Connection   connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultset=null;
		Scanner sc=null;
		int id=0;
		
		    try {
		    	  connection=jdbcutil.getjdbcConnection();
String sqlquery="select id,name,email,age from wscube.wsuser where id=?"; 
		    	 if(connection!=null) {
		    		 
		    		 pstmt= connection.prepareStatement(sqlquery);
		    	 }
		    	 if(pstmt!=null){
		    	// take user input
		    		   sc=new Scanner(System.in);
		    		 System.out.print("enter the id ");
		    	      id=sc.nextInt();
		    		 
		    		 // use precompiled query to set the value
		    		 pstmt.setInt(1, id);
		    		
		    		 // excute the query
		    		 System.out.println("used query "+sqlquery);
		    		 resultset=pstmt.executeQuery();
		    		}
		    	 
		    	 // process resultset for print
		    	 if(resultset!=null) {
		    		 if(resultset.next()) {
		   System.out.printf("%d%15s%20s%10d",resultset.getInt(1),resultset.getString(2),
	    			  resultset.getString(3),resultset.getInt(4));
		   System.out.println();
		    		 }else {
		    			 System.out.println("record not found"); 
		    		 }
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

package com.apps;


import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

// imported package com.util & class jdbcutil=>com.util.jdbcutil;
import com.util.jdbcutil;


public class updatesqldata2 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Connection   connection=null;
		PreparedStatement pstmt=null;
	
		Scanner sc=null;
		
		    try {
		    	  connection=jdbcutil.getjdbcConnection();
String sqlquery=" update wscube.wsuser set name= ? where id= ?"; 
		    	 if(connection!=null) {
		    		 
		    		 pstmt= connection.prepareStatement(sqlquery);
		    	 }
		    	 if(pstmt!=null){
		    	// take user input
		    		  sc=new Scanner(System.in);
		    		  
		    		 System.out.print("enter the id ");
		    	     int id=sc.nextInt();
		    	      System.out.print("enter the name ");
		    		String  name=sc.next();
		    		  
		    		 // use precompiled query to set the value
		    		 pstmt.setInt(1, id);
		    		 pstmt.setString(2,name);
		    		 
		    		
		    		 // excute the query
		    		 System.out.println(sqlquery);
		    		 int rowcount =pstmt.executeUpdate();
		    		 System.out.println("no of rowcount "+rowcount);
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

package jdbcdateinsert.com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import com.util.jdbcutil;

public class dateinsertionapp {

	public static void main(String args[]) {
	
		Connection   connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultset=null;
		Scanner sc=null;
		int id=0;
		
		    try {
		    	  connection=jdbcutil.getjdbcConnection();
  String sqlquery="select id,name,img from wscube.img1table where id=?"; 
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
		    			 int id1=resultset.getInt(1);
		    			 String name=resultset.getString(2);
		    			 
		    			    InputStream is= resultset.getBinaryStream(3);
		    			   
		    			  File  file=new File("copied.jpg");
							FileOutputStream fos=new FileOutputStream(file);
							
						/*	int i=is.read();   // m-1 
							while(i!=-1) {         
								
								 fos.write(i); // slow process bcoz take 1 by 1 & read
								 i=is.read();
								
							}*/
							IOUtils.copy(is, fos);  // m-3 best
							
						/*	   byte b[]=new byte[1024];  // m-2
							   while(is.read(b)>0) {
								   
								     fos.write(b);
							   }   */
							
							fos.close();
		    			 System.out.println(id1+"\t"+name+"\t"+file.getAbsolutePath());
		             
		           
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

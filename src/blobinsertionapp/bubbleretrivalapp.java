package blobinsertionapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.util.jdbcutil;

public class bubbleretrivalapp {
	 public static void main(String[] args) {
			// resource used
			Connection connection=null;
			PreparedStatement pstmt=null;
			Scanner sc=null;
			// varible used
			java.sql.Date sqldob=null;
			java.sql.Date sqldom=null;
			String name=null;
			String dob=null;
			String dom=null;
			
			try {
				connection=jdbcutil.getjdbcConnection();
				String sqlquery="insert into wscube.player (`name`,`dob`,`dom`) values(?,?,?)";
				
				if(connection!=null) {
					
					pstmt=connection.prepareStatement(sqlquery);
				if(pstmt!=null) {
					sc=new Scanner(System.in);
					//System.out.print("enter the userid ");
					// id=sc.nextInt();
					System.out.println("enter the user name");
					name=sc.next();
					System.out.println("enter the dob(MM-dd-yyyy) ");
					dob=sc.next();
					System.out.println("enter the dom (yyyy-MM-dd) ");
					dom=sc.next();
					
					
				              }
				
				if(dob!=null) {
				// after take string input have to make date format
				SimpleDateFormat sdf=new SimpleDateFormat("mm-dd-yyyy");
				java.util.Date udate=sdf.parse(dob);
				
				// now convert simple format to sqldate format
				long value=udate.getTime();
				 sqldob=new java.sql.Date(value);
				}
				
				if(dom!=null) 
				 sqldom=java.sql.Date.valueOf(dom);
				// set input value
				//pstmt.setInt(1, id); no use bcoz id is auto increment
				pstmt.setString(1, name);
				pstmt.setDate(2, sqldob);
				pstmt.setDate(3, sqldom);
			
			// excute query
				int rowaffected= pstmt.executeUpdate();
				System.out.println("no of row affected "+rowaffected);
				}
			} catch (SQLException | IOException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
	        catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				try {
					jdbcutil.cleanUp(connection,pstmt,null);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				sc.close();
			}

		}

	
}

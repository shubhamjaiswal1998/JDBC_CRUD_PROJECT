package blobinsertionapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.jdbcutil;

public class blobinsrtion {

	public static void main(String[] args) {
		// resource used
		Connection connection=null;
		PreparedStatement pstmt=null;
		Scanner sc=null;
		// varible used
		
		String name=null;
		String userpic=null;
		
		
		try {
			connection=jdbcutil.getjdbcConnection();
			String sqlquery="insert into wscube.img1table (`name`,`pic`) values(?,?)";
			
			if(connection!=null) {
				
				pstmt=connection.prepareStatement(sqlquery);
			if(pstmt!=null) {
				sc=new Scanner(System.in);
				
				System.out.println("enter the user name");
				name=sc.next();
				System.out.println("enter the user pic ");
				userpic=sc.next();
				
			              }
			
			
			
			pstmt.setString(1, name);
			pstmt.setBinaryStream(2, new FileInputStream(new File(userpic)));
		
		// excute query
			int rowaffected= pstmt.executeUpdate();
			System.out.println(" no of row affected "+rowaffected);
			}
		} catch (SQLException | IOException e) {
			
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

package jdbcdateinsert.com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.util.jdbcutil;

public class jdbcdateretrivalapp {

	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement  pstmt=null;
		ResultSet resultset=null;
		int id=1;
		String name=null;
		
		try {
			connection=jdbcutil.getjdbcConnection();
			
			String sqlquery="select id,name,dob,dom from wscube.player where id=?";
			if(connection!=null) {
				
				pstmt=connection.prepareStatement(sqlquery);
			}
			// 
			if(pstmt!=null) {
				// set thevalue
				pstmt.setInt(1, id);
				// excute the query
				resultset=pstmt.executeQuery();
			}
			
			if(resultset!=null) {
				// process result
				if(resultset.next()) {
					 id=resultset.getInt(1);
					 name=resultset.getString(2);
					java.sql.Date udob=resultset.getDate(3);
					java.sql.Date udom=resultset.getDate(4);
					
					SimpleDateFormat sdf=  new SimpleDateFormat("dd-MM-yyyy");
				    
				       String strdob =sdf.format(udob);
				       String strdom =sdf.format(udom);
				
					System.out.println(id+"\t"+name+"\t"+udob+"\t"+udom);
					System.out.println("second type format print ");
					System.out.println(id+"\t"+name+"\t"+strdob+"\t"+strdom);
					    }
				else {
					System.out.print("record not found for id "+id);
				}
			}
			
			
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
       catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				jdbcutil.cleanUp(connection, pstmt, resultset);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		

	}

}

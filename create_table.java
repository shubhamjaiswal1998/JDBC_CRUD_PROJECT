package crud_3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class create_table {

	public static void createTable(String table_name) throws Exception {

		Connection con = make_connection.make_con();

		String str = "create table "+table_name+" (id int, name varchar(50));";

		PreparedStatement pstmt = con.prepareStatement(str);

		pstmt.executeUpdate();
		System.out.println("table created ");

	}

}

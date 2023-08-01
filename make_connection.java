package crud_3;

import java.sql.Connection;
import java.sql.DriverManager;

public class make_connection {

	public static Connection make_con() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/wscube";

		Connection con = DriverManager.getConnection(url, "root", "Shubham1998@");

		return con;

	}

}

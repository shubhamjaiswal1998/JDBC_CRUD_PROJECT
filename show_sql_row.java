package crud_3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class show_sql_row {

	public static void show_row(String str) throws Exception {

		Connection con = make_connection.make_con();

		Statement stmt = con.createStatement();

		ResultSet res = stmt.executeQuery(str);

		while (res.next()) {
			int id = res.getInt(1);
			String name = res.getString(2);
			String address = res.getString(3);

			System.out.println(id + " " + name + " " + address);

		}

	}
}

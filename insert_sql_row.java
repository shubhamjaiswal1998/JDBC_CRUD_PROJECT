package crud_3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class insert_sql_row {

	public static void insert(int id, String name, String address) throws Exception {

		Connection con = make_connection.make_con();

		String str = "insert into wscube.coco (id,name,address) values (?,?,?);";

		PreparedStatement pstmt = con.prepareStatement(str);

		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, address);

		int row = pstmt.executeUpdate();
		if (row>0) {
			System.out.println("inserted data");
		}
		else {
			System.out.println("not inserted ");
		}

	}
}

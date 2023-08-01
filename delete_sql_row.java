package crud_3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class delete_sql_row {

	public static void delete(int id) throws Exception {

		Connection con = make_connection.make_con();

		String str = "delete from wscube.coco where id=?";
		PreparedStatement pstmt = con.prepareStatement(str);

		pstmt.setInt(1, id);

		int row = pstmt.executeUpdate();
		if (row>0) {
			System.out.println("deleted row");
		}
		else {
			System.out.println("not deleted ");
		}
	}
}

package crud_3;

public class test {

	public static void main(String[] args) throws Exception {
		System.out.println("welcome");
		
		show_sql_row.show_row("select * from wscube.coco");
		  
		int id=18;
		System.out.println("after deleting "+id+"th row"+"**********************************************");
		delete_sql_row.delete(id);
		
		show_sql_row.show_row("select * from wscube.coco");
		
		insert_sql_row.insert(19, "glo", "jnp");
		System.out.println("after insrting "+" ******************************************************");
		show_sql_row.show_row("select * from wscube.coco");
		create_table.createTable("sweet");
		
		  

	}

}

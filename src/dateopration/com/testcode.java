package dateopration.com;



public class testcode {

	public static void main(String[] args) {
	//use util.Date to store both time & date information
		java.util.Date utildate=new java.util.Date();
		System.out.println("util date is "+utildate);
		
		//	use sql.Date to store date information
		long value=utildate.getTime();
		System.out.println("information about date in miliseconds "+value);
		java.sql.Date sqldate=new java.sql.Date(value);
		 System.out.println("util date is "+sqldate);
		 
	}

}

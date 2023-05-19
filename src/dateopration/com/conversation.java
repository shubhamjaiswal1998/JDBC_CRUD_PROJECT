package dateopration.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class conversation {

	public static void main(String[] args) throws ParseException {
		// raed the input from the user
		Scanner scanner=new  Scanner(System.in);
		System.out.println("enter the date:: (dd-MM-yyyy)");
        String sdate=scanner.next();
        
        // convert date from string format to java util date
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date udate=sdf.parse(sdate);
        
        //convert java.utildate to sqldate
        long value=udate.getTime();
        java.sql.Date sqldate=new java.sql.Date(value);
        
        // prints all format date
        System.out.println("string format  date::"+sdate);
        System.out.println("util date:: "+udate);
       
        System.out.println("sql  date:: "+sqldate);
        
        System.out.println();
        System.out.println("enter dom into the following format ::(yyyy-MM-dd)");
        String standardinput=scanner.next();
        java.sql.Date standardsqldate= java.sql.Date.valueOf(standardinput);
        
        System.out.println("string standard input::"+standardinput);
        System.out.println("string sqltandard input:: "+standardsqldate);
       
        
        
        scanner.close();
		
	}

}

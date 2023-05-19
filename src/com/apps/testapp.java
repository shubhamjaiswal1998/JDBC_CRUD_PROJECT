package com.apps;

import java.util.Scanner;

public class testapp {

	public static void main(String[] args)  {
		
		System.out.println("welcome to sqldatabase world");
		System.out.println();
		 
		 Scanner sc=new Scanner(System.in);
		 int c;
		 while(true) {
			 System.out.println("enter key 1 to show sql data");
			 System.out.println("enter key  2 to insert sql data");
			 System.out.println("enter key  3 to delete sql data");
			 System.out.println("enter key  4 to close database");
			 System.out.println();
			 
			   c =sc.nextInt();
			 if(c==1) {
				 selectsqldata s2=new selectsqldata();
				    s2.showsql(); break;
			 }else if(c==2) {
				insertsqlDATAindb  s3=new insertsqlDATAindb();
				   s3.insertsqldata(); break;
			 }else if(c==3) {
				deletesqlrecord s1= new deletesqlrecord();
				  s1.deletesql();  break;
			 }else {
				 break;
			 }
		 }
		   sc.close();
		 System.out.println("thank you for using my sqldadabase ");
		 

}
}
	
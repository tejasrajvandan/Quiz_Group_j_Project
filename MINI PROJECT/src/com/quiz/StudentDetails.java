	package com.quiz;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.util.Scanner;
	
	public class StudentDetails { // This class is use to insert student details in DB.
	
	public static void main(String[] args) {

	try {
		
		// Loading driver Class
		Class.forName("com.mysql.jdbc.Driver");
		
		// Creating Connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "root");
		
		// By using prepareStatement
		PreparedStatement ps = con.prepareStatement("INSERT INTO student_details (StudentName, Score) values(?,?)");
		
		// here user can insert records in DB.
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Student Name >> ");
		String StudentName = scan.next();
		System.out.println("Enter Student Score >> ");
		int Score = scan.nextInt();
		
		ps.setString(1, StudentName);
		ps.setInt(2, Score);
	    System.out.println("Records inserted.....");
		
		// Submit and execute statement
		int i = ps.executeUpdate();
		System.out.println("Number of recored insurted>> " + i);
		
		// here we closing the connection and prepare Statement.
		con.close();
		ps.close();
		
	}  catch(Exception e) {
		e.printStackTrace();
	}
		
    }

	}


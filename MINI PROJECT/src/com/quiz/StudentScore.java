package com.quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;

 // RUN THE PROGRAM TO GIVE EXAM.
public class StudentScore { // this class is create to show student, selected answer is right or wrong /and ability to select correct answer by given options.

	public static void main(String[] args)  throws SQLException, ClassNotFoundException  {
		
	   try {
			// Loading driver Class
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "root");
			
			// veriables for answer right or wrong.
			String ran;
			int correct=0;
			int wrong=0;
			
			// creating Hashset list for every questions print one by one with options in console.
			 HashSet hs = new HashSet();
			   hs.add(1);
			   hs.add(2);
			   hs.add(3);
			   hs.add(4);
			   hs.add(5);
			   hs.add(6);
			   hs.add(7);
			   hs.add(8);
			   hs.add(9);
			   hs.add(10);
			  
			   // logic here
			   for(Object j : hs) { 
			  System.out.println(j);
				int k = (Integer) j;
				
			// By using prepareStatement
			PreparedStatement ps =con.prepareStatement("SELECT * FROM quiz ORDER BY RAND()");
	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("---------------");
				System.out.println("Qno"+rs.getString(1));
				System.out.println("Q. "+rs.getString(2));
				System.out.println("A. "+rs.getString(3));
				System.out.println("B. "+rs.getString(4));
				System.out.println("C. "+rs.getString(5));
				System.out.println("D. "+rs.getString(6));
				ran = rs.getString(7);
				System.out.println();
		
				Scanner sc = new Scanner(System.in);
				System.out.println("Please Enter your Answer");
				String userInput =sc.next();
				
				if(ran.equals(userInput)) {
					System.out.println("Your Answer is correct");
	                
					correct++;
					} else {
						System.out.println("Your Answer is Wrong");
						System.out.println("This is the Correct Answer >> "+rs.getString(7));
						wrong++; 
					}
			}
			
			System.out.println();
			System.out.println("--------Result -------");
			System.out.println("Total Questions >> "+hs.size());
			System.out.println("Correct Answer Question >> "+correct);
			System.out.println("Wrong Answer Question >> "+wrong);
		
			// this code show student class categories based on marks.
			
			Scanner scanner = new Scanner(System.in);
			int marks = scanner.nextInt();
			if(marks>=8 && marks<=10) {
			System.out.println("Class A");
			}
			else if(marks>=6 && marks<8) {
			System.out.println("Class B");
			}
			else if(marks==5) {
				System.out.println("Class C");
			}
			else {
				System.out.println("You are Fail, Need to improve your skills!");
			}
			
			scanner.close();
			con.close();
			ps.close();
			
	   }
			 		
		} catch(Exception e) {
			e.printStackTrace();
	}

	}
 }




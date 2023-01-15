package com.quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {  // This class is use to store Questions and Answer into database.

	public static void main(String[] args) {

		try {
			// Loading driver Class
			Class.forName("com.mysql.jdbc.Driver");
			
			// Creating Connection with database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "root");
			
			// By using prepareStatement.
			PreparedStatement ps = con.prepareStatement ("INSERT INTO quiz (Question, Option_A, Option_B, Option_C, Option_D, CorrectAnwser) "
			+ "VALUES ('Who is known as father of Java Programming Language?', 'James Gosling', 'M.P Java', 'Charel Babbage', 'Blais Pascal', 'A' ),"
			+ "('Which provide runtime environment for java byte code to be executed?', 'JDK', 'JVM', 'JRE', 'JAVAC', 'B'), "
			+ "('Which of the following are not java keywords?','double','switch','then','instance_of','C'), "
			+ "('Which of these have highest precedence?', '()', '++', '*', '>>', 'A'), "
			+ "('Which of these is returned by operator & ?', 'integer','Character','Boolean','Float','B'), "
			+ "('Data type long literals are appended by__?', 'Uppercase L', 'Lowercase L', 'Long', 'Both A&B', 'D'), "
			+ "('Java language was initially called as__?', 'sumatra', 'j++', 'Oak', 'Pine', 'C'), "
			+ "('Which one is a template for creating different object?', 'An Array','A Class','Interface','Method','B'), "
			+ "('What is the fullform of JVM?', 'Java Verylarge Machine', 'Java Verified Machine', 'Java VerySmall Machine', 'Java Virtual Machine','D'), "
			+ "('Which of the following is not a Java features?', 'Dynamic', 'Architecture Neutral', 'Use of pointers', 'Object-oriented', 'C') "); 
			
			
			// Submit and execute statement.
			int i = ps.executeUpdate();
			System.out.println("Number of recored inserted>> " + i);
			
			// here we closing the connection and prepareStatement.
			con.close();
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

 }

package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static void main(String[] args) {
		
		//here we're just testing whether our connection (from the ConnectionUtil Class) is successful
		//remember - the getConnection() method will return a Connection object if you successfully reach the database
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection successful!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println(ad.getAllAvengers());
	}


	//a method called getConnection that returns a Connection object
	public static Connection getConnection() throws SQLException {
		//For compatibility with other technologies/frameworks, we'll need to register our Driver
		//This process makes the application aware of what Driver class (what SQL dialect) we're using
		try {
			Class.forName("org.postgresql.Driver"); //try to find and return the postgresql Driver Class
		} catch (ClassNotFoundException e) {
			System.out.println("Class wasn't found :(");
			e.printStackTrace(); //prints the exception message to the console if we can't find the postgresql class
		}
		
		
			//	//We need to provide our database credentials
			//	//We'll hardcode them for now, but we'll see how to hide this username/password in environment variables
			String url = "jdbc:postgresql://javafs210601.cvbm9aejcfkb.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=P1Demo";
			String username = "postgres";
			String password = "password"; //this will be whatever password you set in postgres (or RDS if you're using that)
		
		
			return DriverManager.getConnection(url, username, password);
	
		}
}

package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Ers_Users;
import com.revature.utils.ConnectionUtil;

public class Ers_Users_DAO implements Ers_Users_Interface {
	
	@Override
	public List<Ers_Users> getAllErs_Users() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".ers_users;"; //write your sql statement to send to the DB
			
			Statement s = conn.createStatement(); //create a statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet (Execute the query into it!)
			
			List<Ers_Users> Ers_UsersList = new ArrayList<>(); //create a new ArrayList to hold all the Ers_Users  
			
			
			while(rs.next()) { //while there are still rows in our ResultSet
				
				//make a new Ers_Users object for each row
				Ers_Users a = new Ers_Users (
					rs.getInt("ers_users_id"),
					rs.getString("ers_username"),
					rs.getString("ers_password"),
					rs.getString("user_first_name"),
					rs.getString("user_last_name"),
					rs.getString("user_email"),
					rs.getInt("user_role_id") ); 
		
				//after creating the Ers_Users, add it to the ArrayList
				Ers_UsersList.add(a);
			}
			
			//outside our while loop, once all Ers_Users have been added to the list, return the ArrayList
			return Ers_UsersList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all Ers_Users failed in Ers_Users_DAO.java");
			e.printStackTrace();
		}
		return null;
	}
}

package com.revature.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Ers_User_Roles;
import com.revature.utils.ConnectionUtil;

public class Ers_User_Roles_DAO implements Ers_User_Roles_Interface {

	@Override
	public List<Ers_User_Roles> getAllErs_User_Roles() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".ers_user_roles;"; //write your sql statement to send to the DB
			
			Statement s = conn.createStatement(); //create a statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet (Execute the query into it!)
			
			List<Ers_User_Roles> Ers_User_RolesList = new ArrayList<>(); //create a new ArrayList to hold all the Ers_User_Roles
			
			
			while(rs.next()) { //while there are still rows in our ResultSet
				
				//make a new Avenger object for each row
				Ers_User_Roles a = new Ers_User_Roles (
					rs.getInt("ers_user_role_id"),
					rs.getString("user_role")
				);
				
				
				//after creating the Ers_User_Roles object, add it to the ArrayList
				Ers_User_RolesList.add(a);
			}
			
			//outside our while loop, once all Ers_User_Roles have been added to the list, return the ArrayList
			return Ers_User_RolesList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all Ers_User_Roles failed in Ers_User_Roles_DAO.java");
			e.printStackTrace();
		}
		return null;
	}
}

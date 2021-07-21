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
				
				//make a new Ers_User_Roles object for each row
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
	
	/*
	@Override
	public Ers_User_Roles getErs_User_RolesById(int i) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM \"ERS\".ers_user_roles WHERE ers_user_role_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery(); //the results of our query will be put into the ResultSet object
			
			if(rs.next()) { //we won't need a while loop, we're only expecting one result
				
				//Just for the sake of showing you a different way to populate a Home object...
				//...using the setters instead of the constructor like we did in getAllAvengers()	
				Home h = new Home(); //instantiate an empty home object
				
				//use the setters to populate its fields
				h.setHome_name(name); //this can just be the name object getting sent in from the parameters
				h.setHome_address(rs.getString("home_address"));
				h.setHome_city(rs.getString("home_city"));
				h.setHome_state(rs.getString("home_state"));
				h.setHome_zip(rs.getString("home_zip"));
			
				return h; //return the home object
			}
		
			
		} catch (SQLException e) {
			System.out.println("Couldn't get home by name");
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	*/

}

package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Ers_Reimbursement;
import com.revature.utils.ConnectionUtil;

public class Ers_Reimbursement_DAO implements Ers_Reimbursement_Interface {

	
	@Override
	public List<Ers_Reimbursement> getAllErs_Reimbursement() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".ers_reimbursement;"; //write your sql statement to send to the DB
			
			Statement s = conn.createStatement(); //create a statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet (Execute the query into it!)
			
			List<Ers_Reimbursement> Ers_ReimbursementList = new ArrayList<>(); //create a new ArrayList to hold all the Ers_Reimbursement  
			
			while(rs.next()) { //while there are still rows in our ResultSet
				//make a new Ers_Users object for each row
				Ers_Reimbursement a = new Ers_Reimbursement (
					rs.getInt("reimb_id"),
					rs.getInt("reimb_amount"),
					rs.getString("reimb_submitted"),
					rs.getString("reimb_resolved"),
					rs.getString("reimb_description"),
					rs.getInt("reimb_author"),
					rs.getInt("reimb_resolver"),
					rs.getInt("reimb_status_id"),
					rs.getInt("reimb_type_id")); 
				//after creating the Ers_Users, add it to the ArrayList
				Ers_ReimbursementList.add(a);
			}
			//outside our while loop, once all Ers_Reimbursement have been added to the list, return the ArrayList
			return Ers_ReimbursementList;
		} catch (SQLException e) {
			System.out.println("Get all Ers_Reimbursement failed in Ers_Reimbursement_DAO.java");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Ers_Reimbursement> getEmployeeReimbursements() {
			
			try(Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "SELECT * FROM \"ERS\".ers_reimbursement WHERE reimb_author = 5;";
				//String sql = "SELECT * FROM \"ERS\".ers_reimbursment WHERE reimb_author = 5;";				
				ResultSet rs = null;				
				PreparedStatement ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				List<Ers_Reimbursement> Ers_ReimbursementList = new ArrayList<>();
				
				while(rs.next()) {
					Ers_Reimbursement Ers_Reimbursement = new Ers_Reimbursement (	
							rs.getInt("reimb_id"), 
							rs.getInt("reimb_amount"),
							rs.getString("reimb_submitted"),
							rs.getString("reimb_resolved"),
							rs.getString("reimb_description"),
							rs.getInt("reimb_author"),
							rs.getInt("reimb_resolver"),
							rs.getInt("reimb_status_id"),
							rs.getInt("reimb_type_id")
							);
					Ers_ReimbursementList.add(Ers_Reimbursement);
				}
				return Ers_ReimbursementList;
				
			}catch (SQLException e) {
				System.out.println("Unable to view past transactions");
				e.printStackTrace();
			}
			return null;
		}

	@Override
	public void addErs_Reimbursement_Request(int reimb_type_id, int reimb_amount, String reimb_description) {
	try (Connection conn = ConnectionUtil.getConnection()){
				//Setup sql string to exact parameters!
				String sql = "INSERT INTO \"ERS\".ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
						+ "values(?, current_timestamp, null, ?, 5, 6, 1, ?);";
				
				//injecting user input into SQL
				PreparedStatement PreparedStatement = conn.prepareStatement(sql);
				PreparedStatement.setInt(1, reimb_amount);
				PreparedStatement.setString(2, reimb_description);
				PreparedStatement.setInt(3, reimb_type_id);
				PreparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error: addErs_Reimbursement_Request Failed!");
				e.printStackTrace();
			}
		}

	@Override
	public void acceptDenyReimbursement(int reimb_id, int reimb_status_id) {
	try (Connection conn = ConnectionUtil.getConnection()) {
				String sql = "UPDATE \"ERS\".ers_reimbursment SET reimb_status_id = ?, reimb_resolver = 2, reimb_resolved = current_timestamp WHERE reimb_id = ?;";
				
				//Preparing injection into server
				PreparedStatement PreparedStatement = conn.prepareStatement(sql);
				PreparedStatement.setInt(1, reimb_status_id);
				PreparedStatement.setInt(2, reimb_id);
				
			}catch (SQLException e) {
				System.out.println("Error updating database in acceptDenyReimbursement method in Ers_Reimbursement_DAO.java");
				e.printStackTrace();
			}
		}
} //end class

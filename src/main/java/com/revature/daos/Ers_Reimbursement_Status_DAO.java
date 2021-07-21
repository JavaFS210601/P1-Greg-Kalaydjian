package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Ers_Reimbursement_Status;
import com.revature.utils.ConnectionUtil;

public class Ers_Reimbursement_Status_DAO implements Ers_Reimbursement_Status_Interface
{
	@Override
	public List<Ers_Reimbursement_Status> getAllErs_Reimbursement_Status() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".ers_reimbursement_status;"; //write your sql statement to send to the DB
			
			Statement s = conn.createStatement(); //create a statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet (Execute the query into it!)
			
			List<Ers_Reimbursement_Status> Ers_Reimbursement_StatusList = new ArrayList<>(); //create a new ArrayList to hold all the Ers_Reimbursement_Status  
			
			
			while(rs.next()) { //while there are still rows in our ResultSet
				
				//make a new Ers_Reimbursement_Status object for each row
				Ers_Reimbursement_Status a = new Ers_Reimbursement_Status (
					rs.getInt("reimb_status_id"),
					rs.getString("reimb_status")
				);
				
				
				//after creating the Ers_Reimbursement_Status, add it to the ArrayList
				Ers_Reimbursement_StatusList.add(a);
			}
			
			//outside our while loop, once all Ers_Reimbursement_Status have been added to the list, return the ArrayList
			return Ers_Reimbursement_StatusList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all Ers_Reimbursement_Status failed in Ers_Reimbursement_Status_DAO.java");
			e.printStackTrace();
		}
		return null;
	}
	
}

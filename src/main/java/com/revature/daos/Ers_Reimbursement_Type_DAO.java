package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Ers_Reimbursement_Type;
import com.revature.utils.ConnectionUtil;

public class Ers_Reimbursement_Type_DAO implements Ers_Reimbursement_Type_Interface
{
	@Override
	public List<Ers_Reimbursement_Type> getAllErs_Reimbursement_Type() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".ers_reimbursement_type;"; //write your sql statement to send to the DB
			
			Statement s = conn.createStatement(); //create a statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet (Execute the query into it!)
			
			List<Ers_Reimbursement_Type> Ers_Reimbursement_TypeList = new ArrayList<>(); //create a new ArrayList to hold all the Ers_Reimbursement_Type  
			
			
			while(rs.next()) { //while there are still rows in our ResultSet
				
				//make a new Ers_Reimbursement_Type object for each row
				Ers_Reimbursement_Type a = new Ers_Reimbursement_Type (
					rs.getInt("reimb_type_id"),
					rs.getString("reimb_type")
				);
				
				
				//after creating the Ers_Reimbursement_Type object, add it to the ArrayList
				Ers_Reimbursement_TypeList.add(a);
			}
			
			//outside our while loop, once all Ers_Reimbursement_Type have been added to the list, return the ArrayList
			return Ers_Reimbursement_TypeList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all Ers_Reimbursement_Type failed in Ers_Reimbursement_Type_DAO.java");
			e.printStackTrace();
		}
		return null;
	}
}

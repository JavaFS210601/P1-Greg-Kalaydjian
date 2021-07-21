package com.revature.daos;

import java.util.List;
import com.revature.models.Ers_Reimbursement_Status;

public interface Ers_Reimbursement_Status_Interface {
	public List<Ers_Reimbursement_Status> getAllErs_Reimbursement_Status(); //return all the Ers_Reimbursement_Status from the database
	
	//public Ers_Reimbursement_Status getErs_Reimbursement_StatusById(int id); //take in an int, find the Ers_Reimbursement_Status with that id
}

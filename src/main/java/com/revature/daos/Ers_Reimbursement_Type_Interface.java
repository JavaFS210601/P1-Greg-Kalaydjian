package com.revature.daos;

import java.util.List;
import com.revature.models.Ers_Reimbursement_Type;


public interface Ers_Reimbursement_Type_Interface 
{
	public List<Ers_Reimbursement_Type> getAllErs_Reimbursement_Type(); //return all the Ers_Reimbursement_Type from the database
	
	//public Ers_Reimbursement_Type getErs_Reimbursement_TypeById(int id); //take in an int, find the Ers_Reimbursement_Type with that id
}

package com.revature.services;

import java.util.List;
import com.revature.daos.Ers_Reimbursement_Status_DAO;
import com.revature.daos.Ers_Reimbursement_Status_Interface;
import com.revature.models.Ers_Reimbursement_Status;

public class Ers_Reimbursement_Status_Service {
		//instantiate an Ers_Reimbursement_Status_Service to use it's method
		private Ers_Reimbursement_Status_Interface Ers_Reimbursement_Status_DAO = new Ers_Reimbursement_Status_DAO();
		
		//create a method that sends the DAO data up to the controller (this method will be called by the controller)
		public List<Ers_Reimbursement_Status> getAllErs_Reimbursement_Status() {
			return Ers_Reimbursement_Status_DAO.getAllErs_Reimbursement_Status();
		}
		
		//literally all we're doing here is calling the method of the dao in order to get the List of Ers_User_Status
}

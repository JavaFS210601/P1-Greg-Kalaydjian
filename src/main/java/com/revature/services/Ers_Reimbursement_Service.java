package com.revature.services;

import java.util.List;

import com.revature.daos.Ers_Reimbursement_DAO;
import com.revature.daos.Ers_Reimbursement_Interface;
import com.revature.daos.Ers_Users_DAO;
import com.revature.models.Ers_Reimbursement;
import com.revature.models.Ers_Users;

public class Ers_Reimbursement_Service {
		//instantiate an Ers_Users_DAO to use it's method
		private Ers_Reimbursement_Interface Ers_Reimbursement_DAO = new Ers_Reimbursement_DAO();
		
		//create a method that sends the DAO data up to the controller (this method will be called by the controller)
		public List<Ers_Reimbursement> getAllErs_Reimbursement() {
			return Ers_Reimbursement_DAO.getAllErs_Reimbursement();
		}
		
		public List<Ers_Reimbursement> getEmployeeReimbursements(){
			return Ers_Reimbursement_DAO.getEmployeeReimbursements();
		}
		
		public void addErs_Reimbursement_Request(int reimb_type_id, int reimb_amount, String reimb_description) {
			
			//The values 1 to 5 differentiate between different types of requests (Ex: Lodging, Travel, Other).
			if(reimb_type_id >= 1 && reimb_type_id <= 5) {
				Ers_Reimbursement_DAO.addErs_Reimbursement_Request(reimb_type_id, reimb_amount, reimb_description);
			}else {
				System.out.println("Error occured in Ers_Reimbursement_Service.java in the addErs_Reimbursement_Request Method");
			}
		}
		
		public void acceptDenyReimbursement(int reimb_type_id, int reimb_status_id) {
			if(reimb_status_id >= 1 && reimb_status_id <= 3) {
				Ers_Reimbursement_DAO.acceptDenyReimbursement(reimb_type_id, reimb_status_id);
			}else {
				System.out.println("Failed to accept or deny reimbursement in the acceptDenyReimbursement method in Ers_Reimbursement_Service.java");
			}
		}
}

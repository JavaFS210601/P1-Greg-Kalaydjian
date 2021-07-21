package com.revature.daos;
import java.util.List;
import com.revature.models.Ers_Reimbursement;

public interface Ers_Reimbursement_Interface {
	public void acceptDenyReimbursement(int reimb_id, int reimb_status_id);
	
	public List<Ers_Reimbursement> getAllErs_Reimbursement(); //return all Ers_Reimbursement from the database
	
	public List<Ers_Reimbursement> getEmployeeReimbursements();
	
	public void addErs_Reimbursement_Request(int reimb_type_id, int reimb_amount, String reimb_description);
}

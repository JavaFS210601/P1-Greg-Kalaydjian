package com.revature.models;

public class Ers_ReimbursementDTO {

	public int reimb_id;
	public int reimb_amount;
	public int reimb_status_id;
	public int reimb_type_id;
	public String reimb_description;
	
	public Ers_ReimbursementDTO() {
		super();
	}
	public Ers_ReimbursementDTO(int reimb_status_id) {
		super();
		this.reimb_status_id = reimb_status_id;
	}
	
	public Ers_ReimbursementDTO(int reimb_id, int reimb_status_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_status_id = reimb_status_id;
	}
	
	public Ers_ReimbursementDTO(int reimb_id, int reimb_status_id, int reimb_amount, int reimb_type_id, String reimb_description) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_status_id = reimb_status_id;
		this.reimb_amount = reimb_amount;
		this.reimb_type_id = reimb_type_id;
		this.reimb_description = reimb_description;
	}
}

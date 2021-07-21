package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ers_Reimbursement;
import com.revature.models.LoginDTO;
import com.revature.services.Ers_Reimbursement_Service;
import com.revature.models.Ers_ReimbursementDTO;

public class Ers_Reimbursement_Controller {
	private Ers_Reimbursement_Service Ers_Reimbursement_Service = new Ers_Reimbursement_Service();
	private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
	private Ers_ReimbursementDTO Ers_ReimbursementDTO = new Ers_ReimbursementDTO();
	
	//transform data from JSON -> Java or Java -> JSON
	
	//whenever you're working with HttpServletRequests/Responses, your method will need to throw an IOException
	
	public void getAllErs_Reimbursement(HttpServletResponse res) throws IOException {
		
		//get the List of Ers_User_Roles from the service layer (which got it from the dao layer)
		List<Ers_Reimbursement> Ers_Reimbursement_List = Ers_Reimbursement_Service.getAllErs_Reimbursement();
		
		//turn that List in a JSON String
		String json = om.writeValueAsString(Ers_Reimbursement_List);

		//put the JSON into the response object (res)
		res.getWriter().print(json);
	
		//override the default 404 status code that we set in the MasterServlet
		res.setStatus(200);
	}
	  
	public void getEmployeeReimbursements(HttpServletResponse res) throws IOException {
		
		List<Ers_Reimbursement> list = Ers_Reimbursement_Service.getEmployeeReimbursements();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
	public void addErs_Reimbursement_Request(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getMethod().equals("POST")) {
			BufferedReader BufferedReader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
			StringBuilder StringBuilder = new StringBuilder(); //create an empty StringBuilder
			String line = BufferedReader.readLine();  //this will read the contents of the BufferedReader into a String
			
			//Append lines that are not null for the buffer reader
			while(line != null) {
				StringBuilder.append(line);
				line = BufferedReader.readLine();
			}
			
			String body = new String(StringBuilder);
			Ers_ReimbursementDTO Ers_ReimbursementDTO = om.readValue(body, Ers_ReimbursementDTO.class);
			Ers_Reimbursement_Service.addErs_Reimbursement_Request(Ers_ReimbursementDTO.reimb_type_id, Ers_ReimbursementDTO.reimb_amount, Ers_ReimbursementDTO.reimb_description);
			res.setStatus(200);
			
			
		}
	}
	
	public void acceptDenyReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getMethod().equals("POST")) {
			BufferedReader BufferedReader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
			StringBuilder StringBuilder = new StringBuilder();  //create an empty StringBuilder
			String bfLine = BufferedReader.readLine(); //this will read the contents of the BufferedReader into a String
			//Append lines that are not null with the buffer reader
			while(bfLine != null) {
				StringBuilder.append(bfLine);
				bfLine = BufferedReader.readLine();
			}
			
			String body = new String(StringBuilder);
			
			Ers_ReimbursementDTO Ers_ReimbursementDTO = om.readValue(body, Ers_ReimbursementDTO.class);
			Ers_Reimbursement_Service.acceptDenyReimbursement(Ers_ReimbursementDTO.reimb_id, Ers_ReimbursementDTO.reimb_status_id);
			res.setStatus(200);
			res.getWriter().print("Controller accessed");;
		}
	}
	
}

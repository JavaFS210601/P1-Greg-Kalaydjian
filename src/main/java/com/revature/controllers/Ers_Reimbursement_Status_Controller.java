package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ers_Reimbursement_Status;
import com.revature.services.Ers_Reimbursement_Status_Service;


//the controller layer sits between the MasterServlet and the service layer
//this is usually where we'll parse JSON into Java or vice versa
//We'll either be getting data from the service (which got it from the DAO)
//or sending data to the service (which will validate it and send it to the DAO)

public class Ers_Reimbursement_Status_Controller {
	private Ers_Reimbursement_Status_Service Ers_Reimbursement_Status_Service = new Ers_Reimbursement_Status_Service();
	private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
	//transform data from JSON -> Java or Java -> JSON
	
	//whenever you're working with HttpServletRequests/Responses, your method will need to throw an IOException
	public void getAllErs_Reimbursement_Status(HttpServletResponse res) throws IOException {
		
		//get the List of Avengers from the service layer (which got it from the dao layer)
		List<Ers_Reimbursement_Status> Ers_Reimbursement_Status_List = Ers_Reimbursement_Status_Service.getAllErs_Reimbursement_Status();
		
		//turn that List in a JSON String
		String json = om.writeValueAsString(Ers_Reimbursement_Status_List);

		//put the JSON into the response object (res)
		res.getWriter().print(json);
	
		//override the default 404 status code that we set in the MasterServlet
		res.setStatus(200);
	}
}

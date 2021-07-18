package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ers_User_Roles;
import com.revature.services.Ers_User_Roles_Service;

//the controller layer sits between the MasterServlet and the service layer
//this is usually where we'll parse JSON into Java or vice versa
//We'll either be getting data from the service (which got it from the DAO)
//or sending data to the service (which will validate it and send it to the DAO)
public class Ers_User_Roles_Controller {

	private Ers_User_Roles_Service Ers_User_Roles_Service = new Ers_User_Roles_Service();
	private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
	//transform data from JSON -> Java or Java -> JSON
	
	//whenever you're working with HttpServletRequests/Responses, your method will need to throw an IOException
	public void getAllErs_User_Roles(HttpServletResponse res) throws IOException {
		
		//get the List of Avengers from the service layer (which got it from the dao layer)
		List<Ers_User_Roles> Ers_User_Roles_List = Ers_User_Roles_Service.getAllErs_User_Roles();
		
		//turn that List in a JSON String
		String json = om.writeValueAsString(Ers_User_Roles_List);

		//put the JSON into the response object (res)
		res.getWriter().print(json);
	
		//override the default 404 status code that we set in the MasterServlet
		res.setStatus(200);
	}
}
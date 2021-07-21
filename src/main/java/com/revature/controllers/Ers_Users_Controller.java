package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ers_Users;
import com.revature.services.Ers_Users_Service;

//the controller layer sits between the MasterServlet and the service layer
//this is usually where we'll parse JSON into Java or vice versa
//We'll either be getting data from the service (which got it from the DAO)
//or sending data to the service (which will validate it and send it to the DAO)

public class Ers_Users_Controller {
	
	private Ers_Users_Service Ers_Users_Service = new Ers_Users_Service();
	
	private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
	//transform data from JSON -> Java or Java -> JSON
	
	//whenever you're working with HttpServletRequests/Responses, your method will need to throw an IOException
	public void getAllErs_Users(HttpServletResponse res) throws IOException {
		
		//get the List of Ers_User_Roles from the service layer (which got it from the dao layer)
		List<Ers_Users> Ers_Users_List = Ers_Users_Service.getAllErs_Users();
		
		//turn that List in a JSON String
		String json = om.writeValueAsString(Ers_Users_List);

		//put the JSON into the response object (res)
		res.getWriter().print(json);
	
		//override the default 404 status code that we set in the MasterServlet
		res.setStatus(200);
	}
}

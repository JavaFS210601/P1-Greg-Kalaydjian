package com.revature.services;

import java.util.List;
import com.revature.daos.Ers_User_Roles_DAO;
import com.revature.daos.Ers_User_Roles_Interface;
import com.revature.models.Ers_User_Roles;

//The service layer sits between the controller layer and the dao layer
//we never want the web access layer (the servlets and controllers) to touch the database access layer
//there are also time were we want to add more logic, like input validation, and the service is a great place for it
public class Ers_User_Roles_Service {

	//instantiate an Ers_User_Roles_DAO to use it's method
	private Ers_User_Roles_Interface Ers_User_Roles_DAO = new Ers_User_Roles_DAO();
	
	//create a method that sends the DAO data up to the controller (this method will be called by the controller)
	public List<Ers_User_Roles> getAllErs_User_Roles() {
		return Ers_User_Roles_DAO.getAllErs_User_Roles();
	}
	
	//literally all we're doing here is calling the method of the dao in order to get the List of Ers_User_Roles
	
}
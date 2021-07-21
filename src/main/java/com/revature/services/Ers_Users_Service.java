package com.revature.services;

import java.util.List;

import com.revature.daos.Ers_Users_DAO;
import com.revature.daos.Ers_Users_Interface;
import com.revature.models.Ers_Users;

public class Ers_Users_Service {

	//instantiate an Ers_Users_DAO to use it's method
	private Ers_Users_Interface Ers_Users_DAO = new Ers_Users_DAO();
	
	//create a method that sends the DAO data up to the controller (this method will be called by the controller)
	public List<Ers_Users> getAllErs_Users() {
		return Ers_Users_DAO.getAllErs_Users();
	}
	
	//literally all we're doing here is calling the method of the dao in order to get the List of Ers_User_Roles
}

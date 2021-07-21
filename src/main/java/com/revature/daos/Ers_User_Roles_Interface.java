package com.revature.daos;
import java.util.List;

import com.revature.models.Ers_User_Roles;

public interface Ers_User_Roles_Interface {

	public List<Ers_User_Roles> getAllErs_User_Roles(); //return a List of all Ers_User_Roles in the database
	
	//public Ers_User_Roles getErs_User_RolesById(int id); //take in an int, find the Ers_User_Roles with that id
}

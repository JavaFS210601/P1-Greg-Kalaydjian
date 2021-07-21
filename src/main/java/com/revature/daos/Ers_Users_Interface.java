package com.revature.daos;

import java.util.List;

import com.revature.models.Ers_Users;

public interface Ers_Users_Interface {
	public List<Ers_Users> getAllErs_Users(); //return all the Ers_Users from the database
	
	//public Ers_Users getErs_UsersById(int id); //take in an int, find the Ers_Users with that id
}

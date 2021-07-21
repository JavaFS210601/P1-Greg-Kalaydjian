package com.revature.services;
import java.util.List;
import com.revature.models.Ers_Users;
import com.revature.daos.Ers_Users_DAO;
public class EmployeeLoginService {

	public boolean login(String username, String password) 
	{
		boolean result = secureLogin(username, password);
		return result;
	}
	
	private boolean secureLogin(String username, String password)
	{
			//Creating Ers_Users List and checking the Username and Passwords.
			Ers_Users_DAO Ers_Users_DAO = new Ers_Users_DAO();
			List<Ers_Users> Ers_UsersList = Ers_Users_DAO.getAllErs_Users();
			int trueRoleID = 1;
			boolean result = false; //decline username/password combination by default
				
			for (Ers_Users c: Ers_UsersList)
			{
				String tempUser = c.getErs_username();
				String tempPass = c.getErs_password();
				int tempRoleID = c.getUser_role_id();
				if(username.equals(tempUser) && password.equals(tempPass) && tempRoleID == trueRoleID) 
				{
						result = true;
				}
			}
			return result;
	}
	
	
	/* Example:
	 * Login Functionality for PostMan: (POST @ http://localhost:8080/P1Demo/login)
	 * 	{
    	"username":"demoMan",
    	"password":"password"
		}
	 */

}
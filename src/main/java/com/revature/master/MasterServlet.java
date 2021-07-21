package com.revature.master;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.controllers.EmployeeLoginController;
import com.revature.controllers.Ers_User_Roles_Controller;
import com.revature.controllers.Ers_Reimbursement_Controller;
import com.revature.controllers.Ers_Reimbursement_Status_Controller;
import com.revature.controllers.Ers_Reimbursement_Type_Controller;
import com.revature.controllers.Ers_Users_Controller;
import com.revature.controllers.ManagementLoginController;


//remember, this is our front controller - ALL requests that come in will have to hit this first.
public class MasterServlet extends HttpServlet {

	//instantiate objects
	private Ers_User_Roles_Controller Ers_User_Roles_Controller = new Ers_User_Roles_Controller();
	private Ers_Reimbursement_Status_Controller Ers_Reimbursement_Status_Controller = new Ers_Reimbursement_Status_Controller();
	private Ers_Reimbursement_Type_Controller Ers_Reimbursement_Type_Controller = new Ers_Reimbursement_Type_Controller();
	private Ers_Users_Controller Ers_Users_Controller = new Ers_Users_Controller();
	private Ers_Reimbursement_Controller Ers_Reimbursement_Controller = new Ers_Reimbursement_Controller();
	private EmployeeLoginController EmployeeLoginController = new EmployeeLoginController();
	private ManagementLoginController ManagementLoginController = new ManagementLoginController();
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json"); //set the content of our response object to be JSON
		
		//by default, Tomcat will send back a successful status code (200) if a request gets handled.
		//since we have a master servlet that takes all requests, this means all requests will get hendled.
		//this can lead to problems - we don't want a 200 if the request isn't handled correctly
		//thus, by default, we'll set the status code to 404, and change it in our code upon success.
		res.setStatus(404);
		
		//Now we want to write some code that will determine where requests get sent.
		
		String URI = req.getRequestURI().replace("/P1-Greg-Kalaydjian/", "");
		//getting the request URI, and stripping out the base URL
		//so we'll just be left with the endpoint (e.g. "avengers", "login") to use in a switch
		
		switch(URI) {
		case "employeeLogin": 
			EmployeeLoginController.login(req, res);
			break;
			
		case "managementLogin":
			ManagementLoginController.login(req, res);
			break;
			
		case "getEmployeeReimbursements":
			Ers_Reimbursement_Controller.getEmployeeReimbursements(res);
			break;
			
		case "addErs_Reimbursement_Request":
			Ers_Reimbursement_Controller.addErs_Reimbursement_Request(req, res);
			break;
			/* 
			  Tomcat Test: (POST)
			  	{
		    	"reimb_type_id":"2",
		    	"reimb_amount":"100",
		        "reimb_description":"desc"
				}
			 */
			
		case "acceptDenyReimbursement":
			Ers_Reimbursement_Controller.acceptDenyReimbursement(req, res);
			break;
			
			//------------------TESTING CASES------------------
		case "ers1": //test case for ers_user_roles table
			Ers_User_Roles_Controller.getAllErs_User_Roles(res);
			break;
		case "ers2": //test case for ers_users table
			Ers_Users_Controller.getAllErs_Users(res);
			break;
		case "ers3": //test case for ers_reimbursement_status
			Ers_Reimbursement_Status_Controller.getAllErs_Reimbursement_Status(res);
			break;
		case "ers4": //test case for ers_reimbursement_type
			Ers_Reimbursement_Type_Controller.getAllErs_Reimbursement_Type(res);
			break;
		case "ers5": //test case for ers_reimbursement
			Ers_Reimbursement_Controller.getAllErs_Reimbursement(res);
			break;
		}
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
		//this sends every POST request to the doGet method, why???
		//I only want one switch statement in this Servlet. It can get very messy otherwise
		//and we'll differentiate get from post in the controllers instead of the servlet.
		
	}
	
}
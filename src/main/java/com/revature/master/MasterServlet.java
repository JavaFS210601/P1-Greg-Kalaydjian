package com.revature.master;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.controllers.LoginController;
import com.revature.controllers.Ers_User_Roles_Controller;

//import com.revature.controllers.AvengerController;


//remember, this is our front controller - ALL requests that come in will have to hit this first.
public class MasterServlet extends HttpServlet {

	//private AvengerController ac = new AvengerController();
	private Ers_User_Roles_Controller Ers_User_Roles_Controller = new Ers_User_Roles_Controller();
	private LoginController lc = new LoginController();
	
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
		
		case "ers1": //test case for ers_user_roles table
			Ers_User_Roles_Controller.getAllErs_User_Roles(res);
			break;
		case "ers2": //test case for ers_users table
			break;
		case "ers3": //test case for ers_reimbursement_status
			break;
		case "ers4": //test case for ers_reimbursement_type
			break;
		case "ers5": //test case for ers_reimbursement
	
		
		
		case "avengers": //adding functionality to make the user have to log in before accessing all avengers
		
			
			////if(req.getSession(false) != null) { //if there is an active Session (which means the user is logged in)
			//	ac.getAllAvengers(res); //doGet all avengers
			////} else {
			////	res.setStatus(403); //forbidden - they aren't logged in so they can't get the goods
				
			////}
			
			break;
			
		case "login": 
			
			lc.login(req, res);
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
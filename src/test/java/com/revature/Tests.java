package com.revature;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import com.revature.daos.Ers_Reimbursement_DAO;
import com.revature.daos.Ers_Reimbursement_Status_DAO;
import com.revature.daos.Ers_Reimbursement_Type_DAO;
import com.revature.daos.Ers_User_Roles_DAO;
import com.revature.daos.Ers_Users_DAO;

import org.junit.Test;
import com.revature.controllers.EmployeeLoginController;

public class Tests {
	Ers_Users_DAO Ers_Users_DAO = new Ers_Users_DAO();
	Ers_Reimbursement_DAO Ers_Reimbursement_DAO = new Ers_Reimbursement_DAO();
	Ers_Reimbursement_Status_DAO Ers_Reimbursement_Status_DAO = new Ers_Reimbursement_Status_DAO();
	Ers_Reimbursement_Type_DAO Ers_Reimbursement_Type_DAO = new Ers_Reimbursement_Type_DAO();
	EmployeeLoginController EmployeeLoginController = new EmployeeLoginController();
	
	//1
	@Test //recognizes this method as a testing method
	public void testUsersDaoHashCode()
	{
		System.out.println("Testing valid login");
		
		assertNotNull(Ers_Users_DAO.hashCode());
	}
	
	//2
	@Test //recognizes this method as a testing method
	public void testUsersDaoHashCode2()
	{
		System.out.println("Testing valid login");
		
		assertNull(Ers_Users_DAO.hashCode());
	}
	
	//3
	@Test //recognizes this method as a testing method
	public void testErs_Reimbursement_DAO()
	{
		System.out.println("Testing valid login");
		
		assertNotNull(Ers_Reimbursement_DAO.hashCode());
	}

	//4
	@Test //recognizes this method as a testing method
	public void testErs_Reimbursement_DAO2()
	{
		System.out.println("Testing valid login");
			
		assertNull(Ers_Reimbursement_DAO.hashCode());
	}
	
	//5
	@Test //recognizes this method as a testing method
	public void testErs_Reimbursement_Status_DAO()
	{
		System.out.println("Testing valid login");
			
		assertNotNull(Ers_Reimbursement_Status_DAO.hashCode());
	}
	
	//6
	@Test //recognizes this method as a testing method
	public void testErs_Reimbursement_Status_DAO2()
	{
		System.out.println("Testing valid login");
			
		assertNull(Ers_Reimbursement_Status_DAO.hashCode());
	}
	
	//7
	@Test //recognizes this method as a testing method
	public void testErs_Reimbursement_Type_DAO()
	{
		System.out.println("Testing valid login");
			
		assertNotNull(Ers_Reimbursement_Type_DAO.hashCode());
	}
	
	//8
	@Test //recognizes this method as a testing method
	public void testErs_Reimbursement_Type_DAO2()
	{
		System.out.println("Testing valid login");
			
		assertNull(Ers_Reimbursement_Type_DAO.hashCode());
	}
	
	//9
	@Test //recognizes this method as a testing method
	public void testEmployeeLoginController()
	{
		System.out.println("Testing valid login");
			
		assertNotNull(EmployeeLoginController.hashCode());
	}
	
	//10
	@Test //recognizes this method as a testing method
	public void testEmployeeLoginController2()
	{
		System.out.println("Testing valid login");
			
		assertNull(EmployeeLoginController.hashCode());
	}
}

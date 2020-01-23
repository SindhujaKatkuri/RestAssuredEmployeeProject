/* This test case contains Base Information that is used for all the test caes */

package com.EmployeeAPI.Base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "21"; //Hard coded - Input for GET details of Single Employee and Update Employee
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
		logger = Logger.getLogger("EmployeesRestAPI"); //added Logger
		PropertyConfigurator.configure("Log4j.properties"); //added Logger
		logger.setLevel(Level.DEBUG);
		
	}

}

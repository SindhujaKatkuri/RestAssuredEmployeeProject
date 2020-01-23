package com.EmployeeAPI.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	//Random Generator to create Employee Names
	public static String empName() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return("Sindhuja"+generatedString);
		
	}

	//Random Generator to create Employee Salary - 5 digit
	public static String empSal() {
		
		String generatedString = RandomStringUtils.randomNumeric(5);
		return(generatedString);
		
	}
	
	//Random Generator to create Employee Age - 2 digit
	public static String empAge() {
		
		String generatedString = RandomStringUtils.randomNumeric(2);
		return(generatedString);
		
	}
	
}

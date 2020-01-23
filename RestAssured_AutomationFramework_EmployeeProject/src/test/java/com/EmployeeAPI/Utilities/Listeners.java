package com.EmployeeAPI.Utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext) {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport.html"); //Specify location of the folder where reports are generated
		
		htmlReporter.config().setDocumentTitle("Automation Report"); //Title of report
		htmlReporter.config().setReportName("Rest API Testing Report"); //Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project name", "Employee Database API");
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Sindhu");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); //Create new entry in the report
		
		test.log(Status.PASS, "Passed Test Case is" +result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName()); //Create new entry in the report
		
		test.log(Status.FAIL, "Failed Test Case is" +result.getName()); //to add name in the extent report
		test.log(Status.FAIL, "Failed Test Case is" +result.getThrowable()); //to add error/exception in the extent report
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getName()); //Create new entry in the report
		
		test.log(Status.SKIP, "Skipped Test Case is" +result.getName());
		
	}
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
	}

}

package com.EmployeeAPI.TestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EmployeeAPI.Base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC05_DELETE_EmployeeRecord extends TestBase{
	
	@BeforeClass
	void deleteEmployee() throws InterruptedException{
		
		logger.info("********** Started TC05_DELETE_EmployeeRecord **********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "/employees");
		
		//Get the JsonPath object instance from Response
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		//Capture ID
		String empID = jsonPathEvaluator.get("[0].id");
		response = httpRequest.request(Method.DELETE, "/delete/"+empID); 
		
		Thread.sleep(5000);
		
	}
	
	@Test
	void checkResponseBody() {
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body:" +responseBody);
		Assert.assertEquals(responseBody.contains("Successfully deleted the record"), true);
		
	}
	
	@Test
	void checkStatusCode() {
		
		logger.info("********** Checking Status Code **********");
		
		int statusCode = response.getStatusCode();
		logger.info("Status Code:" +statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	void checkResponseTime() {
		
		logger.info("********** Checking Response Time **********");
		
		long responseTime = response.getTime();
		logger.info("Response Time:" +responseTime);
		
		if(responseTime > 6000)
			logger.warn("Response Time is greater than 6000");
		
		Assert.assertTrue(responseTime < 6000);
		
	}
	
	@Test
	void checkStatusLine() {
		
		logger.info("********** Checking Status Line **********");
		
		String statusLine = response.getStatusLine();
		logger.info("Status Line:" +statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	void checkContentType() {
		
		logger.info("********** Checking Content Type **********");
		
		String contentType = response.header("Content-Type");
		logger.info("Content Type:" +contentType);
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
		
	}
	
	@Test
	void checkServerType() {
		
		logger.info("********** Checking Server Type **********");
		
		String serverType = response.header("Server");
		logger.info("Server Type:" +serverType);
		Assert.assertEquals(serverType, "nginx/1.16.0");
		
	}	
	
	@Test
	void checkContentEncoding() {
		
		logger.info("********** Checking Content Encoding **********");
		
		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding:" +contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
	}	
	
	@Test
	void checkContentLength() {
		
		logger.info("********** Checking Content Length **********");
		
		String contentLength = response.header("Content-Length");
		logger.info("Content Length:" +contentLength);
		
		if(Integer.parseInt(contentLength) > 1500)
			logger.warn("Content Length is greater than 1500");
		
		Assert.assertTrue(Integer.parseInt(contentLength) < 1500);
		
	}
	
	@Test
	void checkCookies(){
		
		logger.info("********** Checking Cookies **********");
		
		String cookie = response.getCookie("PHPSESSID");
		
	}
	
	@AfterClass
	void tearDown() {
		
		logger.info("********** Finished TC05_DELETE_EmployeeRecord **********");
		
	}


}

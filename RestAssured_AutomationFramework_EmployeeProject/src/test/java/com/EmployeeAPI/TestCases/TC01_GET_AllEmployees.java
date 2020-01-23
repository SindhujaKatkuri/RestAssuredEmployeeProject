package com.EmployeeAPI.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.*;

import com.EmployeeAPI.Base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC01_GET_AllEmployees extends TestBase{
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException{
		
		logger.info("********** Started TC01_GET_AllEmployees **********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		
		Thread.sleep(3000);
	
	}
	
	@Test
	void checkResponseBody() {
		
		logger.info("********** Checking Response Body **********");
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body:" +responseBody);
		Assert.assertTrue(responseBody!=null);
		
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
		
		if(responseTime > 2000)
			logger.warn("Response Time is greater than 2000");
		
		Assert.assertTrue(responseTime < 2000);
		
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
		
		if(Integer.parseInt(contentLength) < 100)
			logger.warn("Content Length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentLength) > 100);
		
	}
	
	@Test
	void checkCookies(){
		
		logger.info("********** Checking Cookies **********");
		
		String cookie = response.getCookie("PHPSESSID");
		
	}
	
	@AfterClass
	void tearDown() {
		
		logger.info("********** Finished TC01_GET_AllEmployees **********");
		
	}
	
	
}

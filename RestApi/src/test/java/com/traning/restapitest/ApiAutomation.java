package com.traning.restapitest;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiAutomation {
	
	String sHostUrl = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	String sEPLogin = "/login";
	String sEPData = "/getdata";
	String sURI= "";
	String sToken;
	Response response;
	
	@Test
	public void validatelogin() {
		sURI = sHostUrl+sEPLogin;
	  RestAssured.baseURI = sURI;
	  Response response = RestAssured.given().body("{\r\n"
	  		+ "    \"username\": \"mithun@ta.com\",\r\n"
	  		+ "    \"password\": \"mithun\"\r\n"
	  		+ "}").when().contentType("application/json").post();
	  
		/*
		 * System.out.println(response.getStatusCode());
		 * System.out.println(response.asPrettyString()); response.prettyPrint();
		 */
	  sToken= response.jsonPath().get("token[0]");
	  System.out.println(sToken);
	  
	  sURI = sHostUrl+sEPData;
	RestAssured.baseURI=sURI;
	HashMap<String, String> headData = new HashMap();
	headData.put("token", sToken);
	response = RestAssured.given().headers(headData).when().contentType("application/json").get();
	//response.prettyPrint();
	List<String> listId = response.jsonPath().getList("id");
	System.out.println(listId.size());
	
	for (String s :listId) {
		if(s.equals("mvDZum3NVLiM6UymYlfK")) {
			System.out.println("id is Present"+s);
		}
	}
	
	}
	

}

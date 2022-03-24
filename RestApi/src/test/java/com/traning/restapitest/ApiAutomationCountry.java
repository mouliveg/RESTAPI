package com.traning.restapitest;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiAutomationCountry {
	
	String sHostUrl = "https://restcountries.com/v3.1/";
	String sEPLogin = "all";
	String sURI= "";
	
	@Test
	public void validatelogin() {
		sURI = sHostUrl+sEPLogin;
	  RestAssured.baseURI = sURI;
	  Response reponse = RestAssured.given().when().get();
	  
		/*
		 * System.out.println(reponse.getStatusCode());
		 * System.out.println(reponse.asPrettyString()); reponse.prettyPrint();
		 */
	 List<String> countryName = reponse.jsonPath().getList("name.common");
	  System.out.println(countryName.size());
		
	}
	

}

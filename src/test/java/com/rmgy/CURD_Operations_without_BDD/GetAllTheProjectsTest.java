package com.rmgy.CURD_Operations_without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllTheProjectsTest 
{
	@Test
	public void getAllProjects()
	{
		Response rsps = RestAssured.get("http://localhost:8084/projects");
		System.out.println(rsps.prettyPrint());
		System.out.println(rsps.asString());
		
		 ValidatableResponse vrsps = rsps.then();
		 vrsps.assertThat().statusCode(200);
		 vrsps.assertThat().contentType("application/json");
		 vrsps.log().all();
	}

}

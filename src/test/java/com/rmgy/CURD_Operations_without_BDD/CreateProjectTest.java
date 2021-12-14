package com.rmgy.CURD_Operations_without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest 
{
	@Test
	public void create()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Abhishek");
		jobj.put("projectName", "TYSS-333");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 33);
		RequestSpecification reqspe = RestAssured.given();
		reqspe.contentType(ContentType.JSON);
		reqspe.body(jobj);
		Response rsps = reqspe.post("http://localhost:8084/addProject");
		ValidatableResponse vrsps = rsps.then();
		vrsps.assertThat().and().statusCode(201);
		vrsps.log().all();
	}

}

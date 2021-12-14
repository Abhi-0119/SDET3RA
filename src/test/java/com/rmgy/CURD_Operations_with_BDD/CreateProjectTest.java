package com.rmgy.CURD_Operations_with_BDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectTest 
{
	@Test
	public void create()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Abhishek3");
		jobj.put("projectName", "TYSS-3333");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 333);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}

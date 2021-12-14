package com.rmgy.Diff_Ways_to_Create_Project;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingHashMapTest 
{
	
	@Test
	public void createProject() 
	{
		HashMap hp = new HashMap();
		hp.put("createdBy", "Abhi3");
		hp.put("projectName", "SSS-3");
		hp.put("status", "On Going");
		hp.put("teamSize", 3);
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}

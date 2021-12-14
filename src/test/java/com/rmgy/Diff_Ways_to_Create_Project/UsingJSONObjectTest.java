package com.rmgy.Diff_Ways_to_Create_Project;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingJSONObjectTest 
{
	@Test
	public void create()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Abhi3");
		jobj.put("projectName", "qwerty33");
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

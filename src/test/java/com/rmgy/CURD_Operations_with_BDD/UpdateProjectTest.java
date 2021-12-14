package com.rmgy.CURD_Operations_with_BDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest 
{
	@Test
	public void update()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Abhishek33");
		jobj.put("projectName", "TYSS-33");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 3);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1002")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}

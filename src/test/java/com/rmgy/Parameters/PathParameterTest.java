package com.rmgy.Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PathParameterTest 
{
	@Test
	public void pathParameter()
	{
		given()
		.contentType(ContentType.JSON)
		.pathParam("PId", "TY_PROJ_1205")
		.when().get("http://localhost:8084/projects/{PId}")
		.then()
		.log().all();
	}

}

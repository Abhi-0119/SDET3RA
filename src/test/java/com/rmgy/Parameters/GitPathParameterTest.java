package com.rmgy.Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GitPathParameterTest
{
	@Test
	public void gitPathParam()
	{
		given()
		.contentType(ContentType.JSON)
		.pathParam("username", "Abhi-0119")
		.queryParam("sort", "created")
		.when().get("https://api.github.com/users/{username}/repos")
		.then()
		.log().all();
	}
	
	

}

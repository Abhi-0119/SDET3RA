package com.rmgy.Request_Chaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Get_DeleteTest 
{
	@Test
	public void getDelete()
	{
		Response rsp = given().get("http://localhost:8084/projects");
		String data = rsp.jsonPath().get("[1].projectId");
		System.out.println(data);
		
		given()
		.pathParam("PId", data)
		.when().delete("http://localhost:8084/projects/{PId}")
		.then()
		.contentType(ContentType.JSON)
		.assertThat()
		.statusCode(204)
		.log().all();
	}

}

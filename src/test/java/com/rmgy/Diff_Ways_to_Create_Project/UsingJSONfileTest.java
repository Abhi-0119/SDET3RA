package com.rmgy.Diff_Ways_to_Create_Project;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingJSONfileTest 
{
	@Test
	public void createProject()
	{
		File file = new File("./data.json");
		given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}

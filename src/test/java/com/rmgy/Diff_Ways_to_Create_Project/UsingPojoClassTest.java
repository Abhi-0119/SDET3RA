package com.rmgy.Diff_Ways_to_Create_Project;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.rmgy.Project_Library.PojoLibrary;

import io.restassured.http.ContentType;

public class UsingPojoClassTest 
{
	@Test
	public void createProject()
	{
		Random r = new Random();
		int rnum = r.nextInt(2000);
		PojoLibrary pl = new PojoLibrary("Abhi", "Wiki"+rnum, "Created", 12);
		given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}

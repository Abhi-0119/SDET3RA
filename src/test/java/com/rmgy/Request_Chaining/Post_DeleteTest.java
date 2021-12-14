package com.rmgy.Request_Chaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.rmgy.Project_Library.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post_DeleteTest 
{
	@Test
	public void postDelete()
	{
		Random r = new Random();
		int rnum = r.nextInt(2000);
		PojoLibrary pl = new PojoLibrary("Abhi", "Wiki"+rnum, "Created", 12);
		Response rsp = given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when().post("http://localhost:8084/addProject");
		String data = rsp.jsonPath().get("projectId");
		System.out.println(data);
		
		given()
		.pathParam("PId", data)
		.when().delete("http://localhost:8084/projects/{PId}")
		.then()
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
	}

}

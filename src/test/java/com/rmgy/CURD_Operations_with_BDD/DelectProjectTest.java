package com.rmgy.CURD_Operations_with_BDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DelectProjectTest 
{
	@Test
	public void delete()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1002")
		.then()
		.assertThat()
		.statusCode(204)
		.and()
		.contentType(ContentType.JSON)
		.log().all();
	}

}

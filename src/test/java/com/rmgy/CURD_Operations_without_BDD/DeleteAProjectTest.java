package com.rmgy.CURD_Operations_without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteAProjectTest 
{
	@Test
	public void deleteaproject()
	{
		Response rsps = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_627");
		 ValidatableResponse vrsps = rsps.then();
		 vrsps.assertThat().statusCode(204);
	}

}


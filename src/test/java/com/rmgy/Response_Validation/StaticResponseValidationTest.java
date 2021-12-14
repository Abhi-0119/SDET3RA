package com.rmgy.Response_Validation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponseValidationTest 
{
	@Test
	public void staticResponse()
	{
		String edata = "ABHI_3";
		Response rsp = when().get("http://localhost:8084/projects");
		rsp.then().assertThat().statusCode(200);
		
		String adata = rsp.jsonPath().get("[0].projectName");
		System.out.println(adata);
		Assert.assertEquals(adata, edata);
		
	}

}

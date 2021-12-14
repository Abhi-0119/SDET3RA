package com.rmgy.Response_Validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidationTest 
{
	@Test
	public void dynamicResponse()
	{
		String edata = "qwerty33";
		Response rsp = when().get("http://localhost:8084/projects");
		rsp.then().assertThat().statusCode(200);
		
		List<String> ldata = rsp.jsonPath().get("projectName");
		for(String adata:ldata)
		{
			if(adata.equals(edata))
			{
				System.out.println(adata+"  is Present");
				break;
			}
		}
	}

}

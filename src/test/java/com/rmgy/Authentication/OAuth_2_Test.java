package com.rmgy.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth_2_Test 
{
	@Test
	public void oAuth()
	{
		
		Response rsp = given()
				.formParam("client_id", "appsample")
				.formParam("client_secret", "58ed1dd7b3f855c771d2f5ca6a2cb710")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri ", "https://example.com")
				.when().post("http://coop.apps.symfonycasts.com/token");
		System.out.println(rsp.prettyPrint());
		String token = rsp.jsonPath().get("access_token");
		
		given().auth().oauth2(token)
		.pathParam("USER_ID", "2532")
		.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then().log().all();
	}

}

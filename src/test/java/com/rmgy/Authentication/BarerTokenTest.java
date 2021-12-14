package com.rmgy.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarerTokenTest
{
	@Test
	public void barerToken()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then().log().all();
	}

}

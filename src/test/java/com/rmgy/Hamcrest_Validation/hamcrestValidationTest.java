package com.rmgy.Hamcrest_Validation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class hamcrestValidationTest 
{
	@Test
	public void hamcrest()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
		.assertThat().body("[0].projectName", Matchers.equalTo("ABHI_3"))
		.log().all();
	}

}

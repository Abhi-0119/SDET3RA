package com.rmgy.Diff_Ways_to_Create_Project;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgy.Project_Library.PojoLibrary;

import io.restassured.http.ContentType;

public class UsingDataProviderTest 
{
	@Test(dataProvider = "provideData")
	public void createProject(String createdBy,String projectname,String status,int teamSize)
	{
		Random r = new Random();
		int rnum = r.nextInt(2000);
		PojoLibrary pl = new PojoLibrary(createdBy, projectname+rnum, status, teamSize);
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
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] objarr = new Object[3][4];
		objarr[0][0] = "rana";
		objarr[0][1] = "rana";
		objarr[0][2] = "On Going";
		objarr[0][3] = 12;
		
		objarr[1][0] = "ranaP";
		objarr[1][1] = "rana";
		objarr[1][2] = "Completed";
		objarr[1][3] = 12;
		
		objarr[2][0] = "ranaPratap";
		objarr[2][1] = "rana";
		objarr[2][2] = "On Going";
		objarr[2][3] = 12;
		return objarr;
	}

}

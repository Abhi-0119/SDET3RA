package com.rmgy.End_To_End;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.rmgy.GenericUtil.BaseClass;
import com.rmgy.GenericUtil.EndPoints;
import com.rmgy.Project_Library.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class endToEndPost_GetTest extends BaseClass implements EndPoints
{
	@Test
	public void endToend() throws SQLException
	{
		baseURI = "http://localhost";
		port = 8084;
		
		PojoLibrary pl = new PojoLibrary("Abhi", "Wiki"+jutil.rmdNum(), "Created", 12);
		Response rsp = given()
				.contentType(ContentType.JSON)
				.body(pl)
				.when().post(EndPoints.createProj);
		String data = json.pathFinder("projectId", rsp);
		System.out.println(data);

		given()
		.pathParam("PId", data)
		.when().get(EndPoints.getAllProj+"/{PId}");
		String adata = json.pathFinder("projectName", rsp);
		System.out.println(adata);

		ResultSet result = db.executeQuery("select * from project");
		while(result.next())
		{
			Object pres = result.getObject("project_Id");
			if(pres.equals(data))
			{
				System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3)+"  "+result.getString(4));
			}
		}
	}



}

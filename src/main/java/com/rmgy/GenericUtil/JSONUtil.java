package com.rmgy.GenericUtil;

import io.restassured.response.Response;

public class JSONUtil 
{
	public String pathFinder(String path,Response rsp)
	{
		String data = rsp.jsonPath().get(path);
		return data;
	}

}

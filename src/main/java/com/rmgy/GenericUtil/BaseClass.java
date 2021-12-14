package com.rmgy.GenericUtil;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass
{
	public DataBaseUtil db = new DataBaseUtil();
	public JavaUtil jutil = new JavaUtil();
	public JSONUtil json = new JSONUtil();
	
	@BeforeSuite
	public void dbconnect()
	{
		db.connectToDB();
	}
	
	@AfterSuite
	public void dbclose()
	{
		db.closeDBConnection();
	}

}

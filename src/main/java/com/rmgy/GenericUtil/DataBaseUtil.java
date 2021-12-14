package com.rmgy.GenericUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtil
{
	Connection con = null;
	ResultSet result;

	/**
	 * this method is used to establish DB connection 
	 */
	public void connectToDB()
	{
		try
		{
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			System.out.println("Connected to DataBase");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

	/**
	 * this method is used to close the DB connection 
	 */
	public void closeDBConnection()
	{
		try
		{
			con.close();
			System.out.println("DataBase Connection closed Sucessfully");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}

	/**
	 * This method is used to execute the SQL query to retrieve the data from DB
	 * @param query
	 * @return 
	 * @throws SQLException 
	 */
	public ResultSet executeQuery(String query) throws SQLException
	{

		result = con.createStatement().executeQuery(query);
		return result;

	}

}

package com.airline.operations;

import java.sql.Connection;

import com.airline.dbconnect.DBConnection;

public class AirlineOperations {

	public static void main(String[] args) {
		
		Connection conn=DBConnection.connect();
		if(conn!=null)
		{
			System.out.println("Connection successfull!!");
		}

	}

}

package com.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import org.testng.annotations.Test;

public class JdbcConnectivity {


	public static void main (String[] args) throws SQLException{
		String result = null;

		//STEP 1 - Establish connection
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDatabase", "sample", "1234");
		Statement createStatement = connection.createStatement()){

			ResultSet executeQuery = createStatement.executeQuery("select * from jdbc_connectivity;");
			int column = 1;
			while (executeQuery.next()) {
				int row = executeQuery.getRow();
				System.out.println(row);
				result = executeQuery.getString("name");
				System.out.println(result);
			}
		}

		


	}

}

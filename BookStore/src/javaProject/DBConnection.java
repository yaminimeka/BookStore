package javaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBConnection {
	
	
	public  Connection getConnection() throws Exception {
		// TODO Auto-generated method stub
		

		Class.forName("oracle.jdbc.driver.OracleDriver");//Oracle
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","loginsystem",
					"password");
		return con;

	}
	

	
		
	}



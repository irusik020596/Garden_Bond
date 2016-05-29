package org.irina.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataConnect{
	 private static Connection conn = null;

	public static Connection getConnection() {
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cardb", "pankaj", "pankaj123");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}*/
		if(conn == null)
		{
			try {
		        Class.forName("org.postgresql.Driver");
			    Properties props = new Properties();
			    props.setProperty("user","postgres");
			    props.setProperty("password","gfhjkm");
			    props.setProperty("charSet","WIN1251");
		        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/plants?prepareThreshold=0", props);
	            
			}
			catch (Exception ex) {
				System.out.println("Database.getConnection() Error -->"
						+ ex.getMessage());
				//return null;
			}
			
		}
		return conn;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
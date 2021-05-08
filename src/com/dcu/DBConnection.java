package com.dcu;

import java.sql.*;
import oracle.jdbc.driver.*;


public class DBConnection {
	
	private static String JDBCUrl = "jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
	private static String username = "ee_user";
	private static String password = "ee_pass";
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static Connection con = null;
	
	public static Statement open() throws SQLException{
		try {
			System.out.println("\nConnecting to the SSD Database......");
            Class.forName(driverName);
            con = DriverManager.getConnection(JDBCUrl, username, password);
            Statement stmt = con.createStatement();
            return stmt;
		}
		catch (Exception e) {
            System.out.println("\nAn error has occurred during the connection phase!  "
            		+ "This is most likely due to your CLASSPATH being set wrong and the"
                    + " Oracle classes unable to be found.  Otherwise the database itself may be down.  "
                    + "Try telneting to port 1521 and see if it is up!");
            e.printStackTrace();
            System.exit(0);
        } 
		return null;
	}
	
	
	public static void close() {
		try {    
	         if (con != null) 
	        	 con.close();
	         	 System.out.println("\n.........Closing Connection to SSD DataBase");
	    }
	    catch (Exception ex) {
	         System.out.println("An error occurred while closing down connection/statement"); 
        }	
	}
	
	
  
}
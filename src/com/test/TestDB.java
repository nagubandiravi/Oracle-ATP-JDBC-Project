package com.test;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class TestDB {
	
	final static String DB_URL="jdbc:oracle:thin:@db2022rnaguban_high";
    final static String DB_USER = "ADMINUSER";
    final static String DB_PASSWORD = "Nagubandi1982$";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.setProperty("oracle.net.tns_admin","D:\\Oracle-Cloud-Repo\\network\\admin");
        System.setProperty("oracle.jdbc.fanEnabled","false");

        Class.forName("oracle.jdbc.driver.OracleDriver");
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(DB_URL);
        ods.setUser(DB_USER);
        ods.setPassword(DB_PASSWORD);

        try (OracleConnection connection = (OracleConnection) ods.getConnection();
        		Statement st = connection.createStatement()) {

           DatabaseMetaData dbmd = connection.getMetaData();
           System.out.println("Driver Name: " + dbmd.getDriverName());
           System.out.println("Driver Version: " + dbmd.getDriverVersion());
           System.out.println("Database Username is: " + connection.getUserName());
       }
	}

}

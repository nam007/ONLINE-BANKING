package com;
import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConnection {
		private static DBConnection instance =new DBConnection();
		public static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
		public static final String USER="namrata";
		public static final String PASSWORD="namrata";
		public static final String DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
		private DBConnection(){
			try{	
				Class.forName(DRIVER_CLASS);
				System.out.print("found class");
					} catch(ClassNotFoundException e){
						System.out.print("not found class");
							e.printStackTrace();
						}
		}
		private Connection createConnection(){
			Connection conn=null;
			try{
				conn=DriverManager.getConnection(URL,USER,PASSWORD);
				System.out.print("got it");
			} catch(SQLException e){
				e.printStackTrace();
				System.out.print("Unable to connect");
			}
			return conn;
		}
		public static Connection getConnection(){
			return instance.createConnection();
		}
	
}

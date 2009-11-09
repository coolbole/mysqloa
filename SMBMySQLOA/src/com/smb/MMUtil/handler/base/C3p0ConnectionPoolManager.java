package com.smb.MMUtil.handler.base;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

 
public class C3p0ConnectionPoolManager {
	
 		private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		public   Connection getConnection() throws Exception   {
			Class.forName("com.mysql.jdbc.Driver" );    
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","123456");  
			return connection;
		}
		
		
		public static  DataSource getC3p0DataSource()   { 
			try {		
				dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1/test");
				dataSource.setUser("root");
				dataSource.setPassword("123456");
				dataSource.setDriverClass(  "com.mysql.jdbc.Driver"  );
				dataSource.setInitialPoolSize(10);
				
				dataSource.setMaxPoolSize(10);
 				dataSource.setMaxIdleTime(180); 
		 
				return dataSource; 		} 
			catch (Exception e) { e.printStackTrace();		return null;			}
			}

	}
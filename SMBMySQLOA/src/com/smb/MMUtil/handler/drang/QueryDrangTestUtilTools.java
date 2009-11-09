package com.smb.MMUtil.handler.drang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.base.C3p0ConnectionPoolManager;

public class QueryDrangTestUtilTools extends Thread {
	
	  
	private static Log logger = LogFactory.getLog(QueryDrangTestUtilTools.class);
	private static DataSource dataSource =C3p0ConnectionPoolManager.getC3p0DataSource();
	public void run  () {
		try {
			logger.info("\n"+getName() + " 线程运行开始!");
			Connection connection =dataSource.getConnection();
			
//			Class.forName("com.mysql.jdbc.Driver" );    
//			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","123456");  
			
 			PreparedStatement smt=connection.prepareStatement( "INSERT INTO users (name) VALUES (11111)" );
//			PreparedStatement smt=connection.prepareCall("call fff");
			
 			smt.execute()   ;
 			connection.close();
			
		} 
		catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
	}
	
	
	
}

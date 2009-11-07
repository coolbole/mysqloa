package com.smb.MMUtil.testcase;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class JDBCTestCase {
		
		@Test
		public void createPROCEDURE() throws Exception{
			 Connection connection = null;
			 
			String pSQL=
				/**   查询数据的脚本 */
				"CREATE DEFINER=`root`@`localhost` PROCEDURE `pl`()	select id,level from crm_users order by id-level desc;";
			
			/**   插入5w条数据的脚本
			CREATE DEFINER=`root`@`localhost` PROCEDURE `fff`()
			BEGIN
			DECLARE v INT;
			SET v = 1;
			WHILE v < 50000 DO
			INSERT INTO users (name) VALUES ('v');
			SET v = v + 1;
			END WHILE;
			END;
			*/
			
			Class.forName("com.mysql.jdbc.Driver" );    
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","123456");  
			
			connection.createStatement().execute( pSQL );
			
		}
		
//		CREATE DEFINER=`root`@`localhost` PROCEDURE `pl`()
//		select id,level from crm_users order by id-level desc;
}

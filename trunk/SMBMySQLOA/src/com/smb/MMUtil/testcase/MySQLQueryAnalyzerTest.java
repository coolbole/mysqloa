package com.smb.MMUtil.testcase;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Test;

import com.smb.MMUtil.queryAnalyzer.MySQLQueryAnalyzer;
import com.smb.MMUtil.queryAnalyzer.QueryAnalyzerFactory;
import com.smb.MMUtil.handler.base.UtilBaseTools;

public class MySQLQueryAnalyzerTest {
	
	private String SQL3="UPDATE customer_businesshistory SET customertype=9 WHERE  id=25 ; UPDATE customer_businesshistory SET customertype=33 WHERE  id=24 ; ";
	private String SQL2="UPDATE customer_businesshistory SET customertype=61 WHERE  id=25   ";
	private String SQL1="Select * from customer_businesshistory";
	private String SQL="Select password,username,id ,email,ROLE from crm_users";
	@Test
	public void runCase () throws SQLException{
		
		UtilBaseTools  orm= new UtilBaseTools("192.168.12.78", "smbcrm", "root", "123456");
		QueryAnalyzerFactory  MQA= new QueryAnalyzerFactory(orm);
		Map map=MQA.execResult( SQL1 );
		 java.util.Iterator  iter=map.keySet().iterator();
		 while (iter.hasNext() ){
			 System.out.println ( iter.next()  );
		 }
	}

}

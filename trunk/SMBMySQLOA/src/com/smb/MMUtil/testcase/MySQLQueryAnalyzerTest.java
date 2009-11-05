package com.smb.MMUtil.testcase;


import org.junit.Test;


import com.smb.MMUtil.tools.UtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;

public class MySQLQueryAnalyzerTest {
	
//	private String SQL3="UPDATE customer_businesshistory SET customertype=9 WHERE  id=25 ; UPDATE customer_businesshistory SET customertype=33 WHERE  id=24 ; ";
//	private String SQL2="UPDATE customer_businesshistory SET customertype=61 WHERE  id=25   ";
//	private String SQL1="Select * from customer_businesshistory";
//	private String SQL="Select password,username,id ,email,ROLE from crm_users";
	
	@Test
	  public void bin2hex( ) {
			String bin="c:\\boot.ini";
			
	        System.out.println  (UtilTools.getBASE64(bin) );
	    } 
 
	//@Test
	public void runCase () throws  Exception{
		
		UtilBaseTools  orm= new UtilBaseTools("192.168.12.78", "smbcrm", "root", "123456");
		MySQLManagerJdbcUtilTools  mmu= new MySQLManagerJdbcUtilTools(orm);
		String list=mmu.showCreateTable("crm_users") ;
		System.out.println  (list);
		
		
	}

}

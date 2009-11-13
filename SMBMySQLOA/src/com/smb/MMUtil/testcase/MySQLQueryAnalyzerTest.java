package com.smb.MMUtil.testcase;


import java.util.List;

import org.junit.Test;


import com.smb.MMUtil.pojo.MySQLDeepOptimize;
import com.smb.MMUtil.tools.UtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.JDBCUtilBaseTools;
import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;

public class MySQLQueryAnalyzerTest {
	
//	private String SQL3="UPDATE customer_businesshistory SET customertype=9 WHERE  id=25 ; UPDATE customer_businesshistory SET customertype=33 WHERE  id=24 ; ";
//	private String SQL2="UPDATE customer_businesshistory SET customertype=61 WHERE  id=25   ";
//	private String SQL1="Select * from customer_businesshistory";
//	private String SQL="Select password,username,id ,email,ROLE from crm_users";
	
	//@Test
	  public void bin2hex( ) {
			String bin="c:\\boot.ini";
			
	        System.out.println  (UtilTools.getBASE64(bin) );
	    } 
 
	@SuppressWarnings("unchecked")
	@Test
	public void runCase () throws  Exception{
		
		JDBCUtilBaseTools  orm= new JDBCUtilBaseTools("127.0.0.1", null, "root", "123456");
		MySQLManagerJdbcUtilTools  mmu= new MySQLManagerJdbcUtilTools(orm);
		 
		ReadMySQLConfigXMLFile  xml = new ReadMySQLConfigXMLFile();
		List <MySQLDeepOptimize> list=xml.getMySQLDeepOptimizeCase();
		
		/**     ==============================================      **/
		StringBuffer sBuffer = new StringBuffer();
			for (int i=0;i<list.size();i++){
				sBuffer.append( list.get(i).getExecuteCommand()  );
			}
		
			String stringsBuffer=sBuffer.toString().replaceAll("\n", "").replaceAll("\t", "") ;
			stringsBuffer=stringsBuffer.substring(0, stringsBuffer.length()-1); 
			System.out.println ( stringsBuffer );
			
			mmu.setVariblesByCommands(stringsBuffer);
			
	}

}

package com.smb.MMUtil.action.base;

import javax.servlet.http.HttpSession;

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.JDBCUtilBaseTools;
import com.smb.MMUtil.handler.flashchart.FlashChartTools;
import com.smb.MMUtil.handler.portlet.PortletService;
import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;

public class ActionBase {
	
	protected static ReadMySQLConfigXMLFile  DescriptionXMLFile= new ReadMySQLConfigXMLFile();
	
	protected static FlashChartTools  fashChartTools= new FlashChartTools();
	
	protected  IMySQLManagerJdbcUtilTools getMMU ( String host, String Db,String username, String password ){
		JDBCUtilBaseTools orm= new JDBCUtilBaseTools(host,Db,username,password);
	    IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		return mmu;
	}
	
	   
	protected  PortletService getPortletMMU (HttpSession session ) throws Exception{
		  	String host=session.getAttribute("host").toString() ;
		    String username=session.getAttribute("username").toString();
		    String password=session.getAttribute("password").toString();
			JDBCUtilBaseTools orm= new JDBCUtilBaseTools(host,null,username,password);
			PortletService   mmu= new PortletService(orm);
		return mmu;
	}
	
	protected  IMySQLManagerJdbcUtilTools getMMU (HttpSession session,String DBName){
		 
	    String host=session.getAttribute("host").toString() ;
	    String username=session.getAttribute("username").toString();
	    String password=session.getAttribute("password").toString();
		
		JDBCUtilBaseTools orm= new JDBCUtilBaseTools(host,DBName,username,password);
	    IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	    
		return mmu;
	}
	
	protected  IMySQLManagerJdbcUtilTools getMMU (HttpSession session){
		 
	    String host=session.getAttribute("host").toString() ;
	    String username=session.getAttribute("username").toString();
	    String password=session.getAttribute("password").toString();
		
		JDBCUtilBaseTools orm= new JDBCUtilBaseTools(host,null,username,password);
	    IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	    
		return mmu;
	}
	

}

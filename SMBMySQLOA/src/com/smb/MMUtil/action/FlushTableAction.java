package com.smb.MMUtil.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.JDBCUtilBaseTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class FlushTableAction  implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(KillConnectionProcessAction.class);

 
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			HttpSession session=  request.getSession();
			
//			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			
			String host= session.getAttribute("host").toString() ;
			String username= session.getAttribute("username").toString();
			String password= session.getAttribute("password").toString();
			   
			    
			   JDBCUtilBaseTools orm= new JDBCUtilBaseTools(host,"information_schema",username,password);
				IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
				
				mmu.flushTable();
				
			 	return new ModelAndPage( request ,"showOpenTablesAction.do",true );
			}
		
		catch(Exception e ) {
			 logger.error(e);
			 throw  new Exception(e);
		}
		 
	}
}

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


public class KillConnectionProcessAction implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(KillConnectionProcessAction.class);

 
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.info("KillConnectionProcessAction .................................");
		try{
			   HttpSession session=  request.getSession();

			   String host= session.getAttribute("host").toString() ;
			   String username= session.getAttribute("username").toString();
			   String password= session.getAttribute("password").toString();
			   
			   String  type=request.getParameter("type");
			   String  ConnectionID=request.getParameter("ConnectionID");
			    if(ConnectionID.equals("")|| ConnectionID==null ){ return new ModelAndPage("showProcessListAction.do",true); }
			    
			    JDBCUtilBaseTools orm= new JDBCUtilBaseTools(host,"information_schema",username,password);
				IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
				
				mmu.killConnectionProcess(ConnectionID);
				if (type.equals("proceeslist")){
					return new ModelAndPage( request ,"showProcessListAction.do",true );
				}
				else{
					return new ModelAndPage( request ,"MMUPortletAction.do",true );
				}
			 	
			  
			 	 
		}
		
		catch(Exception e ) {
			 logger.error(e);
				return null;
		}
	}
}

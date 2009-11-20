package com.smb.MMUtil.action;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
//import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
//import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
//import com.smb.MMUtil.handler.base.JDBCUtilBaseTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;



public class LogoutAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(LogoutAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		HttpSession session=  request.getSession();
	
			 
			 Enumeration<?>  enumeration=session.getAttributeNames();
			   while (enumeration.hasMoreElements()){
				 String SessionList=enumeration.nextElement().toString();
				 logger.info(  "Remove session list :"+SessionList  );
				 session.removeAttribute(SessionList );
			 }
		 
		return new ModelAndPage( request ,"loginAction.do",true );
	}
}

 
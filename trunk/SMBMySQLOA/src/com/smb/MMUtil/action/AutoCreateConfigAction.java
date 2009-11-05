package com.smb.MMUtil.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;



public class AutoCreateConfigAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(AutoCreateConfigAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		HttpSession session=  request.getSession();
	
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
	    String host=session.getAttribute("host").toString() ;
	    String username=session.getAttribute("username").toString();
	    String password=session.getAttribute("password").toString();
	    
	     String configs=request.getParameter("config");
	     UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
		 IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		 
		 String myConfig=mmu.CreateAutoCreateConfig(configs);
		 myConfig=myConfig.replaceAll("\n","<br>");
		 
		 request.setAttribute("myConfig",myConfig);  
		 request.setAttribute("host",host);  
		 request.setAttribute("config",configs);  
		 
		return new ModelAndPage( request ,"/WEB-INF/page/autoConfig/autoCreateConfig.jsp" );
	}
}

 
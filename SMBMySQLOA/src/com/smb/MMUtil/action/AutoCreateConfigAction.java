package com.smb.MMUtil.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;



public class AutoCreateConfigAction extends ActionBase   implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(AutoCreateConfigAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		HttpSession session=  request.getSession();
	
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }

	    
	     String configs=request.getParameter("config");
		 
	     IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
	     
		 String myConfig=mmu.CreateAutoCreateConfig(configs);
		 myConfig=myConfig.replaceAll("\n","<br>");
		 
		 request.setAttribute("myConfig",myConfig);  
		 request.setAttribute("host",session.getAttribute("host"));  
		 request.setAttribute("config",configs);  
		 
		return new ModelAndPage( request ,"/WEB-INF/page/autoConfig/autoCreateConfig.jsp" );
	}
}

 
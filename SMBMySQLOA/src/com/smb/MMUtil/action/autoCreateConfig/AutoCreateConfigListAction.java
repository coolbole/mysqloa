package com.smb.MMUtil.action.autoCreateConfig;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class AutoCreateConfigListAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(AutoCreateConfigListAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
	 
		 return new ModelAndPage( request ,
				 "/WEB-INF/page/autoConfig/autoCreateConfigList.jsp" );
	}
}


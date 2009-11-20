package com.smb.MMUtil.action.drangtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.monitor.MailHostConfigUpdateAction;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;


public class DrangTestListAction    implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(MailHostConfigUpdateAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
//		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		
		return new ModelAndPage( "/WEB-INF/page/drangTest/drangTestList.jsp" );
	}

}
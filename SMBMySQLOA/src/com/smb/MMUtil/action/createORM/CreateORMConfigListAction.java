package com.smb.MMUtil.action.createORM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class CreateORMConfigListAction implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(CreateORMConfigListAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		 request.setAttribute("warn", "");
		
		return new ModelAndPage( "/WEB-INF/page/orm/createORMConfigList.jsp" );
	}

}

 

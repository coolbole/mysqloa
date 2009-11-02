package com.smb.MMUtil.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class OptimizeCaseListAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(OptimizeCaseListAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
	 
		 if(request.getSession().getAttribute("host")==null ){ 
			 return new ModelAndPage("index.jsp",true); }
	  
		 return new ModelAndPage( request ,
				 "/WEB-INF/page/optimize/optimizeCaseList.jsp" );
	}
}


 
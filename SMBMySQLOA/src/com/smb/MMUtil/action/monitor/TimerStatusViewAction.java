package com.smb.MMUtil.action.monitor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class TimerStatusViewAction  implements ControllerAction {
	private static Log logger = LogFactory.getLog(TimerStatusViewAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			
//			 if(request.getSession().getAttribute("host")==null ){ 
//				 return new ModelAndPage("index.jsp",true); 
//				 }
			 
			return new ModelAndPage( request ,"/WEB-INF/page/timer/timerstatus.jsp" );
		}
		
		catch(Exception e ) {
			 logger.error(e);
		}

		return null;
	}
	
}

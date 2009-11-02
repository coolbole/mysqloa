package com.smb.MMUtil.action.monitor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.testcase.timer.TimerTaskPool;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class TimerSetUpAction  implements ControllerAction {
	private static TimerTaskPool  timerTaskPool= new TimerTaskPool();
	private static Log logger = LogFactory.getLog(TimerSetUpAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			
			if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			
			 String Timestamp=request.getParameter("time");
			
			 if(Timestamp.equals("") ){ 	
				 logger.warn("Nothing input .....");
				 return new ModelAndPage("timerStatusViewAction.do",true);
			  }
			 timerTaskPool.execute(Timestamp);
			return new ModelAndPage("timerStatusViewAction.do",true );
		}
		
		catch(Exception e ) {
			 logger.error(e);
		}
		return null;
	}
}
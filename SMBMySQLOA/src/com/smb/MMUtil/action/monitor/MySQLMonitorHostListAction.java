package com.smb.MMUtil.action.monitor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.monitor.ISetUpMySQLMonitorHost;
import com.smb.MMUtil.handler.monitor.SetUpMySQLMonitorHost;
import com.smb.MMUtil.pojo.monitor.MySQLMonitorHost;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;
 

public class MySQLMonitorHostListAction implements ControllerAction {
	private static ISetUpMySQLMonitorHost  setUpMySQLMonitorHost= new SetUpMySQLMonitorHost();
	private static Log logger = LogFactory.getLog(MySQLMonitorHostListAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		    
			List <MySQLMonitorHost> listF=setUpMySQLMonitorHost.getMySQLMonitorHostList ();
			
			request.setAttribute("listF",listF);      
			return new ModelAndPage( request ,"/WEB-INF/page/monitor/monitorHostList.jsp" );
		}
		
		catch(Exception e ) {
			 logger.error(e);
		}

		return null;
	}
	
}
 
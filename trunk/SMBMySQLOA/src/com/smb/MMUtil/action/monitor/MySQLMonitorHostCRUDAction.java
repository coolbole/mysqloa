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
 

public class MySQLMonitorHostCRUDAction  implements ControllerAction {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(MySQLMonitorHostCRUDAction.class);
	private static ISetUpMySQLMonitorHost  setUpMySQLMonitorHost= new SetUpMySQLMonitorHost();
	
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String reqType=request.getParameter("type");
		try{
			MySQLMonitorHost MonitorHost= new MySQLMonitorHost();
			
//			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			
			if (reqType.equals("delete") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				String ID=request.getParameter("HostID");
				setUpMySQLMonitorHost.delMySQLMonitorHostList(ID);
				return new ModelAndPage( request ,"monitorHostListAction.do",true );
				
			}
			
			else if (reqType.equals("addView") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				
				return new ModelAndPage( request ,"/WEB-INF/page/monitor/addViewMySQLMonitor.jsp" );
				
			}
			
			else if (reqType.equals("add") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				String host=request.getParameter("host");String pswd=request.getParameter("pswd");
				String user=request.getParameter("user");String port=request.getParameter("port");
				
				MonitorHost.setHost(host);MonitorHost.setUser(user);
				MonitorHost.setPort(port);MonitorHost.setPswd(pswd);
				setUpMySQLMonitorHost.addMySQLMonitorHost(MonitorHost);
				
				return new ModelAndPage( "monitorHostListAction.do",true );
				
			}
			
			else if (reqType.equals("editView") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				String ID=request.getParameter("HostID");
				MySQLMonitorHost hostInfo=setUpMySQLMonitorHost.getMySQLMonitorHost(ID);
				request.setAttribute("hostInfo", hostInfo);
				
				return new ModelAndPage( request ,"/WEB-INF/page/monitor/editViewMySQLMonitor.jsp" );
			}
			
			else if (reqType.equals("edit") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				String host=request.getParameter("host");String pswd=request.getParameter("pswd");String id=request.getParameter("id");
				String user=request.getParameter("user");String port=request.getParameter("port");
				MonitorHost.setHost(host);MonitorHost.setUser(user);MonitorHost.setId(id);
				MonitorHost.setPort(port);MonitorHost.setPswd(pswd);
				setUpMySQLMonitorHost.upDataMySQLMonitorHostList(MonitorHost);
				return new ModelAndPage( "monitorHostListAction.do",true );
				
			}
			
			else{
				List <MySQLMonitorHost> listF=setUpMySQLMonitorHost.getMySQLMonitorHostList();
				request.setAttribute("listF",listF);      
				return new ModelAndPage( request ,"/WEB-INF/page/monitor/monitorHostList.jsp" );
			}
		}
		
		catch(Exception e ) {
			 logger.error(e);
		}
		return null;
	}

}
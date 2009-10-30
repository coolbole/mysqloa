package com.smb.MMUtil.action.monitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.monitor.ISetUpMySQLMonitorHost;
import com.smb.MMUtil.handler.monitor.SetUpMySQLMonitorHost;
import com.smb.MMUtil.pojo.monitor.MySQLMonitorHost;
 

public class MySQLMonitorHostCRUDAction  extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(MySQLMonitorHostCRUDAction.class);
	private static ISetUpMySQLMonitorHost  setUpMySQLMonitorHost= new SetUpMySQLMonitorHost();
	
	public MySQLMonitorHostCRUDAction() {super();	}
	
	public void destroy() {	super.destroy(); }

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println( );
		
		request.setCharacterEncoding("UTF-8");  
		response.setCharacterEncoding("UTF-8");  
		PrintWriter out = response.getWriter();
		String reqType=request.getParameter("type");
		
		try{
			
			if( request.getSession().getAttribute("host")==null){response.sendRedirect("index.jsp");}
			
			if (reqType.equals("delete") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				String ID=request.getParameter("HostID");
				setUpMySQLMonitorHost.delMySQLMonitorHostList(ID);
				RequestDispatcher   requestDispatcher=request.getRequestDispatcher("monitorHostList.action");   
				requestDispatcher.forward(request,response);
			}
			
			else if (reqType.equals("addView") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/WEB-INF/page/monitor/addViewMySQLMonitor.jsp");   
				requestDispatcher.forward(request,response);
			}
			
			else if (reqType.equals("add") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				String host=request.getParameter("host");String pswd=request.getParameter("pswd");
				String user=request.getParameter("user");String port=request.getParameter("port");
				MySQLMonitorHost MonitorHost= new MySQLMonitorHost();
				MonitorHost.setHost(host);MonitorHost.setUser(user);
				MonitorHost.setPort(port);MonitorHost.setPswd(pswd);
				setUpMySQLMonitorHost.addMySQLMonitorHost(MonitorHost);
				RequestDispatcher   requestDispatcher=request.getRequestDispatcher("monitorHostList.action");   
				requestDispatcher.forward(request,response);
			}
			
			else if (reqType.equals("editView") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				String ID=request.getParameter("HostID");
				MySQLMonitorHost hostInfo=setUpMySQLMonitorHost.getMySQLMonitorHost(ID);
				request.setAttribute("hostInfo", hostInfo);
				RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/WEB-INF/page/monitor/editViewMySQLMonitor.jsp");   
				requestDispatcher.forward(request,response);
			}
			
			else if (reqType.equals("edit") ){
				logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				String host=request.getParameter("host");String pswd=request.getParameter("pswd");String id=request.getParameter("id");
				String user=request.getParameter("user");String port=request.getParameter("port");
				MySQLMonitorHost MonitorHost= new MySQLMonitorHost();
				MonitorHost.setHost(host);MonitorHost.setUser(user);MonitorHost.setId(id);
				MonitorHost.setPort(port);MonitorHost.setPswd(pswd);
				setUpMySQLMonitorHost.upDataMySQLMonitorHostList(MonitorHost);
				RequestDispatcher   requestDispatcher=request.getRequestDispatcher("monitorHostList.action");   
				requestDispatcher.forward(request,response);
			}
			
			else{
				List <MySQLMonitorHost> listF=setUpMySQLMonitorHost.getMySQLMonitorHostList();
				request.setAttribute("listF",listF);      
				RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/WEB-INF/page/monitor/monitorHostList.jsp");   
				requestDispatcher.forward(request,response);
			}
		}
		
		catch(Exception e ) {
			 logger.error(e);
		}
		 
		out.flush();
		out.close();
	}
 
	public void init() throws ServletException {	}

}
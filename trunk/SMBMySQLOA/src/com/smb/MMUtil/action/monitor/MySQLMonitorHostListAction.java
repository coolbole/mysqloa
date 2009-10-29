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

import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.monitor.MySQLMonitorHost;
 

public class MySQLMonitorHostListAction  extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(MySQLMonitorHostListAction.class);
	private static ReadMySQLConfigXMLFile  DescriptionXMLFile= new ReadMySQLConfigXMLFile();
	
	public MySQLMonitorHostListAction() {super();	}
	
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
	 
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
			if( request.getSession().getAttribute("host")==null){response.sendRedirect("index.jsp");}
		    
			List <MySQLMonitorHost> listF=DescriptionXMLFile.getMySQLMonitorHost ();
			
			request.setAttribute("listF",listF);      
			 
			RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/WEB-INF/page/monitor/monitorHostList.jsp");   
			requestDispatcher.forward(request,response);
			
		}
		
		catch(Exception e ) {
			 logger.error(e);
		}
		 
		out.flush();
		out.close();
	}
 
	public void init() throws ServletException {	}

}
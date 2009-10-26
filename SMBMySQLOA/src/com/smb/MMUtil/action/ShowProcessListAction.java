/**
 * 
 */
package com.smb.MMUtil.action;

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

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author huangyi
 *
 */
public class ShowProcessListAction extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(ShowProcessListAction.class);
	
	public ShowProcessListAction() {super();	}
	
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
			
			    String Rhost=request.getParameter("host");
			    String Rusername=request.getParameter("username");
			    String Rpassword=request.getParameter("password");
			    if(Rhost!=null&& Rusername!=null && Rpassword!=null){
					    request.getSession().setMaxInactiveInterval(-1);
					    request.getSession().setAttribute("host",Rhost);
					    request.getSession().setAttribute("username",Rusername); 
					    request.getSession().setAttribute("password",Rpassword); 
			    }
			    if(request.getSession().getAttribute("host")==null){response.sendRedirect("index.jsp");}
				    String host=request.getSession().getAttribute("host").toString() ;
				    String username=request.getSession().getAttribute("username").toString();
				    String password=request.getSession().getAttribute("password").toString();
				    
				    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
					IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
					List proList=mmu.showProcesslistCommand();
					
				    request.setAttribute("proList",proList);      
					request.setAttribute("uptime",mmu.showUptime());      
				    request.setAttribute("host",host);   
				    request.setAttribute("version",mmu.showVersion() );   
				    
				    
				    RequestDispatcher   requestDispatcher=request.getRequestDispatcher("processlist.jsp");   
				    requestDispatcher.forward(request,response);
			    
		
		}
		
		catch(Exception e ) {
			StringBuffer HeaderBuffer = new StringBuffer();
			HeaderBuffer.append("\n<SMBML><Header><Error><RequestItem>");
			HeaderBuffer.append(e );
			HeaderBuffer.append( "</RequestItem></Error></Header></SMBML>");
		}
		 
		out.flush();
		out.close();
	}
 
	public void init() throws ServletException {	}

}

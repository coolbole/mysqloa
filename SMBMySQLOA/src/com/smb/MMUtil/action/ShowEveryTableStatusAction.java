package com.smb.MMUtil.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.pojo.TableStatusPojo;

public class ShowEveryTableStatusAction extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(ShowEveryTableStatusAction.class);
	
	public ShowEveryTableStatusAction() {super();	}
	
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
			HttpSession session=  request.getSession();
			
			String DBName=request.getParameter("DBName");
	     
		    if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
			    String host=session.getAttribute("host").toString() ;
			    String username=session.getAttribute("username").toString();
			    String password=session.getAttribute("password").toString();
			    
			    UtilBaseTools orm= new UtilBaseTools(host,DBName,username,password);
				IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
				List <TableStatusPojo> proList=mmu.showTableStatus();
			    
				
			 	request.setAttribute("proList",proList);      
			 	request.setAttribute("host",host);  
			 	request.setAttribute("uptime",mmu.showUptime() );  
			 
			    RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/WEB-INF/page/show/showEveryTableStatus.jsp");   
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

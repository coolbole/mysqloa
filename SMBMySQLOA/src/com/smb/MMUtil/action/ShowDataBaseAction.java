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

public class ShowDataBaseAction extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(ShowDataBaseAction.class);
	
	public ShowDataBaseAction() {super();	}
	
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
			if( session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
			   String host= session.getAttribute("host").toString() ;
			   String username= session.getAttribute("username").toString();
			   String password= session.getAttribute("password").toString();
			    
			    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
				IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
				List dataBasesList=mmu.showDataBases();
				
			 	request.setAttribute("dataBasesList",dataBasesList);      
			 	request.setAttribute("host",host);  
			 	
			 
			    RequestDispatcher   requestDispatcher=request.getRequestDispatcher("showDataBase.jsp");   
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

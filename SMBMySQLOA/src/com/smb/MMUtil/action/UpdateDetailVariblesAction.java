package com.smb.MMUtil.action;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.smb.MMUtil.pojo.MySQLVariableObject;

public class UpdateDetailVariblesAction extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(UpdateDetailVariblesAction.class);
	
	public UpdateDetailVariblesAction() {super();	}
	
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
			
			if( request.getSession().getAttribute("host")==null){response.sendRedirect("index.jsp");}
				String value=request.getParameter("value");
			    String variable_name=request.getParameter("variable_name");
			    String host=session.getAttribute("host").toString() ;
			    String username=session.getAttribute("username").toString();
			    String password=session.getAttribute("password").toString();
			    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
				IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
				mmu.setVariblesCommandByCategory( variable_name , value );
			 	
			 
				String url="showVariblesByCategoryAction.action?category="+request.getParameter("category");
		       	response.sendRedirect(  url  );
				
//			    RequestDispatcher   requestDispatcher=request.getRequestDispatcher("showDataBase.jsp");   
//			    requestDispatcher.forward(request,response);
			
			
			
		}
		
		catch(Exception e ) {
			 logger.error(e);
		}
		 
		out.flush();
		out.close();
	}
 
	public void init() throws ServletException {	}

}

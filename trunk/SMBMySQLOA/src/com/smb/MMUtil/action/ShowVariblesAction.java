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
import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.smb.MMUtil.pojo.MySQLVariableObject;

public class ShowVariblesAction extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(ShowVariblesAction.class);
	private static ReadMySQLConfigXMLFile  DescriptionXMLFile= new ReadMySQLConfigXMLFile();
	
	public ShowVariblesAction() {super();	}
	
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
		    
		    String host= request.getSession().getAttribute("host").toString() ;
		    String username= request.getSession().getAttribute("username").toString();
		    String password= request.getSession().getAttribute("password").toString();
		    
		    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
			IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
			
			
			List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
			
			List <MySQLVariableObject> listS=null;
			String category=request.getParameter("category");
			
			String warn="";
			if(category==null){
				listS=mmu.showVariblesCommand( );
			}
			else{
				listS=mmu.showVariblesCommandByCategory(category);
			}
				
			 	request.setAttribute("listF",listF);      
				request.setAttribute("listS",listS);      
			 
			    RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/WEB-INF/page/show/showVaribles.jsp");   
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

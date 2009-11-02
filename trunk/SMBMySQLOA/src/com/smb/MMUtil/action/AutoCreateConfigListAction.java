package com.smb.MMUtil.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class AutoCreateConfigListAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(AutoCreateConfigListAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
	 
		 if(request.getSession().getAttribute("host")==null ){ 
			 return new ModelAndPage("index.jsp",true); }
	  
		 return new ModelAndPage( request ,
				 "/WEB-INF/page/autoConfig/autoCreateConfigList.jsp" );
	}
}



/*
public class AutoCreateConfigAction extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(AutoCreateConfigAction.class);
	
	public AutoCreateConfigAction() {super();	}
	
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
 	
			if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
		    String host=session.getAttribute("host").toString() ;
		    String username=session.getAttribute("username").toString();
		    String password=session.getAttribute("password").toString();
		    
		     String configs=request.getParameter("config");
		     UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
			 IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
			 
			 String myConfig=mmu.CreateAutoCreateConfig(configs);
			 myConfig=myConfig.replaceAll("\n","<br>");
			 
			 request.setAttribute("myConfig",myConfig);  
			 request.setAttribute("host",host);  
			 
			 RequestDispatcher   requestDispatcher=request.getRequestDispatcher("autoCreateConfig.jsp");   
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
*/
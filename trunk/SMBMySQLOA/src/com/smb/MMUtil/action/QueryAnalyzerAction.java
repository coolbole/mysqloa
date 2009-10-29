/**
 * 
 */
package com.smb.MMUtil.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.queryAnalyzer.QueryAnalyzerFactory;

/**
 * @author huangyi
 *
 */
public class QueryAnalyzerAction  extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(QueryAnalyzerAction.class);
	
	public QueryAnalyzerAction() {super();	}
	
	public void destroy() {	super.destroy(); }

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println( );
		
		request.setCharacterEncoding("UTF-8");  
		response.setCharacterEncoding("UTF-8");  
		Map map=null; String SQL="";
		PrintWriter out = response.getWriter();
		
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			HttpSession session=  request.getSession();
 	
			if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
		    String host=session.getAttribute("host").toString() ;
		    String username=session.getAttribute("username").toString();
		    String password=session.getAttribute("password").toString();
		    
		     SQL=request.getParameter("SQL");
		     String DBName=request.getParameter("DBName");
		     System.out.println(DBName );
		      if (DBName.indexOf("#")!=-1 ){
		    	  response.sendRedirect("showDataBaseAction.action?type=queryAnalyzer");
		      }
		     
		     UtilBaseTools orm= new UtilBaseTools(host,DBName,username,password);
		     QueryAnalyzerFactory  MQA= new QueryAnalyzerFactory(orm);
		     map=MQA.execResult(SQL);
		     
		 
		     if ( map.get("SQLCount")!=null){
		    	 request.setAttribute("SQLCount",map.get("SQLCount") );
		     }
		     else{
		    	 request.setAttribute("SQLCount","" );
		     }
		     
		     if ( map.get("sql")!=null){
		    	 request.setAttribute("sql",map.get("sql") );
		     }
		     else{
		    	 request.setAttribute("sql","" );
		     }
		     
		     if ( map.get("count")!=null){
		    	 request.setAttribute("count",map.get("count") );
		     }
		     else{
		    	 request.setAttribute("count","" );
		     }
		     
		     if ( map.get("columns")!=null){
		    	 request.setAttribute("columns",map.get("columns") );
		     }
		     else{
		    	 request.setAttribute("columns","" );
		     }
		     
		     if ( map.get("values")!=null){
		    	 request.setAttribute("values",map.get("values") );
		     }
		     else{
		    	 request.setAttribute("values","" );
		     }
		    
		     request.setAttribute("err",map.get("err")  );
		     
			 RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/WEB-INF/page/queryAnaly/queryAnalyzerResult.jsp");   
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


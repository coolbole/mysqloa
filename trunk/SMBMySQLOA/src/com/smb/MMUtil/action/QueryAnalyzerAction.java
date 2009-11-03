package com.smb.MMUtil.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.queryAnalyzer.QueryAnalyzerFactory;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;


public class QueryAnalyzerAction implements ControllerAction {
	private static Log logger = LogFactory.getLog(QueryAnalyzerAction.class);
	
	 
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map  map=null;
		String SQL="";
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			HttpSession session=  request.getSession();
 	
			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
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
		}
		
		catch(Exception e ) { 
			 logger.error(e);
		}
		return new ModelAndPage( request ,"/WEB-INF/page/queryAnaly/queryAnalyzerResult.jsp" );
	}
	
}
 
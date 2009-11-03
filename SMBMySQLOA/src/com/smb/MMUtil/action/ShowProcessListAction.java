  
package com.smb.MMUtil.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.pojo.MySQLShowProcessList;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class ShowProcessListAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(ShowProcessListAction.class);
	
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		try{
	    String Rhost=request.getParameter("host");
	    String Rusername=request.getParameter("username");
	    String Rpassword=request.getParameter("password");
	    if(Rhost!=null&& Rusername!=null && Rpassword!=null){
			    request.getSession().setMaxInactiveInterval(-1);
			    request.getSession().setAttribute("host",Rhost);
			    request.getSession().setAttribute("username",Rusername); 
			    request.getSession().setAttribute("password",Rpassword); 
	    }
		  if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		    String host=request.getSession().getAttribute("host").toString() ;
		    String username=request.getSession().getAttribute("username").toString();
		    String password=request.getSession().getAttribute("password").toString();
		
		    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
		    MySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	 
		    List<MySQLShowProcessList> proList = mmu.showProcesslistCommand();
		
		 	request.setAttribute("proList",proList);      
			request.setAttribute("uptime",mmu.showUptime());      
		    request.setAttribute("host",host);   
		    request.setAttribute("version",mmu.showVersion() );   
		    
		}
		catch(Exception e) {
			 logger.error(e);
			return new ModelAndPage("index.jsp",true);
		}
		
		return new ModelAndPage( request ,"/WEB-INF/page/show/showProcessList.jsp" );
	}
}

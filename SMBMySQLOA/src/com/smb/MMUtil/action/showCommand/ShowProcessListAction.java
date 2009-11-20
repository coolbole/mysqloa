  
package com.smb.MMUtil.action.showCommand;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.pojo.MySQLShowProcessList;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class ShowProcessListAction extends ActionBase implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(ShowProcessListAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		HttpSession session=  request.getSession();
		
		try{
	    String Rhost=request.getParameter("host");
	    String Rusername=request.getParameter("username");
	    String Rpassword=request.getParameter("password");
	    if(Rhost!=null&& Rusername!=null && Rpassword!=null){
			    	session.setMaxInactiveInterval(100000);
			    	session.setAttribute("host",Rhost);
			    	session.setAttribute("username",Rusername); 
			    	session.setAttribute("password",Rpassword); 
	    }
	    
		  if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("loginAction.do",true); }
		    
		    IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
		    List<MySQLShowProcessList> proList = mmu.showProcesslistCommand();
		    
		 	request.setAttribute("proList",proList);      
			request.setAttribute("uptime",mmu.showUptime());      
		    request.setAttribute("host",session.getAttribute("host"));   
		    request.setAttribute("version",mmu.showVersion() );   
			}
		
		catch(Exception e) {
			String ems=e.getMessage();
			if (ems.indexOf("Access denied for user")!=-1){
				return new ModelAndPage("loginAction.do?err=用户名或者密码不正确，请您重新输入");
			}
			else if(ems.indexOf("Communications link failure")!=-1){
				return new ModelAndPage("loginAction.do?err=连接的主机没有开启MySQL服务器");
			}
		}
		return new ModelAndPage( request ,"/WEB-INF/page/show/showProcessList.jsp" );
	}
}

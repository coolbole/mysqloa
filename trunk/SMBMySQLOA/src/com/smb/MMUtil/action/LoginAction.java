package com.smb.MMUtil.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.autoCreateConfig.AutoCreateConfigListAction;
import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.pojo.RecentHost;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class LoginAction extends ActionBase   implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(AutoCreateConfigListAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		List<?>  recentlyList=DescriptionXMLFile.getMySQLRecentHost();
		int size= recentlyList.size() ;
		String ID=request.getParameter("id");
		
		if (ID!=null){
		RecentHost  recentHostInfo=DescriptionXMLFile.getMySQLRecentHostInfo(ID);  
			System.out.println (recentHostInfo);
			request.setAttribute("username", recentHostInfo.getUsername() ); 
			request.setAttribute("password", recentHostInfo.getPassword() ); 
			request.setAttribute("host", recentHostInfo.getServerIP() ); 
		}
		
		request.setAttribute("recently", size );  // 只要被存入 RecentLoginHost.xml 就不显示
		request.setAttribute("recentlyList", recentlyList ); 
	
		
		 return new ModelAndPage( request , "/WEB-INF/page/login.jsp" );
	}
}


package com.smb.MMUtil.action.createORM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class CreateORMConfigSelectTabAction implements ControllerAction {
	 
	private static Log logger = LogFactory.getLog(CreateORMConfigSelectTabAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		 if(request.getParameter("createORMID")!=null){
			 String createORMID=request.getParameter("createORMID").toString();
			 String packageName=request.getParameter("packageName").toString();
			 String DBName=request.getParameter("DBName").toString();
			 
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		 	String host=request.getSession().getAttribute("host").toString() ;
		    String username=request.getSession().getAttribute("username").toString();
		    String password=request.getSession().getAttribute("password").toString();
		
		    UtilBaseTools orm= new UtilBaseTools(host,DBName,username,password);
		    IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		 
		     request.setAttribute("showTabs", mmu.showTableStatus() );
			 request.setAttribute("createORMID", createORMID);
			 request.setAttribute("packageName", packageName);
		 
			 return new ModelAndPage( "/WEB-INF/page/orm/createORMConfigSelectTab.jsp" );
		 }
		 
		 else{
			 request.setAttribute("warn", "选择表操作失败,请重新操作");
			 return new ModelAndPage("/WEB-INF/page/orm/createORMConfigList.jsp");
		 }
			
	}

}

 

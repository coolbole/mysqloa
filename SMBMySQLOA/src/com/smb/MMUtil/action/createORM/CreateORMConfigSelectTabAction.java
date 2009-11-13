package com.smb.MMUtil.action.createORM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class CreateORMConfigSelectTabAction  extends ActionBase implements ControllerAction {
	 
	private static Log logger = LogFactory.getLog(CreateORMConfigSelectTabAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session=  request.getSession();
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		 if(request.getParameter("createORMID")!=null){
			 String createORMID=request.getParameter("createORMID").toString();
			 String packageName=request.getParameter("packageName").toString();
			 String DBName=request.getParameter("DBName").toString();
			 
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			
			IMySQLManagerJdbcUtilTools   mmu= getMMU(session,DBName);
		 
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

 

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

public class CreateORMConfigSelectDBAction implements ControllerAction {
	 
	private static Log logger = LogFactory.getLog(CreateORMConfigSelectDBAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		 String createORMID= request.getParameter("createORMID");
		 String packageName= request.getParameter("packageName");
		 
		 if(packageName.equals("")||packageName.indexOf(".")==-1){
			 logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			 request.setAttribute("warn", "请输入正确的Package名称");
			 return new ModelAndPage( "/WEB-INF/page/orm/createORMConfigList.jsp" );
		 }
		 
		 else{
			 logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		 	String host=request.getSession().getAttribute("host").toString() ;
		    String username=request.getSession().getAttribute("username").toString();
		    String password=request.getSession().getAttribute("password").toString();
		
		    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
		    IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		 
		     request.setAttribute("showDataBases", mmu.showDataBases() );
			 request.setAttribute("createORMID", createORMID);
			 request.setAttribute("packageName", packageName);
			 request.setAttribute("warn", "");
		 }
		
		return new ModelAndPage( "/WEB-INF/page/orm/createORMConfigSelectDB.jsp" );
	}

}

 

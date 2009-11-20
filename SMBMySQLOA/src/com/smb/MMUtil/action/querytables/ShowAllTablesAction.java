package com.smb.MMUtil.action.querytables;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class ShowAllTablesAction extends ActionBase  implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(ShowAllTablesAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		HttpSession session=  request.getSession();
	 
		String DBName=request.getParameter("DBName");
	    
	    IMySQLManagerJdbcUtilTools   mmu= getMMU(session,DBName);
	    List<?> tables=mmu.showTablesCommand(DBName);
	    
	    request.setAttribute("DBName", DBName);  
		request.setAttribute("host",session.getAttribute("host"));  
		request.setAttribute("tables", tables);  
		 
		return new ModelAndPage( request ,"/WEB-INF/page/queryTables/showAllTables.jsp" );
	}
}
  
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
			 
			
		    IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
		    List<MySQLShowProcessList> proList = mmu.showProcesslistCommand();
		    
		 	request.setAttribute("proList",proList);      
		 	request.setAttribute("host",session.getAttribute("host"));     
		  
		 	
		return new ModelAndPage( request ,"/WEB-INF/page/show/showProcessList.jsp" );
	}
}

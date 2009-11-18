package com.smb.MMUtil.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.pojo.MySQLTableIndex;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class ShowEveryTableIndexStatusAction extends ActionBase implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(ShowEveryTableIndexStatusAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			HttpSession session=  request.getSession();
			
			String DBName=request.getParameter("DBName");
	     
			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			   
			 	IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
				List <MySQLTableIndex> proList=  mmu.showTableIndexs(DBName);
				
			 	request.setAttribute("proList",proList);      
			 	request.setAttribute("host",session.getAttribute("host") );  
			 	request.setAttribute("uptime",mmu.showUptime() );  
			 	return new ModelAndPage( request ,"/WEB-INF/page/show/showEveryTableIndexStatus.jsp" );
			}
		
		catch(Exception e ) {
			 logger.error(e);
			 return null;
		}
		
	}
	
}
 
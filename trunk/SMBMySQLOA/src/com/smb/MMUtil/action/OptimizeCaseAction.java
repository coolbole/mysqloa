package com.smb.MMUtil.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class OptimizeCaseAction implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(OptimizeCaseAction.class);

	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			HttpSession session=  request.getSession();
			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		    String host=session.getAttribute("host").toString() ;
		    String username=session.getAttribute("username").toString();
		    String password=session.getAttribute("password").toString();
		    
		    
		    String optimizeCase=request.getParameter("OptimizeCaseAlias");
		    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
			IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
			List listS=mmu.MySQLOptimize( optimizeCase);
			
			 	request.setAttribute("listS",listS);      
			 	request.setAttribute("host",host);  
			    return new ModelAndPage( request ,"/WEB-INF/page/optimize/optimizeCase.jsp" );
			
			
		}
		
		catch(Exception e ) {
			 logger.error(e);return null;
		}
		
	}
}

 
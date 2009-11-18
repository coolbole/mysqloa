package com.smb.MMUtil.action.optimize;

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

public class OptimizeCaseAction   extends ActionBase  implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(OptimizeCaseAction.class);

	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			HttpSession session=  request.getSession();
			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			 
		    String optimizeCase=request.getParameter("OptimizeCaseAlias");
			IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
			List listS=mmu.MySQLOptimize( optimizeCase);
			
			 	request.setAttribute("listS",listS);      
			 	request.setAttribute("host",session.getAttribute("host"));  
			    return new ModelAndPage( request ,"/WEB-INF/page/optimize/optimizeCase.jsp" );
			
			
		}
		
		catch(Exception e ) {
			 logger.error(e);return null;
		}
		
	}
}

 
package com.smb.MMUtil.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class UpdateDetailVariblesAction extends ActionBase  implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(UpdateDetailVariblesAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			HttpSession session=  request.getSession();
			
			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
				String value=request.getParameter("value");
			    String variable_name=request.getParameter("variable_name");
 
			    IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
			    
				mmu.setVariblesCommandByCategory( variable_name , value );
				String url="showVariblesByCategoryAction.do?category="+request.getParameter("category");
		         return new ModelAndPage(url,true);
		}
		
		catch(Exception e ) {
			 logger.error(e);		 return null;
		}
		
	}
	
}
 
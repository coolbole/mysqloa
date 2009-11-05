package com.smb.MMUtil.action.optimize;
 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class DeepOptimizeCaseFinishAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(DeepOptimizeCaseFinishAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		 String optimizeName=request.getParameter("optimizeName");
		 optimizeName=optimizeName.substring(1).substring(0,optimizeName.length()-2 );
		 
		 if(request.getParameter("yes") !=null) {
			 
			 logger.info("\n 根据XML配置选项，执行了你选择的 "+optimizeName +" 选项");
			 
			 return new ModelAndPage( request , "/WEB-INF/page/optimize/deepOptimizeCaseFinish.jsp" );
		 }
		 
		 else{
			 return new ModelAndPage( request , 
					 "deepOptimizeCaseListAction.do?step=1" ,true);
		 }
		
	}
}



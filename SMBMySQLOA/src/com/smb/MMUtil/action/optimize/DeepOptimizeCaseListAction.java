package com.smb.MMUtil.action.optimize;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class DeepOptimizeCaseListAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(OptimizeCaseListAction.class);
	private static List list= new ArrayList ();
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			
		try{
			 ModelAndPage  modelAndPage=null;
			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			 String step= request.getParameter("step");
			
		 if (step.equals(step )){
		
			 if (step.equals("1")){
				 	list= new ArrayList ();
			 }
			 String optimizeNames[]=request.getParameterValues("optimizeName");
			 	if (optimizeNames!=null){
				 	for (int i=0;i<optimizeNames.length;i++){
				 		list.add(  optimizeNames [ i ] );
				 	}
			 	}
			 
			 	request.setAttribute("optimizeNames", list);
				 
			 	 if (step.equals("4")){
			 		 	return new ModelAndPage( request , "deepOptimizeCasePrepareAction.do" );
			 	 }
				  modelAndPage=
					 new ModelAndPage( request , "/WEB-INF/page/optimize/deepOptimizeCaseList_"+step+".jsp" );
			
		 }
		 
			 return modelAndPage;
		}
		
		catch (Exception e){
			 throw new Exception(e);
		}
	}
}



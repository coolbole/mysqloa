package com.smb.MMUtil.action.optimize;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.MySQLDeepOptimize;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class DeepOptimizeCaseListAction implements ControllerAction  {
	private static ReadMySQLConfigXMLFile  read= new ReadMySQLConfigXMLFile();
	private static Log logger = LogFactory.getLog(OptimizeCaseListAction.class);
	@SuppressWarnings("unchecked")
	private static List list= new ArrayList ();
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			
		try{
			 ModelAndPage  modelAndPage=null;
			 
//			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			 
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
			 	 
			 	List <MySQLDeepOptimize> list=read.getMySQLDeepOptimizeCase();
			 	
			 	List <MySQLDeepOptimize> listF= new ArrayList ();
			 	
			 	for (int i=0;i<list.size();i++){
			 		 if (list.get(i).getStepName().equals( step)   ){
			 			 listF.add(  list.get(i) );
			 		 }
			 	}

			 	request.setAttribute("listF", listF);
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



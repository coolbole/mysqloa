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

public class DeepOptimizeCaseFinishAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(DeepOptimizeCaseFinishAction.class);
	private static ReadMySQLConfigXMLFile  read= new ReadMySQLConfigXMLFile();
	
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		 
		
		 if(request.getParameter("back") !=null) {
				 return new ModelAndPage( request , 
						 "deepOptimizeCaseListAction.do?step=1" ,true);
			 }
 		
 		 
		 else if(request.getParameter("yes") !=null) {
 			   
 			 String optimizeIDs1=request.getParameter("optimizeIDs");
 	 		 String optimizeIDs2=optimizeIDs1.substring(1).substring(0,optimizeIDs1.length()-2 );
 			
			 List list = new ArrayList ();
			 String optimizeID[]=optimizeIDs2.split(",");
			 for (int i=0;i<optimizeID.length ;i++){
				 list.add( optimizeID[i].trim()  );
			 }
			 
			 List <MySQLDeepOptimize> Optimizelist=read.getMySQLDeepOptimizeCase();
	 
			 List  deepOptimizeCommand= new ArrayList ();
			 
			 
			 for (int i=0;i<Optimizelist.size() ;i++){
				 for (int h=0;h<list.size() ;h++){
					 if ( list.get(h).equals(  Optimizelist.get(i).getQuestionID()  )  ){
						 deepOptimizeCommand.add(  Optimizelist.get(i)  );
					 }
				 }
			 }
			 
			 
			 
			 logger.info("\n 根据XML配置选项，调用MySQLManagerJdbcUtilTools 业务逻辑的方法，你选择的  选项"+deepOptimizeCommand);
			 
			 request.setAttribute("deepOptimizeCommand", deepOptimizeCommand);
			 
			 return new ModelAndPage( request , "/WEB-INF/page/optimize/deepOptimizeCaseFinish.jsp" );
		 }
		 
		 else{
			 return new ModelAndPage( request , 
					 "deepOptimizeCaseListAction.do?step=1" ,true);
		 }
		
	}
}



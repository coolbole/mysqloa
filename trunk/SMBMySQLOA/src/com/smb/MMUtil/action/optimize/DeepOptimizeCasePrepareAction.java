package com.smb.MMUtil.action.optimize;

 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.MySQLDeepOptimize;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class DeepOptimizeCasePrepareAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(DeepOptimizeCasePrepareAction.class);
	private static ReadMySQLConfigXMLFile  read= new ReadMySQLConfigXMLFile();
	
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
//		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		    List optimizeIDs =(List)request.getAttribute("optimizeNames");
		
		 	HashSet  hashSet   =     new     HashSet (optimizeIDs);
		 	optimizeIDs.clear();
		 	optimizeIDs.addAll(hashSet);
//		    System.out.println("将要准备执行  : "+optimizeIDs+"读取XML文件 ，" +
//		    		"告诉用户当前的选择的优化配置信息把将要优化的选择加载给用户显示。");
		 
		    List <MySQLDeepOptimize> deepOptimizeList=read.getMySQLDeepOptimizeCase();
		    List deepOptimizeTitle= new ArrayList ();
		    
		    for (int i=0;i<deepOptimizeList.size();i++){
		    	 for (int h=0;h<optimizeIDs.size();h++){
		    		 if ( deepOptimizeList.get(i).getQuestionID().equals(optimizeIDs.get(h) ) ){
		    			 deepOptimizeTitle.add(  deepOptimizeList.get(i).getQuestionTitle()    );
		    		 }
		    	 }
		    	
		    }
		    
		    request.setAttribute("optimizeIDs", optimizeIDs  );
		    request.setAttribute("deepOptimizeTitle", deepOptimizeTitle  );
		 
		 return new ModelAndPage( request , "/WEB-INF/page/optimize/deepOptimizeCasePrepare.jsp" );
	}
}



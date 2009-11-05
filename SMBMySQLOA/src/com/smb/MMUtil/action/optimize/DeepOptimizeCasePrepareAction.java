package com.smb.MMUtil.action.optimize;

 

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class DeepOptimizeCasePrepareAction implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(DeepOptimizeCasePrepareAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		    List list =(List)request.getAttribute("optimizeNames");
		
		 	HashSet  hashSet   =     new     HashSet (list);
		    list.clear();
		    list.addAll(hashSet);
		    System.out.println("将要准备执行  : "+list+"读取XML文件 ，" +
		    		"告诉用户当前的选择的优化配置信息把将要优化的选择加载给用户显示。");
		 
 
		    
		 request.setAttribute("optimizeName", list  );
		 
		 
		 return new ModelAndPage( request , "/WEB-INF/page/optimize/deepOptimizeCasePrepare.jsp" );
	}
}



package com.smb.MMUtil.action;

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

public class ShowDataBaseAction extends ActionBase implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(ShowDataBaseAction.class);

	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			HttpSession session=  request.getSession();
			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			 	String actionType=request.getParameter("type");
			 
			 	IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
				List<?> dataBasesList=mmu.showDataBases();
				
			 	request.setAttribute("dataBasesList",dataBasesList);      
			 	request.setAttribute("host",session.getAttribute("host") );  
			 	
			 	if (actionType.equals("queryAnalyzer")){
			 		logger.info(actionType+"\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			 		return new ModelAndPage( request ,"/WEB-INF/page/queryAnaly/queryAnalyzer.jsp" );
			 	}
			 	
				if (actionType.equals("queryTables")){
			 		logger.info(actionType+"\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			 		return new ModelAndPage( request ,"/WEB-INF/page/queryTables/queryTables.jsp" );
			 	}
			 	
			 	else if (actionType.equals("index")){
			 		logger.info(actionType+"\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			 		request.setAttribute("actionType", actionType);
			 		return new ModelAndPage( request ,"/WEB-INF/page/show/showDataBase.jsp" );
			 	}
			   
			 	else  if (actionType.equals("everytable")){
			 	logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			 	
			 	request.setAttribute("actionType", actionType);
			 	return new ModelAndPage( request ,"/WEB-INF/page/show/showDataBase.jsp" );
			 	}
			 	return null;
		}
		
		catch(Exception e ) {
			 logger.error(e);
				return null;
		}
	}
}

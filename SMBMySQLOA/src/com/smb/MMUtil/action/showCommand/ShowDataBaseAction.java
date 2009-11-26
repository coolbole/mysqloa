package com.smb.MMUtil.action.showCommand;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.flashchart.FlashChartCreatorBase;
import com.smb.MMUtil.pojo.DiskInfoPojo;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

@SuppressWarnings("deprecation")
public class ShowDataBaseAction extends ActionBase implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(ShowDataBaseAction.class);

	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
				HttpSession session=  request.getSession();
			 	String actionType=request.getParameter("type");
			 	IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
			 	request.setAttribute("host",session.getAttribute("host") );  
			 	
			 	if (actionType.equals("queryAnalyzer")){
					List<?> dataBasesList=mmu.showDataBases();
				 	request.setAttribute("dataBasesList",dataBasesList);   
			 		logger.info(actionType+"\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			 		return new ModelAndPage( request ,"/WEB-INF/page/queryAnaly/queryAnalyzer.jsp" );
			 	}
			 	
				if (actionType.equals("queryTables")){
			 		logger.info(actionType+"\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
   
			 		List<DiskInfoPojo> list= getMMU(session,"information_schema").showTablesCount() ;
			 		String DataBaseTablesInfoXML=fashChartTools.getDataBaseTablesInfoXML(list);
			 		
			 		String xml=FlashChartCreatorBase.createChartHTML("falshchart/Doughnut2D.swf", "",
			 				DataBaseTablesInfoXML, "myNext",570, 300, false);
			 		
			 		request.setAttribute("xml", xml);
			 		request.setAttribute("DBTableCounts", list);
			 		return new ModelAndPage( request ,"/WEB-INF/page/queryTables/queryTables.jsp" );
			 	}
			 	
			 	else if (actionType.equals("index")){
			 		logger.info(actionType+"\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			 		
			 		List <DiskInfoPojo> dataBaseDiskInfoList=mmu.getDataBaseDiskInfo();
				 	request.setAttribute("dataBasesList", dataBaseDiskInfoList);
			 		request.setAttribute("actionType", actionType);
			 		
			 		return new ModelAndPage( request ,"/WEB-INF/page/show/showDataBaseindex.jsp" );
			 	}
			   
			 	else  if (actionType.equals("everytable")){
				 	logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
				 	
				 	List <DiskInfoPojo> dataBaseDiskInfoList=mmu.getDataBaseDiskInfo();
				 	String BaseOnDiskSizeXMLData=fashChartTools.getDataBaseOnDiskSizeInfoXML(  dataBaseDiskInfoList );
				 	
				 	String xml=FlashChartCreatorBase.createChartHTML("falshchart/Doughnut2D.swf", "",
				 			BaseOnDiskSizeXMLData, "myNext",570, 300, false);
			 	
			 	
			 	request.setAttribute("dataBasesList", dataBaseDiskInfoList);
			 	request.setAttribute("actionType", actionType);
			 	request.setAttribute("xml", xml);
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

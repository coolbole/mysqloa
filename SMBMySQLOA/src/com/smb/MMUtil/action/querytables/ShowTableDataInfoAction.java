package com.smb.MMUtil.action.querytables;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.MMUtil.action.QueryAnalyzerAction;
import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
 
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class ShowTableDataInfoAction  extends ActionBase implements ControllerAction  {
	private static Log logger = LogFactory.getLog(QueryAnalyzerAction.class);
	
	 
	 
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			HttpSession session=  request.getSession();
			 
		     String DBName=request.getParameter("DBName");
		     System.out.println(DBName );
		     request.setAttribute("DBName",DBName  );
		    
		     IMySQLManagerJdbcUtilTools   mmu= getMMU(session,DBName);
			 List<?> tables=mmu.showTablesCommand(DBName);
			 request.setAttribute("tables",tables  );
			 
		}
		
		catch(Exception e ) { 
			 logger.error(e);
		}
		return new ModelAndPage( request ,"/WEB-INF/page/queryTables/showTableDataInfo.jsp" );
	}
	
}


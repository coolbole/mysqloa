package com.smb.MMUtil.action.querytables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private static int count=1000;
    
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			HttpSession session=  request.getSession();
			 
		     String DBName=request.getParameter("DBName");
		     String TabName=request.getParameter("TabName");
		     
		     System.out.println(" [DBName: "+DBName+" ]  [ TabName: "+TabName+"]"  );
		     request.setAttribute("DBName",DBName  );
		     request.setAttribute("TabName",TabName  );
		     
		     
		     IMySQLManagerJdbcUtilTools   mmu= getMMU(session,DBName);
		     Map<?, ?>   map=mmu.showTableDataInfo(TabName,0,count);

		     Integer counts=(Integer)map.get("counts");
		     
		     Object pageOutPut=map.get("pageOutPut");
		     
 			if (counts!=0){
 				 request.setAttribute("tables",  pageOutPut  );
 				 request.setAttribute("counts",  counts  );
 	 			 request.setAttribute("pages",  counts/count +1 );
  	  			}
 	  			else{
 	  				 request.setAttribute("counts",  0  );
 	 	 			 request.setAttribute("pages",  0 );
 	 	 			 List<String> list = new ArrayList<String> ();
 	 	 			 list.add("<br><br><br>该表没有任何数据，请选择返回 ");
 	  				 request.setAttribute("tables",  list );
 	  			}
 			 
 			 
 			
 			 
 			 
		}
		
		catch(Exception e ) { 
			 logger.error(e);
		}
		return new ModelAndPage( request ,"/WEB-INF/page/queryTables/showTableDataInfo.jsp" );
	}
	
}


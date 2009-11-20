package com.smb.MMUtil.action.showCommand;

 
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class ShowVariblesAction extends ActionBase  implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(ShowVariblesAction.class);
	
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {

		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		HttpSession session=  request.getSession();
		
		IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
		
		List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
		
		List <MySQLVariableObject> listS=null;
		String category=request.getParameter("category");
		
		if(category==null){
			listS=(List<MySQLVariableObject>) mmu.showVariblesCommand( );
		}
		else{
			listS=(List<MySQLVariableObject>) mmu.showVariblesCommandByCategory(category);
		}
			
		 	request.setAttribute("listF",listF);      
			request.setAttribute("listS",listS);      
		if (category==null){
			return new ModelAndPage( request ,"/WEB-INF/page/show/showVaribles.jsp" );
		}
		else{
			return new ModelAndPage( request ,"/WEB-INF/page/show/showVariblesByCategory.jsp" );
		}
		
	}
}
 
package com.smb.MMUtil.action.showCommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class ShowDetailVariblesAction  extends ActionBase  implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(ShowDetailVariblesAction.class);
	private static ReadMySQLConfigXMLFile  DescriptionXMLFile= new ReadMySQLConfigXMLFile();
	
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
			String variable_name=request.getParameter("variable_name");
			HttpSession session=  request.getSession();
 
			IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
			List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
		
			MySQLVariableObject listS=mmu.showDetailVaribles(variable_name);
				 
			request.setAttribute("listS",listS);   
			request.setAttribute("listF",listF );   
		    
		return new ModelAndPage( request ,"/WEB-INF/page/show/showDetailVaribles.jsp" );
	}
}
 
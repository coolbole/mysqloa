package com.smb.MMUtil.action.monitor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.email.Email;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class MailHostConfigViewAction  implements ControllerAction {
	
	private static ReadMySQLConfigXMLFile  read= new ReadMySQLConfigXMLFile();
	private static Log logger = LogFactory.getLog(MailHostConfigViewAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		Email  mailnfo= read.getMailHostConfigXMLFile();
		request.setAttribute("mailnfo", mailnfo);
		return new ModelAndPage( request,"WEB-INF/page/monitor/viewMailServer.jsp" );
		
		
	}

}

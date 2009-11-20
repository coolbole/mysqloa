package com.smb.MMUtil.action.monitor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.email.Email;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class MailHostConfigUpdateAction  implements ControllerAction {
	
	private static ReadMySQLConfigXMLFile  read= new ReadMySQLConfigXMLFile();
	private static Log logger = LogFactory.getLog(MailHostConfigUpdateAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
//		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		 
		String mailServer=request.getParameter("mailServer");
		String port=request.getParameter("port");
		String recipient=request.getParameter("recipient");
		String emailAccount=request.getParameter("emailAccount");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		  
		 Email emailInfo=new Email ();
		 emailInfo.setEmailAccount(emailAccount);
		 emailInfo.setMailServer(mailServer);
		 emailInfo.setPassword(password);
		 emailInfo.setPort(port);
		 emailInfo.setRecipient(recipient);
		 emailInfo.setUsername(username);
		 
		
		read.updateMailHostConfigXMLFile(emailInfo);
		
		return new ModelAndPage( "mailHostConfigViewAction.do",true );
	}

}

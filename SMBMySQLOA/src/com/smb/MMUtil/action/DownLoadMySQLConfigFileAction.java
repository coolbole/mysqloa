package com.smb.MMUtil.action;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class DownLoadMySQLConfigFileAction extends ActionBase   implements ControllerAction {
	
	private static Log logger = LogFactory.getLog(DownLoadMySQLConfigFileAction.class);

	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			  
			HttpSession session=  request.getSession();
			
//			 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			 
			 String configs=request.getParameter("config");
			 IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
			 String myConfig=mmu.CreateAutoCreateConfig(configs);
 
			 response.setHeader("Content-Disposition", "attachment; charset=utf-8;filename=my.ini"); 
 
			 OutputStream outputStream = response.getOutputStream();
			 InputStream inputStream = new java.io.ByteArrayInputStream(myConfig.getBytes() );
			 
			 byte[] buffer = new byte[1024];
			 int i = -1;
			 while ((i = inputStream.read(buffer)) != -1) {
				 outputStream.write(buffer, 0, i);
			  }
			 outputStream.flush();
			 outputStream.close();
			 inputStream.close();
			 return  new ModelAndPage( request ,"autoCreateConfigAction.do" ); 
		 
		}
	}

 
/**
 * 
 */
package com.smb.MMUtil.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.flashchart.FlashChartCreatorBase;
import com.smb.MMUtil.handler.portlet.PortletService;
import com.smb.MMUtil.pojo.RecentHost;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;
import com.smb.framework.web.action.ObjectFactory;

/**
 * @author ivan
 *
 */
@SuppressWarnings("deprecation")
public class PortletAction extends ActionBase   implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(PortletAction.class);
	
 
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		HttpSession session=  request.getSession();
		
		try{
	    String Rhost=request.getParameter("host");
	    String Rusername=request.getParameter("username");
	    String Rpassword=request.getParameter("password");
	    if(Rhost!=null&& Rusername!=null && Rpassword!=null){
			    	session.setMaxInactiveInterval(10000);
			    	session.setAttribute("host",Rhost);
			    	session.setAttribute("username",Rusername); 
			    	session.setAttribute("password",Rpassword); 
	    }
		  if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("loginAction.do",true); }
		  
		  	PortletService   mmu=getPortletMMU(session);
		  	Map<?, ?>  map=mmu.showProcesslistCommand();
		    Map<String, Long> flashchartData=  mmu.getFlashchartData();
		    
		    String DataBaseTablesInfoXML=fashChartTools.getPortletAllStatusInfo(flashchartData);
		    
		    String xml=FlashChartCreatorBase.createChartHTML("falshchart/StackedColumn3D.swf", "",
	 				DataBaseTablesInfoXML, "myNext",480, 280, false);
	 		
	 		request.setAttribute("xml", xml);
		    
		 	request.setAttribute("proList",map.get("processlist") );      
			request.setAttribute("uptime",map.get("uptime") );      
		    request.setAttribute("host",session.getAttribute("host"));   
		    request.setAttribute("version",map.get("version") );   
			
		 System.out.println ( flashchartData );
		 
		   
		    int xmlNodes=DescriptionXMLFile.getMySQLRecentHost().size();
			  if (xmlNodes==0){
				  System.out.println (  xmlNodes );
				   RecentHost RecentHostInfo= new RecentHost();
				   RecentHostInfo.setAlias("ServerAlias");
				   RecentHostInfo.setServerIP( Rhost);
				   RecentHostInfo.setPort("3306");
				   RecentHostInfo=(RecentHost) ObjectFactory.getObjectFactory(RecentHostInfo, request);
				   DescriptionXMLFile.AddMySQLRecentHost(RecentHostInfo);
			  }
		
		}
		
		catch(Exception e) {
			String ems=e.getMessage();
			if (ems.indexOf("Access denied for user")!=-1){
				return new ModelAndPage("loginAction.do?err=用户名或者密码不正确，请您重新输入");
			}
			else if(ems.indexOf("Communications link failure")!=-1){
				return new ModelAndPage("loginAction.do?err=连接的主机没有开启MySQL服务器");
			}
		}
		return new ModelAndPage( request ,"/WEB-INF/page/main/portlet.jsp" );
	}
}

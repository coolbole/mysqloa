package com.smb.MMUtil.action.recenthost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.pojo.RecentHost;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;
import com.smb.framework.web.action.ObjectFactory;

public class RecentHostAddAction extends ActionBase  implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(RecentHostAddAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
 
		RecentHost hostInfo= new RecentHost();
		hostInfo=(RecentHost) ObjectFactory.getObjectFactory(hostInfo, request);
		
	    DescriptionXMLFile.AddMySQLRecentHost(hostInfo);
		
		return  new ModelAndPage("recentHostListAction.do",true);
	}
	

}

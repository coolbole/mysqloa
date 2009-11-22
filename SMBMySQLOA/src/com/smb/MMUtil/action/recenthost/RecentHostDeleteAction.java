package com.smb.MMUtil.action.recenthost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class RecentHostDeleteAction extends ActionBase  implements ControllerAction  {
	private static Log logger = LogFactory.getLog(RecentHostDeleteAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
 
		String id=request.getParameter("id");
		
		DescriptionXMLFile.deleteMySQLRecentHost(id);
		System.out.println ( id );
		
		return  new ModelAndPage("recentHostListAction.do",true);
	}
	

}

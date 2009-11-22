package com.smb.MMUtil.action.recenthost;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class RecentHostListAction extends ActionBase  implements ControllerAction  {
	private static Log logger = LogFactory.getLog(RecentHostListAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		List<?> list=DescriptionXMLFile.getMySQLRecentHost();
		
		request.setAttribute("list", list);
		
		return  new ModelAndPage("/WEB-INF/page/recentHost/RecentHostList.jsp");
	}
	

}

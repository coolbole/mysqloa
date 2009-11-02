package com.smb.framework.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerAction {
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  
				HttpServletResponse response) throws Exception ;
}

package com.smb.MMUtil.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;
import com.smb.framework.web.action.ModelDriven;


public class UsersAction implements ControllerAction, ModelDriven{

	 
	public ModelAndPage handleModelAndPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		MySQLVariableObject  mmm=(MySQLVariableObject) request.getAttribute("modelValue");
		
		System.out.println ("mmm getValue: "+mmm.getValue() );
	 
		
		return new ModelAndPage( request ,"users.jsp" );
	}

	public MySQLVariableObject getModel( ) {
		return null;
	}

}

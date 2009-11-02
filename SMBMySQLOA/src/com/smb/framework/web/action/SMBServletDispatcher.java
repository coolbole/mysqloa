package com.smb.framework.web.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

public class SMBServletDispatcher extends HttpServlet   {
 
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }
	
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
        	String requestURL = request .getRequestURI() ;  // 对应配置文件里面的 url路径
 
        	ControllerAction action=DispatcherUtils.getControllerAction(requestURL);
        	
        	ModelAndPage modelAndPage=action.handleModelAndPage(request,response); 
        	
        	if (modelAndPage.getRedirect()==true){
        		   response.sendRedirect(modelAndPage.getPageName() );
        		}
        	else{
	        	//request.getParameterMap();   //获取页面上传体过来的值.
	        	request.setAttribute("modelValue", modelAndPage.getModelValue()  );  // 
	            RequestDispatcher   requestDispatcher=request.getRequestDispatcher( modelAndPage.getPageName() );   // �����jspҳ��
				requestDispatcher.forward(request,response);
        	}
        	} 
        catch ( Exception e) {
            throw new ServletException(  e );
        }

        
    }
}

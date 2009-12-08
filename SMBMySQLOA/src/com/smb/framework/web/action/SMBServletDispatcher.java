package com.smb.framework.web.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SMBServletDispatcher extends HttpServlet   {
 
	private static final long serialVersionUID = 1L;

	private static  DispatcherUtils  dspatcherUtils= new DispatcherUtils();
	
	public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }
	
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	try {

    		request.setCharacterEncoding("utf-8");
        	response.setCharacterEncoding("utf-8");
        	ControllerAction action=dspatcherUtils.getControllerAction(request);   // 放入 request 对象，进行Action  Mapping 映射
        	
        	ModelAndPage modelAndPage=action.handleModelAndPage(request,response); 
        	
        	if (modelAndPage.getRedirect()==true){
        		   response.sendRedirect(modelAndPage.getPageName() );
        		}
        	else{
	            RequestDispatcher   requestDispatcher=request.getRequestDispatcher( modelAndPage.getPageName() );   // �����jspҳ��
				requestDispatcher.forward(request,response);
        	}
        	} 
        catch ( Exception e) {
            throw new ServletException(  e );
        }

        
    }
}

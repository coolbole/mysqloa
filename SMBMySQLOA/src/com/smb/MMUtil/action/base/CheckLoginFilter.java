package com.smb.MMUtil.action.base;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginFilter     implements Filter {
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
	  
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    
    HttpSession session = req.getSession(true);

    //从session里取的主机名信息
    String host = (String) session.getAttribute("host");
   
    //判断如果没有取到用户信息,就跳转到登陆页面
    if (host == null   && req.getRequestURI().indexOf("MMUPortletAction")==-1 
    		&& req.getRequestURI().indexOf("loginAction")==-1		
    		&& req.getRequestURI().indexOf("recentHost")==-1		
    		
    ) {
    	res.sendRedirect("http://"+req.getHeader("Host")+req.getContextPath()+"/loginAction.do");
    }
    else {
      //已经登陆,继续此次请求
      chain.doFilter(request,response);
    }
  }

  public void destroy() {
  }
} 
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
     <title>Mysql Optimize Analysis</title>
   </head>
  
  <body> 
  <a href="autoCreateConfigList.jsp">返回上一页</a> <br>
    请下载 [<%=request.getAttribute("host")%>] 您的这台机器的配置文件：<br>
    配置信息如下：
     <% 
     //if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
		//    String host=session.getAttribute("host").toString() ;
		//    String username=session.getAttribute("username").toString();
	//	    String password=session.getAttribute("password").toString();
		    
     //String configs=request.getParameter("config");
     //UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
	// IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	 
	 //String MyConfig=mmu.CreateAutoCreateConfig(configs);
	// request.getAttribute("myConfig");
	 out.println( request.getAttribute("myConfig") );
     
     %>
     <br><br>
     <a href="autoCreateConfigList.jsp">返回上一页</a> <br>
     <br>
  </body>
</html>

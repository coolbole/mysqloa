<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.xml.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>Mysql Optimize Analysis</title>
  </head>
  
  <body>
   <a href="optimizeCaseListAction.do">返回上一页</a> <br><br>
  您优化了系统了 [<%=request.getAttribute("host")%>] 里面的如下配置信息：<br><br>
    <% 
		List listS=(List)request.getAttribute("listS");
		for (int i=0;i<listS.size();i++){
			out.println(listS.get(i)+"<br>");
		}
    %>
	  
	  <br>
	
 <br><a href="optimizeCaseListAction.do">返回上一页</a>
  </body>
</html>

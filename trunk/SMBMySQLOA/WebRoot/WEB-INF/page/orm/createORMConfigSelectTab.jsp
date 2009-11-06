<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'createORMConfigSelectTab.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <A HREF="createORMConfigListAction.do">返回</A><br><br>
   <%
   
    	 String createORMID=request.getAttribute("createORMID").toString();
		 String packageName=request.getAttribute("packageName").toString();
		 List showTabs=(List)request.getAttribute("showTabs");
		 
		 
    %>
   	创建类型是: <%=createORMID%><br>
        创建的包名是:<%=packageName%> 
    <br><br>
   选择映射的表 <%=showTabs%>
    
    <br>
  </body>
</html>

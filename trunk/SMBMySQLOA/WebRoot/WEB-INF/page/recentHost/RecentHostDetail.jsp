<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body>
  <A HREF="recentHostListAction.do">返回</A> <br><br>

	<%
	RecentHost recentHostInfo=(RecentHost)request.getAttribute("recentHostInfo");
	%>

 	 
		ID:<%=recentHostInfo.getId()%>"   <br> <br>
		Alias:<%=recentHostInfo.getAlias()%>"   <br> <br>
		ServerIP:<%=recentHostInfo.getServerIP()%>" <br> <br>
		Port:<%=recentHostInfo.getPort()%> <br> <br>
		Username:<%=recentHostInfo.getUsername()%>" <br> <br>
		Password:<%=recentHostInfo.getPassword()%>" <br><br>
		 
 	 <A HREF="recentHostListAction.do">返回</A> <br><br>
 	</body>
 	</html>
 	
 
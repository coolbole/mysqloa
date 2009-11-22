<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body>
  <A HREF="loginAction.do">返回</A> <br><br>


 <A HREF="recentHostAddview.do">添加一台连接主机 </A><br><br><hr>

<%
	List<RecentHost> list=(List)request.getAttribute("list") ;
	for (int i=0; i<list.size();i++){
 %>
 
 	  <A HREF="RecentHost?id=<%=list.get(i).getId()%>"><%=list.get(i).getServerIP()%></A> 
 	    &nbsp;&nbsp;&nbsp;&nbsp;   
 	  (<A HREF="recentHostEditview.do?id=<%=list.get(i).getId()%>">修改</A>  |
 	   <A HREF="recentHostDeleteAction.do?id=<%=list.get(i).getId()%>">删除</A> )
 	  
 	  <br>

 	<%} %>
 	
 	</body>
 	</html>
 	
 	
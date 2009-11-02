<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
<%@page import="com.smb.MMUtil.pojo.monitor.*"%>
<%@page import="com.smb.MMUtil.handler.monitor.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
     <title>Mysql Optimize Analysis</title>
   </head>
  
  <body>
     
     <FORM METHOD="POST" ACTION="monitorHostCRUDAction.do?type=edit">
		<%MySQLMonitorHost hostInfo=(MySQLMonitorHost)request.getAttribute("hostInfo");%>
		<br>
		host:<INPUT TYPE="hidden" NAME="id" value=<%=hostInfo.getId()%>><br>
		host:<INPUT TYPE="text" NAME="host" value="<%=hostInfo.getHost()%>">
		<BR>
		port:<INPUT TYPE="text" NAME="port" value="<%=hostInfo.getPort()%>">
		<BR>
		user:<INPUT TYPE="text" NAME="user" value="<%=hostInfo.getUser()%>">
		<BR>
		pswd:<INPUT TYPE="text" NAME="pswd" value="<%=hostInfo.getPswd()%>">
		<BR>
	 
		<BR>
		<INPUT TYPE="submit">
		<br>
		
		</FORM>
     <br>
  </body>
</html>

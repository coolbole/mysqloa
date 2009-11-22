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

 	<FORM METHOD="post" ACTION="recentHostEditAction.do">
		<INPUT TYPE="hidden" NAME="id"  value="<%=recentHostInfo.getId()%>"  > 
		Alias:<INPUT TYPE="text" NAME="alias"  value="<%=recentHostInfo.getAlias()%>"  > <br>
		ServerIP:<INPUT TYPE="text" NAME="serverIP" value="<%=recentHostInfo.getServerIP()%>"> <br>
		Port:<INPUT TYPE="text" NAME="port" value="<%=recentHostInfo.getPort()%>"> <br>
		Username:<INPUT TYPE="text" NAME="username" value="<%=recentHostInfo.getUsername()%>"> <br>
		Password:<INPUT TYPE="text" NAME="password" value="<%=recentHostInfo.getPassword()%>"> <br><br>
		<INPUT TYPE="submit"  value="修改" >
	</FORM>
 	
 	</body>
 	</html>
 	
 
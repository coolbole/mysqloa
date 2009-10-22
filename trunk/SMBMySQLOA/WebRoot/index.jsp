<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Mysql Optimize Analysis</title>
  </head>
  
  <body>
     <br>
    <FORM METHOD="POST" ACTION="processlist.jsp">
	host:<INPUT TYPE="text" NAME="host" value="<%=request.getServerName()%>"><br>
	username:<INPUT TYPE="text" NAME="username" value="root"><br>
	password:<INPUT TYPE="text" NAME="password" value="123456"><br>
	<INPUT TYPE="submit">
 </FORM>
    
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>

	<body>
		<br>
		<% 
			String err=request.getParameter("err");
			if (err!=null){
				out.println(err);
			}
		%>
		
		<FORM METHOD="POST" ACTION="<%=request.getContextPath()%>/showProcessListAction.do">
			host:<INPUT TYPE="text" NAME="host" value="<%=request.getServerName()%>">   (mysql主机地址)
			<br>
			username:<INPUT TYPE="text" NAME="username" value="root">
			(用户名)
			<br>
			password:<INPUT TYPE="text" NAME="password" value="">
			(密码)
			<br>
			<INPUT TYPE="submit">
		</FORM>

	</body>
</html>

<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
<%@page import="com.smb.MMUtil.handler.monitor.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>

	<body>
	<FORM METHOD=POST ACTION="monitorHostCRUDAction.do?type=add">

		host:<INPUT TYPE="text" NAME="host" value="127.0.0.1">
		<BR>
		port:<INPUT TYPE="text" NAME="port" value="3306">
		<BR>
		user:<INPUT TYPE="text" NAME="user" value="root">
		<BR>
		pswd:<INPUT TYPE="text" NAME="pswd" value="123456">
		<BR>
	 
		<BR>
		<INPUT TYPE="submit">
		<br>
		
		</FORM>
	</body>
</html>

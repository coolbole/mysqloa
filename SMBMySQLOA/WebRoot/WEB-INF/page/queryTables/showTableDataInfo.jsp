<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
<%@page import="com.smb.MMUtil.queryAnalyzer.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>

	<body>
 		<% String DBName=request.getAttribute("DBName").toString();%>
		<br>
		<A HREF="showAllTablesAction.do?DBName=<%=DBName%>">返回</A>
		<br>

		请选择一张表:
		<br>
		<hr>
		<% 
		 
		%>
		 
		
		 <br><br>
		

	</body>

</html>

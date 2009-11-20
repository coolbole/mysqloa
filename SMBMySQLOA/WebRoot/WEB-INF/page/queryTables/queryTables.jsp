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

		<a href="showProcessListAction.do">返回</A>
		<br><br>
		

		请选择一个数据库:<br><hr>
		<%
			List proList = (List) request.getAttribute("dataBasesList");
			int size = proList.size();
			for (int i = 0; i < size; i++) {
				out.println("<br><A HREF='showAllTablesAction.do?DBName="  + proList.get(i)+  "'>" + proList.get(i) + "</A>");
				}
		%>
<jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
	</body>

</html>
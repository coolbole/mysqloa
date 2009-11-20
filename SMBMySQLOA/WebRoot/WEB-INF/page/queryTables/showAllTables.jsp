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
 
		<br>
		<A HREF="showDataBaseAction.do?type=queryTables">返回</A>
		<br>

		请选择一张表:
		<br>
		<hr>
		<%
			String DBName=request.getAttribute("DBName").toString();
			List proList = (List) request.getAttribute("tables");
			int size = proList.size();
			for (int i = 0; i < size; i++) {
				out.println("<A HREF='showTableDataInfoAction.do?DBName="+DBName+"&TabName="  
				+ proList.get(i)+  "'>" + proList.get(i) + "</A><br>");
				}
		%>
		
<jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
	</body>

</html>

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

		<a href="MMUPortletAction.do">返回</A>
		<br><br>
		

		请选择一个数据库:<br><hr>
		<%
			String host=session.getAttribute("host").toString() ;
			out.println("您当前查看的是: "+host+"主机上的 <b>表</b> 使用情况  <br><br>");
			out.println(request.getAttribute("xml"));
		
		
			List<DiskInfoPojo> proList = (List) request.getAttribute("DBTableCounts");
			int size = proList.size();
			
			
			for (int i = 0; i < size; i++) {
				
				out.println("<br><A HREF='showAllTablesAction.do?DBName="  
				+ proList.get(i).getDatabase_Name()+  "'>" + proList.get(i) .getDatabase_Name()+ "</A>"
				+"  ("+ proList.get(i).getTotal_Size()+")"  );
					}
				 
				
		%>
		<br><br>
		<a href="MMUPortletAction.do">返回</A>
		
<jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
	</body>

</html>
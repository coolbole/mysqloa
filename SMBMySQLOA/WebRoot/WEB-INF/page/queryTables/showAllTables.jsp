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
			Map map = (Map) request.getAttribute("tablesRows");
			int size = proList.size();
			for (int i = 0; i < size; i++) {
			 	 
				//if (map.get(proList.get(i) ).toString().indexOf("(0)")==-1 ){
				out.println("<A HREF='showTableDataInfoAction.do?DBName="+DBName+"&TabName="  
				+ proList.get(i)+  "'>" + proList.get(i) + "</A>"+map.get(proList.get(i) )+"<br>");
				// }
				// else{
				// out.println("<b>"+ proList.get(i)+""+map.get(proList.get(i) )+"<br>");
				// }
				  
				 
				 
				}
		%>
		
<jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
	</body>

</html>

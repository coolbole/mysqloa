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
 		<% 
 			String DBName=request.getAttribute("DBName").toString();
 			Integer counts=(Integer)request.getAttribute("counts") ;
 			Integer pages=(Integer)request.getAttribute("pages") ;
 		%>
		<br>
		<A HREF="showAllTablesAction.do?DBName=<%=DBName%>">返回</A>
		<br>

		您当前选择的表 <%=request.getAttribute("TabName")%>:
		<br>
		<br>
		一共有<%=counts%>条数据 ， <%=pages%>页  ，每页只显示1000条数据。
		<table width="98%" border="1" cellpadding="0" bordercolorlight="#999999" 
			   bordercolordark="#FFFFFF" cellspacing="0" style="font-size: 13px" > 
		<% 
		 List proList = (List) request.getAttribute("tables");
		 	int size = proList.size();
			for (int i = 0; i < size; i++) {
				out.println(proList.get(i));
				}
		%>
		 </table>
		 
		
		 <br><br>
		
	<jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
	</body>

</html>

<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
<%@page import="com.smb.MMUtil.queryAnalyzer.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>

	<body>
		
	  <A HREF="showProcessListAction.action">返回</A>
		 
		您执行的SQL语句是：<b><%=request.getAttribute("sql")%></b><br><br>


		<% 
		try{
		if (request.getAttribute("count")!=null)
			out.print ("您查询的记录一共有"+request.getAttribute("count")+"条");
		%><br> 
		
		
		<% if (request.getAttribute("columns")!=null){	%>
		<table width="98%" border="1" cellpadding="0" bordercolorlight="#999999" bordercolordark="#FFFFFF" cellspacing="0" style="font-size: 13px" > 
		<%
			List list =(List)request.getAttribute("columns");
			for (int i=0;i<list.size();i++){
				String value=list.get(i).toString();
				out.println (value );
			}
			}
		%> 
		<% 
		if (request.getAttribute("values")!=null){
			List list =(List)request.getAttribute("values");
			for (int i=0;i<list.size();i++){
				String value=list.get(i).toString();
				out.println (value );
			}
			}
		
		
		}
		catch (Exception e){
			out.println("请注意，您执行了一条错误的SQL语句 ： "+ request.getAttribute("err")  );
			e.printStackTrace();
			
			}
		%>
		</TABLE>
		
		<%=request.getAttribute("SQLCount")%><br><br>
		
		 
		
		
		
		
		<br>
	</body>
</html>

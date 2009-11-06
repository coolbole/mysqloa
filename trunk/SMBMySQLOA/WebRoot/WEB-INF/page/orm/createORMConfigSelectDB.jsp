<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>
	<body>
		<A HREF="createORMConfigListAction.do">返回</A>
		<br>
		<br>
		
		请选择数据库：<br><hr>
		
	<FORM METHOD="POST" ACTION="createORMConfigSelectTabAction.do">
	
		<%
		List list=(List)request.getAttribute("showDataBases");
			for (int i=0;i<list.size();i++){%>
			<INPUT TYPE="radio" NAME="DBName" value="<%=list.get(i)%>" checked> <%=list.get(i)%>
			<br>
			<%} %> 
		 
		 	<br><br>
			
		 
			<INPUT TYPE="text" NAME="packageName" value="<%=request.getAttribute("packageName")%>">
			<INPUT TYPE="text" NAME="createORMID" value="<%=request.getAttribute("createORMID")%>">
			
			<br><br>
			
			<INPUT TYPE="submit" name="生成配置文件" value="下一步">
	
		</FORM>
		 
		 
		 
	</body>
</html>

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
  <A HREF="createORMConfigListAction.do">返回</A><br><br>
   <%
   
    	 String createORMID=request.getAttribute("createORMID").toString();
		 String packageName=request.getAttribute("packageName").toString();
		 List <TableStatusPojo> showTabs=(List)request.getAttribute("showTabs");
		 
		 
    %>
   	创建类型是: <%=createORMID%><br>
           创建的包名是:<%=packageName%> 
    <br><br>
   选择映射的表：<br><br>
    <%
   	for (int i=0;i<showTabs.size();i++){
   	%>
   		<INPUT TYPE="checkbox" NAME="tab" vaule="<%=showTabs.get(i).getName()%>" checked > <%=showTabs.get(i).getName()%><br>
   	<%}%>
   
   
    
    
    <br>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.xml.*"%>
 <%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> processlist.jsp  starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body> 
  
 
	

    <% 
    String value=request.getParameter("value");
    String variable_name=request.getParameter("variable_name");
    
    
    String host=session.getAttribute("host").toString() ;
    String username=session.getAttribute("username").toString();
    String password=session.getAttribute("password").toString();
    
    UtilBaseTools orm= new UtilBaseTools(host,username,password);
	IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	
	//ReadMySQLValueDescriptionXMLFile  DescriptionXMLFile= new ReadMySQLValueDescriptionXMLFile();
	//List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
	
	mmu.setVariblesCommandByCategory( variable_name , value );
	
    %>
    
    <a href="showVariblesByCategory.jsp?category=<%=request.getParameter("category")%>">返回</a>
    
    
       <%
       String url="showVariblesByCategory.jsp?category="+request.getParameter("category");
       
       	response.sendRedirect(   url  );
       
       
        %>
     <br>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.xml.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
      <title>Mysql Optimize Analysis</title>
  </head>
  
  <body>  
  <a href="deepOptimizeCaseListAction.do?step=2">返回上一页</a> <br> <br>
  
  	第3步
  <FORM METHOD="POST" ACTION="deepOptimizeCaseListAction.do?step=4">
    	
    <% 
    		List <MySQLDeepOptimize>list=(List)request.getAttribute("listF");
    		for (int i=0;i<list.size();i++)  
    	{%>
    	
    <INPUT TYPE='checkbox' NAME='optimizeName' value='<%=list.get(i).getQuestionID()%>'>
    <%=list.get(i).getQuestionTitle()%><br> <br> 
    <%}%>
    
         
    <INPUT TYPE="submit" value="完成"   >
</FORM>

 <a href="deepOptimizeCaseListAction.do?step=2">返回上一页</a> <br>
 <br>
  </body>
</html>

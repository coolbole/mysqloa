<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.xml.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
      <title>Mysql Optimize Analysis</title>
  </head>
  
  <body>  
  <a href="deepOptimizeCaseListAction.do?step=1">返回上一页</a> <br> <br>
  
  	<b>  第二步</b>
 
 	 <FORM METHOD="POST" ACTION="deepOptimizeCaseListAction.do?step=3">
    	
      	<% 
    		List <MySQLDeepOptimize>list=(List)request.getAttribute("listF");
    		for (int i=0;i<list.size();i++)  
    	{%>
    	
    <INPUT checked TYPE='checkbox' NAME='optimizeName' value='<%=list.get(i).getQuestionID()%>'>
    <%=list.get(i).getQuestionTitle()%><br> <br> 
     <%}%>
    
     
    <INPUT TYPE="submit" value="下一步" name="下一步" >
</FORM>

 <a href="deepOptimizeCaseListAction.do?step=1">返回上一页</a> <br>
 <br>
 
 <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>

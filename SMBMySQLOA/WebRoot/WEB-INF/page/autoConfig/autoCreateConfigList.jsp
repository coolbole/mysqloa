<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
     <title>Mysql Optimize Analysis</title>
   </head>
  
  <body> 
  <a href="MMUPortletAction.do">返回上一页</a> <br>
    您的这台机器是：<br>
   <FORM METHOD=POST ACTION="autoCreateConfigAction.do">
   <INPUT TYPE='radio' checked NAME='config' value="2g"/>2G内存<br>
   <INPUT TYPE='radio'  NAME='config' value="4g"/>4G内存<br>
   <INPUT TYPE="submit">
   <!--
	  <INPUT TYPE='radio'  NAME='config' value="8"/>8G内存<br>
	  <INPUT TYPE='radio'  NAME='config' value="16"/>16G内存<br>
   --> 
   
    </FORM><br>
    <a href="MMUPortletAction.do">返回上一页</a> <br>
     <br>
     
     <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>

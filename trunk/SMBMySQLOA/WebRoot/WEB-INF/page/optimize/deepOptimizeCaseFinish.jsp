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
  <a href="showProcessListAction.do">返回首页</a> <br> <br>
  
    完成，您优化了MySQL很多参数。。。。。。。<br>
    详细内容如下：<br><hr>

	<%
	
	List <MySQLDeepOptimize> list=(List)request.getAttribute("deepOptimizeCommand");
	
		for (int i=0;i<list.size();i++){
			out.println(list.get(i).getQuestionID()+"   "+list.get(i).getQuestionTitle()+"<br> 调用 "+list.get(i).getExecuteCommand()+" 命令<br><br>");
		}
	%>
    
    <br><br>
 <a href="showProcessListAction.do">返回首页</a> <br>
 <br>
  </body>
</html>

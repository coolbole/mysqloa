<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.testcase.timer.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.monitor.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>
<body>

 <A HREF="showProcessListAction.do">返回</A> <br><br>
<% 
	 try{ 
	 	boolean isrun=TimerTaskPool.getRunStatus();
	 	if (isrun==true){
		  	out.println(TimerTaskPool.getTimeFrequency()+"<br>");
		 	out.println(TimerTaskPool.getRunStatus());
	 	}
	 	else{
	 	out.println("当前检测工作没有运行");
	 	}
	 	
	 }
	 catch (Exception e){
		 e.printStackTrace();
	 }
%>


 <FORM METHOD="POST" ACTION="timerSetUpAction.do">
	<INPUT TYPE="text" NAME="time" value="">(输入-1 表示停止,输入1表示一分钟)<br><br>
 	<INPUT TYPE="submit" name="提交">
 </FORM>
 </body>
 
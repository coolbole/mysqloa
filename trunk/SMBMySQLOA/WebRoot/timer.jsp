<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.testcase.timer.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>


<% 
	String time=request.getParameter("time");
	 TimerTaskPool pool= new TimerTaskPool();
	 try{ 
	 pool.execute(time);
	 }
	 catch (Exception e){
	 e.printStackTrace();
	 }
	
	 
	
%>
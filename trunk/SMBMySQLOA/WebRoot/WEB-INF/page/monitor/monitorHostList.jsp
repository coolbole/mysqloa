<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.monitor.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>
  
  <body>
     <A HREF="showProcessListAction.do">返回</A> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     
  	 <A HREF="monitorHostCRUDAction.do?type=addView">添加被监控主机</A><br><br> 
  	  
  	
  	  
    <%
   		 List <MySQLMonitorHost> list=(List)request.getAttribute("listF");
   		 int size=list.size();
   		 if (size==0){
   		  	 out.println (" 您还没有指定被监控的MySQL服务器<br>" );
   		 }
   		 else{
	   		 for (int i=0;i<list.size();i++){
	   		 if (list.get(i).getId()!=null){
		   		 out.println ( "<A HREF='viewDetailHost.do?HostID="
		   		 +list.get(i).getId()+"'>" +list.get(i).getHost()+" </A>&nbsp;&nbsp;&nbsp;" );
		   		 
		   		 out.println ( "<A HREF='monitorHostCRUDAction.do?type=editView&HostID="
		   		 +list.get(i).getId()+"'>修改</A>&nbsp;&nbsp;" );
		   		 
		   		 out.println ( "<A HREF='monitorHostCRUDAction.do?type=delete&HostID="
		   		 +list.get(i).getId()+"'>删除</A><br>" );
	   		 	}
	   		 }
   		 }
     %>
     
     
     <br>
  </body>
</html>

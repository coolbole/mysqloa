<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body>
  <A HREF="showProcessListAction.do">返回</A> <br><br>
  
   
    <% 
    	try{
		 	String host=session.getAttribute("host").toString() ;
		 	Object actionType=request.getAttribute("actionType")  ;
		    out.println("您当前查看的主机是: "+host+" <br>");
			List proList=(List)request.getAttribute("dataBasesList");
			int size=proList.size();

	 		out.println("<b>请选择一个数据库：</b> <br><hr>");
			for (int i=0;i<size;i++){
			if (actionType.equals("index")){
			out.println("<A HREF='showEveryTableIndexStatusAction.do?actionType=index&DBName="+ proList.get(i)+
		 	 		"'><span style='color: blue;'><b>"+ proList.get(i)+"</span></A><br>");
			}
			else{
		 	 out.println("<A HREF='showEveryTableStatusAction.do?actionType=everytable&DBName="+ proList.get(i)+
		 	 		"'><span style='color: blue;'><b>"+ proList.get(i)+"</span></A><br>");
			 }
			 
			} // for 
		}  // try 
		catch (Exception e){e.printStackTrace(); }
    %>
   
    
    
    <br><br>
      <A HREF="showProcessListAction.do">返回</A> <br><br>
     <br>
  </body>
</html>

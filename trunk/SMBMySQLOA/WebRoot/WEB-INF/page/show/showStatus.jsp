<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.xml.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>
	<%
	
	
	%>



  <body> 
  <CENTER>
    <b><FONT SIZE="6" COLOR="#336600">查看 MySQL数据库当前 <%=request.getAttribute("category")%>使用 状态 </FONT></b>
  </CENTER>
  <%=request.getAttribute("warn")%>
  <br>
  <A HREF="showProcessListAction.do">返回</A> <br>
  	
    <% 
	
		List <MySQLVariableObject> listS=(List)request.getAttribute("listS");
		List <MySQLVariableDescription> listF=(List)request.getAttribute("listF");
		 
	
		for (int i=0;i<listS.size();i++){
				
		 for (int h=0;h<listF.size();h++){
		 if(	listS.get(i).getVariable_name().equals(listF.get(h).getVariable_name() ) ){
			 out.print (listS.get(i).getVariable_name()+"   "  ); 
			 out.print ("<b>"+listS.get(i).getValue()+"</b>  "  ); 
		     out.print ("<FONT SIZE='2' COLOR='#006666'> "+listF.get(h).getDescription() +" </FONT>  <br><br>"  ); 
		 }
		 }
	}
	 
   %>
     <A HREF="showProcessListAction.do">返回</A> <br>
     
     <br>
  </body>
</html>
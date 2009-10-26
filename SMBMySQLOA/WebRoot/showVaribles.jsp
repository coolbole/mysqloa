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
 <CENTER>
    <b><FONT SIZE="6" COLOR="#993333">查看 MySQL数据库 当前所有配置参数  </FONT></b>
  </CENTER>
  
  <a href="showProcessListAction.action">返回</a> <br>
    <% 
	
	List <MySQLVariableObject> listS=(List)request.getAttribute("listS");
	List <MySQLVariableDescription> listF=(List)request.getAttribute("listF");
		
		for (int i=0;i<listS.size();i++){
				
		for (int h=0;h<listF.size();h++){
		if(	listS.get(i).getVariable_name().equals(listF.get(h).getVariable_name() ) ){
			 out.print (listS.get(i).getVariable_name()+"   "  ); 
			 out.print ("<b>"+listS.get(i).getValue()+"</b>   "  ); 
			 out.print ("<FONT SIZE='2' COLOR='#006666'> "+listF.get(h).getDescription() +" </FONT>  <br><br>"  ); 
		}
		}
	}
    %>
     <a href="showProcessListAction.action">返回</a> <br>
     <br>
  </body>
</html>

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
  <a href="showProcessListAction.action">返回上一页</a> <br>
  <FORM METHOD="POST" ACTION="optimizeCase.action">
    <% 
      ReadMySQLConfigXMLFile  DescriptionXMLFile= new ReadMySQLConfigXMLFile();
	List <MySQLOptimizeCase>listF=DescriptionXMLFile.getMySQLOptimizeCase();
	
		for (int i=0;i<listF.size();i++){
			 out.println("<INPUT TYPE='radio' checked NAME='OptimizeCaseAlias' value='"
			 		+listF.get(i).getAlias()+"' >"+listF.get(i).getName()+"<br>");
		}
	
    %> 	
    <INPUT TYPE="submit">
</FORM>

 <br>
  </body>
</html>

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
  <a href="showProcessListAction.do">返回上一页</a> <br> <br>
  <FORM METHOD="POST" ACTION="optimizeCaseAction.do">
    	
    	
    <INPUT TYPE='radio' checked NAME='OptimizeCaseAlias' value='2g' >2G内存优化方案<br>
    	
    <% 
    	List listF=(List)request.getAttribute("listF");
		for (int i=1;i<listF.size();i++){
		MySQLOptimizeCase  caselist=(MySQLOptimizeCase) listF.get(i);
		
		out.println("<INPUT TYPE='radio'  NAME='OptimizeCaseAlias' value='"
			 		+caselist.getAlias()+"' >"+caselist.getName()+"<br>");
		}
	
    %> 	
    <INPUT TYPE="submit">
</FORM>

 <a href="showProcessListAction.do">返回上一页</a> <br>
 <br>
 
 <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>

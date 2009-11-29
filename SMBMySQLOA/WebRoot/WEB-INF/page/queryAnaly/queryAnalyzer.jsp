<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
<%@page import="com.smb.MMUtil.queryAnalyzer.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
   </head>
  
  <body>
  
   <a href="MMUPortletAction.do">返回</A><br><br>
   
		<FORM METHOD="post" ACTION="queryAnalyzerAction.do">
		 <SELECT NAME="DBName">
			<OPTION value="#">--请选择一个数据库--</OPTION>
			<% 
			List proList=(List)request.getAttribute("dataBasesList");
			int size=proList.size();
			 for (int i=0;i<size;i++){
			 out.println("<OPTION>"+proList.get(i)+"</OPTION>");
			   }
			 %>
 		</SELECT>
 		<br>
		<TEXTAREA NAME="SQL" ROWS="11" COLS="50">select  * from  </TEXTAREA> <br>
		<INPUT TYPE="submit">
		</FORM>

<br><br>
<a href="MMUPortletAction.do">返回</A><br><br>
 <br>
 <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>

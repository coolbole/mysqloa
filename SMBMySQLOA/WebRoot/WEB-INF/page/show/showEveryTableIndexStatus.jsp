<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
 <%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body>
  <A HREF="showDataBaseAction.do?type=index">返回</A> <br><br>
  
    <% 
    	 try{
		    out.println("您查看的是: "+request.getAttribute("host")+" 主机上的，索引状态<br>");
			List <MySQLTableIndex> proList=(List)request.getAttribute("proList");
			int size=proList.size();
			out.println(request.getAttribute("uptime")+"<br><br>"  );
			 
		%>
		
	
		<table width="98%" border="1" cellpadding="0" bordercolorlight="#999999" 
				bordercolordark="#FFFFFF" cellspacing="0" style="font-size: 13px" > 
		<TR>
			<TD><b>数据库名 </b></TD>
			<TD><b>表名  </b></TD>
			<TD><b>字段名</b></TD>
			<TD><b>索引类型</b></TD>
			 
		</TR>

		<% 
			for (int i=0;i<size;i++){
			 MySQLTableIndex table=(MySQLTableIndex)proList.get(i);
		%>
			<TR>
			<TD><%=table.getCONSTRAINT_SCHEMA()%> </TD>
			<TD><%=table.getTABLE_NAME()%> </TD>
			<TD><%=table.getCOLUMN_NAME()%> </TD>
			<TD><%=table.getCONSTRAINT_NAME()%> </TD>
			 
			</TR>
		
		<% 
			} // for 
		}  // try 
		catch (Exception e){e.printStackTrace(); }
    %>
    </TABLE>
    
    
    <br><br>
      <A HREF="showDataBaseAction.do?type=index">返回</A> <br><br>
     <br>
  </body>
</html>

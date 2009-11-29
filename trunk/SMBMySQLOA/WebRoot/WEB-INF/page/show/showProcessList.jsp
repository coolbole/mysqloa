<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
     <meta http-equiv="refresh" content="3;url=showProcessListAction.do">
  </head>

  <body>
  <A HREF="MMUPortletAction.do">返回</A> <br><br>
   
    
    <% 		for (int k=0;k<2;k++){%>
    
		
		<table width="85%" border="1" cellpadding="0" bordercolorlight="#999999" bordercolordark="#FFFFFF" cellspacing="0"  > 
		<TR>
			<TD>连接编号</TD>
			<TD>连接用户</TD>
			<TD>连接主机名称(ip地址)</TD>
			<TD>连接的数据库</TD>
			<TD>连接所用时间</TD>
			<TD>连接信息</TD>
			<TD>连接执行命令</TD> 
			<TD>连接状态</TD>
			<TD>Kill进程</TD>
			 
		</TR>
<br><br> 
		<% 
			if (k!=0){
			out.println("<hr>");
			}
			out.println("这台机器的MySQL版本是: "+request.getAttribute("version")+" <br>");
		    out.println("您当前查看的主机是: "+request.getAttribute("host")+" ");
			List proList=(List)request.getAttribute("proList");
			int size=proList.size();
			out.println(request.getAttribute("uptime")+"<br> 当前一共有: "+size+"  个连接 <br><br> ");
			
			
			for (int i=0;i<size;i++){
			MySQLShowProcessList  plist=(MySQLShowProcessList)proList.get(i);
		%>
			<TR>
			<TD><%=plist.getId()%></TD>
			<TD><%=plist.getUser()%></TD>
			<TD><%=plist.getHost()%> &nbsp;</TD>
			<TD><%=plist.getDb()%></TD>
			<TD><%=plist.getTime()%></TD>
			<TD><%=plist.getInfo()%></TD>
			<TD><%=plist.getCommand()%></TD>
			<TD><%=plist.getState()%>&nbsp;</TD>
			<TD><A HREF="killConnectionProcessAction.do?ConnectionID=<%=plist.getId()%>&type=proceeslist">Kill(杀) </A></TD>
			</TR>
		
		<% 
			} // for 
		}  // try 
		 
    %>
    </TABLE>
    <br>
     <A HREF="MMUPortletAction.do">返回</A> <br><br> 
    
     <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>

<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body>
  <A HREF="logoutAction.do">退出</A> <br><br>
  
  <%
   		out.println("这台机器的MySQL版本是: "+request.getAttribute("version")+" <br>");
		out.println("您当前查看的主机是: "+request.getAttribute("host")+"  ");
		out.println(request.getAttribute("uptime")+"<br>");
  		out.println( request.getAttribute("xml")  );
  
  
  %><br>
  
  <TABLE width="1051" height="200">
<TR>
	<!-- 1 -->
	<TD>
	<A HREF="showVariblesAction.do"><span style='color: blue;'>查看系统当前所有配置参数</span></A>    <br>
  	<A HREF="showVariblesByCategoryAction.do?category=innodb"><span style='color: blue;'>查看系统当前 Innodb 属性的所有配置参数</span></A><br>
  	<A HREF="showVariblesByCategoryAction.do?category=time"><span style='color: blue;'>查看系统当前 Time 属性的所有配置参数</span></A><br>
  	<A HREF="showVariblesByCategoryAction.do?category=cache"><span style='color: blue;'>查看系统当前  缓存 属性的所有配置参数</span></A><br>
  	<A HREF="showVariblesByCategoryAction.do?category=log"><span style='color: blue;'>查看系统当前  日志 属性的所有配置参数</span></A><br>
  	<A HREF="showVariblesByCategoryAction.do?category=buffer"><span style='color: blue;'>查看系统当前  缓冲 属性的所有配置参数</span></A><br>
  	<A HREF="showVariblesByCategoryAction.do?category=max"><span style='color: blue;'>查看系统  Max状态 属性的所有配置参数</span></A><br>
  	</TD>
  	<!-- 1 -->
  	
  	<!-- 2 -->
	<TD>
	<A HREF="showSatusAction.do"><span style='color:green;'>查看系统当前所有状态</span></A>  <br> 
   <A HREF="showSatusAction.do?category=innodb"><span style='color:green;'>查看系统当前 Innodb 状态</span></A> <br>
   <A HREF="showSatusAction.do?category=select"><span style='color:green;'>查看系统当前 SELECT查询语句使用的状态</span></A> <br>
   <A HREF="showSatusAction.do?category=sort"><span style='color:green;'>查看系统当前Sort排序语句使用的状态</span></A> <br>
   <A HREF="showSatusAction.do?category=cache"><span style='color:green;'>查看系统当前 缓存 使用的状态</span></A> <br>
   <A HREF="showSatusAction.do?category=buffer"><span style='color:green;'>查看系统当前Buffer 使用的状态</span></A> <br>
   <A HREF="showSatusAction.do?category=log"><span style='color:green;'>查看系统当前日志 使用的状态</span></A> <br>
	</TD>
	<!-- 2 -->
	
 
<!-- 3 -->
	<TD>
	<br><A HREF="showProcessListAction.do"><span style='color:#669900;'><b>查看连接状态</b></span></A> <br> 
   	<b><A HREF="showDataBaseAction.do?type=queryAnalyzer"><span style='color:#669900;'>执行SQL分析器</span></A></b><br>
   	<A HREF="showDataBaseAction.do?type=queryTables"><span style='color:#669900;'><b>查看数据库表数据</b></span></A> <br>
  	<A HREF="showDataBaseAction.do?type=everytable"><span style='color:#669900;'><b>查看系统每个表使用的状况</b></span></A><br>
   	<A HREF="showDataBaseAction.do?type=index"><span style='color:#669900;'><b>查看每个数据库的索引状态</b></span></A><br><A HREF="showReplicationAction.do"></A><br><br>
   	</TD>
   	<!-- 3 -->
	<TD><b><a href="showOpenTablesAction.do"><span style='color:blue;'>最近被使用过的表</span></a></b><br>
   	<a href="deepOptimizeCaseListAction.do?step=1"><span style="color: blue;"><b>根据您的业务深度快速优化</b>&nbsp; </span></a><br>
   	<a href="optimizeCaseListAction.do"><span style="color: blue;"><b>快速一键优化</b> </span></a>
   	<br><a href="autoCreateConfigListAction.do"><span style="color: blue;"><b>根据机器配置生成配置文件</b>&nbsp; </span></a>
   	<br><strong><a href="showReplicationAction.do"><span style="color: blue;">查看同步数据状态</span></a></strong>
   	</TD>
   	
</TR>
</TABLE>
  
  
  
   
   
   
   <!-- 
   <A HREF="showTableDataInfoAction.do?DBName=mysql&TabName=help_topic">
	   		<span style='color:#FF0000;'><b>MySQLHelp</b></span>
   </A><br> <br>
    -->
   
   
    <!-- 
	   <A HREF="createORMConfigListAction.do">
	   		<span style='color:#FF0000;'><b>自动生成(Hibernate/iBATIS/Spring)配置文件</b></span>
	   </A> <br> <br> <br>
   
  
	   <A HREF="drangTestList.do">
	   		<span style='color:#336600;'><b>压力测试</b></span>
	   </A> <br> <br> <br>
    -->
    

   
   <!-- 
   <A HREF="mailHostConfigViewAction.do">配置发送报告的邮件服务器</A>&nbsp;&nbsp;&nbsp;&nbsp;
   <A HREF="timerStatusViewAction.do"><b><span style='color:green;'>配置系统定时器检测时间周期</span></b></A>&nbsp;&nbsp;&nbsp;&nbsp;
   <A HREF="monitorHostListAction.do">查看当前被监控的MySQL服务器</A><br><br>
    -->
   
    <% 
    	try{
		   
			List proList=(List)request.getAttribute("proList");
			int size=proList.size();
			out.println("<br> 当前一共有: "+size+"  个连接 <br><p>");
		%>
		
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

		<% 
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
			<TD><A HREF="killConnectionProcessAction.do?ConnectionID=<%=plist.getId()%>&type=main" > Kill(杀) </A></TD>
			</TR>
		 
		<% 
			} // for 
		}  // try 
		catch (Exception e){e.printStackTrace(); }
    %>
    </TABLE>
    <br>
      <A HREF="logoutAction.do">退出</A>  
    
     <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>

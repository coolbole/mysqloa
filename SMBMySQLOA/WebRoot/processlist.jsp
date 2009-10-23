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
  <A HREF="index.jsp">退出</A> <br><br>
  
  <A HREF="showVaribles.jsp">查看系统当前所有配置参数</A>    <br>
  <A HREF="showVariblesByCategory.jsp?category=innodb">查看系统当前 Innodb 属性的所有配置参数</A><br>
  <A HREF="showVariblesByCategory.jsp?category=time">查看系统当前 Time 属性的所有配置参数</A><br>
  <A HREF="showVariblesByCategory.jsp?category=cache">查看系统当前  缓存 属性的所有配置参数</A><br>
   
   
   <br><br><br>
   <A HREF="showStatus.jsp">查看系统当前所有状态</A>  <br> 
   <A HREF="showStatus.jsp?category=innodb">查看系统当前 Innodb 状态</A> <br>
   <A HREF="showStatus.jsp?category=select">查看系统当前 select查询语句使用的状态</A> <br>
   <A HREF="showStatus.jsp?category=sort">查看系统当前sort排序语句使用的状态</A> <br>
   <A HREF="showStatus.jsp?category=cache">查看系统当前 缓存 使用的状态</A> <br>
   <A HREF="showStatus.jsp?category=buffer">查看系统当前buffer 使用的状态</A> <br>
   <br><br>
   
   <A HREF="showDataBase.jsp">查看系统每个表使用的状况</A><br><br>
  
   <A HREF="#">查看同步数据状态(后续开发)</A><br><br>
   
   
    <% 
    	try{
	    String Rhost=request.getParameter("host");
	    String Rusername=request.getParameter("username");
	    String Rpassword=request.getParameter("password");
	    
	    
	    session.setMaxInactiveInterval(-1);
	    session.setAttribute("host",Rhost);
	    session.setAttribute("username",Rusername); 
	    session.setAttribute("password",Rpassword); 
	    
	    if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
		    String host=session.getAttribute("host").toString() ;
		    String username=session.getAttribute("username").toString();
		    String password=session.getAttribute("password").toString();
		    
		    out.println("您当前查看的主机是: "+host+" ");
		    
		    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
			IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
			List proList=mmu.showProcesslistCommand();
			
			int size=proList.size();
			out.println(mmu.showUptime()+"<br> 当前一共有: "+size+"  个连接 <br><p>");
		%>
		
		<table width="78%" border="1" cellpadding="0" bordercolorlight="#999999" bordercolordark="#FFFFFF" cellspacing="0"  > 
		<TR>
			<TD>连接编号</TD>
			<TD>连接主机名称(ip地址)</TD>
			<TD>连接的数据库</TD>
			<TD>连接所用时间</TD>
			<TD>连接信息</TD>
			<TD>连接执行命令</TD> 
		</TR>

		<% 
			for (int i=0;i<size;i++){
			MySQLShowProcessList  plist=(MySQLShowProcessList)proList.get(i);
		%>
			<TR>
			<TD><%=plist.getId()%></TD>
			<TD><%=plist.getHost()%> &nbsp;</TD>
			<TD><%=plist.getDb()%></TD>
			<TD><%=plist.getTime()%></TD>
			<TD><%=plist.getInfo()%></TD>
			<TD><%=plist.getCommand()%></TD>
			</TR>
		
		<% 
			} // for 
		}  // try 
		catch (Exception e){e.printStackTrace(); }
    %>
    </TABLE>
    
    
    <br><br>
      <A HREF="index.jsp">退出</A> <br><br>
     <br>
  </body>
</html>

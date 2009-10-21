<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
 <%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'processlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body>
  
  <A HREF="showVaribles.jsp">查看系统当前所有配置参数</A>    <br>
  <A HREF="showVariblesByCategory.jsp?category=innodb">查看系统当前 Innodb 属性的所有配置参数</A><br>
   <A HREF="showVariblesByCategory.jsp?category=time">查看系统当前 Time 属性的所有配置参数</A><br>
   
   <br><br><br>
   
   
    <% 
    String Rhost=request.getParameter("host");
    String Rusername=request.getParameter("username");
    String Rpassword=request.getParameter("password");
    
    session.setAttribute("host",Rhost);
    session.setAttribute("username",Rusername);
    session.setAttribute("password",Rpassword);
    
    String host=session.getAttribute("host").toString() ;
    String username=session.getAttribute("username").toString();
    String password=session.getAttribute("password").toString();
    
    out.println("您当前查看的主机是: "+host+"<br><p>");
    
    UtilBaseTools orm= new UtilBaseTools(host,username,password);
	IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	List proList=mmu.showProcesslistCommand();
	
	for (int i=0;i<proList.size();i++){
	MySQLShowProcessList  plist=(MySQLShowProcessList)proList.get(i);
		out.print( plist.getId() );out.print( plist.getHost() );out.print( plist.getTime() );
		out.println( plist.getHost()+"<br>" );
	}
    %>
    
     <br>
  </body>
</html>

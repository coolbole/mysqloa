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
  
  <A HREF="showVaribles.jsp">查看系统当前所有配置参数</A>    <br>
  <A HREF="showVariblesByCategory.jsp?category=innodb">查看系统当前 Innodb 属性的所有配置参数</A><br>
  <A HREF="showVariblesByCategory.jsp?category=time">查看系统当前 Time 属性的所有配置参数</A><br>
   
   <br><br><br>
   <A HREF="showStatus.jsp">查看系统当前所有状态</A>  <br> 
   <A HREF="showStatus.jsp?category=innodb">查看系统当前 Innodb状态</A> 
   <br>
   
   <A HREF="#">查看同步数据状态</A>
   
   
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
	    
	    UtilBaseTools orm= new UtilBaseTools(host,username,password);
		IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		List proList=mmu.showProcesslistCommand();
		
		int size=proList.size();
		out.println("当前一共有: "+size+"  个连接 <br><p>");
		
		for (int i=0;i<size;i++){
		MySQLShowProcessList  plist=(MySQLShowProcessList)proList.get(i);
			out.print( plist.getId() );out.print( plist.getHost() );
			out.print( "  Time : "+plist.getTime() );
			out.println( plist.getHost()+"<br>" );
		}
		}
	catch (Exception e){
	
		System.out.println("sadsadsadsadasd"+e);
		e.printStackTrace();
		}

    %>
    
     <br>
  </body>
</html>

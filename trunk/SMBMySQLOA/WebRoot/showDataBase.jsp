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
  
   
    <% 
    	try{
	    if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
		    String host=session.getAttribute("host").toString() ;
		    String username=session.getAttribute("username").toString();
		    String password=session.getAttribute("password").toString();
		    
		    out.println("您当前查看的主机是: "+host+" <br>");
		    
		    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
			IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
			List proList=mmu.showDataBases();
			
			int size=proList.size();
			 
	 		out.println("<b>请选择一个数据库：</b> <br><hr>");
			for (int i=0;i<size;i++){
			
		 	 out.println("<A HREF='showEveryTableStatus.jsp?DBName="+ proList.get(i)+"'><span style='color: blue;'><b>"+ proList.get(i)+"</span></A><br>");
			 
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

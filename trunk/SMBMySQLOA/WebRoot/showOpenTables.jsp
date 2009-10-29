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
  <A HREF="showProcessListAction.action">返回</A> <br><br>
  
   
    <% 
    	try{
    		out.println( request.getAttribute("uptime") );
    	
		 	String host=session.getAttribute("host").toString() ;
		    out.println("您当前查看的主机是: "+host+"<br> <hr>");
			List <MySQLOpenTables> proList=(List)request.getAttribute("proList");
			int size=proList.size();
	 		%>
	 		<%
	 		int count=0;
			for (int i=0;i<size;i++){
			  if(proList.get(i).getDatabase().equals("mysql")){
			 	 count=count +1;
		 	  }
		 	  else{
		 	   out.println( proList.get(i).getDatabase());
			   out.println( proList.get(i).getTable());
			   out.println( proList.get(i).getIn_use());
			   out.println( proList.get(i).getName_locked()+"<br>");
			 }
		 	 
			 
			} // for 
			count=size -count;
			if (count==0){
				out.println( " 最近没有被打开过的表" );
				}
			else{
				out.println( "<br>您最近有"+count+"个被打开过的表" );
			}
		}  // try 
		catch (Exception e){e.printStackTrace(); }
    %>
    </TABLE>
    
    
    <br><br>
      <A HREF="showProcessListAction.action">返回</A> <br><br>
     <br>
  </body>
</html>

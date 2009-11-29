<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
<%@page import="com.smb.MMUtil.handler.base.CommonTools"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body>
  <A HREF="MMUPortletAction.do">返回</A> <br><br>
  
   
    <% 
    	try{
		 	String host=session.getAttribute("host").toString() ;
		 	Object actionType=request.getAttribute("actionType")  ;
		    out.println("您当前查看的是: "+host+"主机上的 <b>磁盘</b> 使用情况  <br><br>");
			List <DiskInfoPojo> proList=(List)request.getAttribute("dataBasesList");
			int size=proList.size();

			out.println(request.getAttribute("xml"));

	 		out.println("<br><b>请选择一个数据库：</b> <br><hr><br>");
			for (int i=0;i<size;i++){
			 
		 	 out.println("<A HREF='showEveryTableStatusAction.do?actionType=everytable&DBName="+ proList.get(i).getDatabase_Name()+
		 	 		"'><span style='color: blue;'><b>"+ proList.get(i).getDatabase_Name()+"</span></A>");
			 
			 out.println("数据数量:"+ proList.get(i).getRows()  +" 条 | " );
			 
			 out.println("数据容量:"+CommonTools.convCapacityTools(  proList.get(i).getData_Size() ) +" | " );
			 
			 out.println("索引容量:"+CommonTools.convCapacityTools( proList.get(i).getIndex_Size())+" | " );
			 
			 out.println("总容量:"+CommonTools.convCapacityTools( proList.get(i).getTotal_Size())+"<br><br>" );
			} // for 
		}  // try 
		catch (Exception e){e.printStackTrace(); }
    %>
   
    
    
    <br><br>
      <A HREF="MMUPortletAction.do">返回</A> <br><br>
     <br>
     <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>

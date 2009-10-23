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
  <A HREF="showDataBase.jsp">返回</A> <br><br>
  
    <% 
    	String DBName=request.getParameter("DBName");
    	try{
	    if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
		    String host=session.getAttribute("host").toString() ;
		    String username=session.getAttribute("username").toString();
		    String password=session.getAttribute("password").toString();
		    
		    out.println("您当前查看的主机是: "+host+" ");
		    
		    UtilBaseTools orm= new UtilBaseTools(host,DBName,username,password);
			IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
			List <TableStatusPojo> proList=mmu.showTableStatus();
			
			int size=proList.size();
			out.println(mmu.showUptime()+"<br><br>"  );
		%>
		
		<TR>
		<table width="98%" border="1" cellpadding="0" bordercolorlight="#999999" bordercolordark="#FFFFFF" cellspacing="0" style="font-size: 13px" > 
			<TD><b></>表名 </b></TD>
			<TD><b>表引擎 </b></TD>
			<TD><b>版本</b></TD>
			<TD><b>记录格式</b></TD>
			<TD><b>记录数量</b></TD>
			<TD><b>表空间最大容量G</b></TD>
			<TD><b>整个表包含的字节</b> </TD>
			<TD><b>使用空間</b> </TD>
			<TD><b>剩余空间</b> </TD>
 			<TD><b>下个自增长</b> </TD>
 			<TD><b>创建日期</b></TD>
 			<TD><b>最后更新日期 </b></TD>
 			<TD><b>字符集</b></TD>
 		 
 		 
			
		</TR>

		<% 
			for (int i=0;i<size;i++){
			 TableStatusPojo table=(TableStatusPojo)proList.get(i);
		%>
			<TR>
			<TD><%=table.getName()%> </TD>
			<TD><%=table.getEngine()%> </TD>
			<TD><%=table.getVersion()%> </TD>
			<TD><%=table.getRow_format()%> </TD>
			<TD><%=table.getRows()%> </TD>
			<TD><%=table.getAvg_row_length()%>G</TD>
			<TD><%=table.getData_length()%> </TD>
			<TD><%=table.getIndex_length()%> </TD>
			<TD><%=table.getData_free()%> </TD>
 			<TD><%=table.getAuto_increment()%> </TD>
 			<TD><%=table.getCreate_time()%> </TD>
 			<TD><%=table.getUpdate_time()%> </TD>
 			<TD><%=table.getCollation()%> </TD>
			 
			</TR>
		
		<% 
			} // for 
		}  // try 
		catch (Exception e){e.printStackTrace(); }
    %>
    </TABLE>
    
    
    <br><br>
      <A HREF="showDataBase.jsp">返回</A> <br><br>
     <br>
  </body>
</html>

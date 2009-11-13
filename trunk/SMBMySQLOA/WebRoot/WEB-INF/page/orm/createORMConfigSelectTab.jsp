<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>
  
  <body>
  <A HREF="createORMConfigListAction.do">返回</A><br><br>
   <%
   
    	 String createORMID=request.getAttribute("createORMID").toString();
		 String packageName=request.getAttribute("packageName").toString();
		 List <TableStatusPojo> showTabs=(List)request.getAttribute("showTabs");
		 
		 
    %>
   	创建类型是: <%=createORMID%><br>
           创建的包名是:<%=packageName%> 
    <br><br>
   选择映射的表：<br><br>
   
   <FORM METHOD="POST" ACTION="finish">
   
    <%
   	for (int i=0;i<showTabs.size();i++){
   	%>
   		<INPUT TYPE="checkbox" NAME="tab" vaule="<%=showTabs.get(i).getName()%>" checked > <%=showTabs.get(i).getName()%><br>
   	<%}%>
   <BR><BR><BR>
   
	  	1.执行show columns from table_name 查看出表的结构<BR>
		2.调用 工厂模式 根据 createORMID 使用那个 生成ORM的模板<BR>
		3.根据 表结构 和 xml配置文件模板 ，生成 配置文件和 java程序<BR>
		4.在服务器本地根据 时间戳 生成 流文件包<BR>
		5.进行压缩，压缩成 zip  流文件，而不是<BR>
		6.提供用户下载<BR>

    
    <br>
    
     <INPUT TYPE="submit" name="生成配置文件" value="下一步">
     
   </FORM>
  </body>
</html>

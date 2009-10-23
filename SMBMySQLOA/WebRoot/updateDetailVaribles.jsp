<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.xml.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<html>

  <body> 

    <% 
    String value=request.getParameter("value");
    String variable_name=request.getParameter("variable_name");
    
    
    String host=session.getAttribute("host").toString() ;
    String username=session.getAttribute("username").toString();
    String password=session.getAttribute("password").toString();
    
    
    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
	IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	
	//ReadMySQLValueDescriptionXMLFile  DescriptionXMLFile= new ReadMySQLValueDescriptionXMLFile();
	//List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
	
	mmu.setVariblesCommandByCategory( variable_name , value );
	
    %>
    
       <%
        String url="showVariblesByCategory.jsp?category="+request.getParameter("category");
       	response.sendRedirect(   url  );
        %>
     <br>
  </body>
</html>

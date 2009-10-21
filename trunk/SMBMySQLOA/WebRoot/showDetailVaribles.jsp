<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.xml.*"%>
 <%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> processlist.jsp  starting page</title>
    
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
  
  <FORM METHOD="POST" ACTION="updateDetailVaribles.jsp?category=<%=request.getParameter("category")%>">
	

    <% 
    String variable_name=request.getParameter("variable_name");
    
    String host=session.getAttribute("host").toString() ;
    String username=session.getAttribute("username").toString();
    String password=session.getAttribute("password").toString();
    
    UtilBaseTools orm= new UtilBaseTools(host,username,password);
	IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	
	ReadMySQLValueDescriptionXMLFile  DescriptionXMLFile= new ReadMySQLValueDescriptionXMLFile();
	List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
	
	MySQLVariableObject listS=mmu.showDetailVaribles(variable_name);
	
				for (int h=0;h<listF.size();h++){
				if(	listS.getVariable_name().equals(listF.get(h).getVariable_name() ) ){
					out.print ( listS.getVariable_name()+"  "  ); 
					 out.print (" <INPUT TYPE='hidden' NAME='variable_name'  value='"+listS.getVariable_name()+"'   >   "  ); 
					 out.print (" <INPUT TYPE='text' NAME='value'  value='"+listS.getValue()+"'   >   "  ); 
					 
					 
					 out.print ("<br>"  ); 
					 out.print ("<FONT SIZE='2' COLOR='#006666'> "+listF.get(h).getDescription() +" </FONT>   "  ); 
					 
					 out.print ("<br><br>"  ); 
				}
				}
				 
			 
    %>
    
     <INPUT TYPE="submit">
     </FORM>
     <br>
  </body>
</html>

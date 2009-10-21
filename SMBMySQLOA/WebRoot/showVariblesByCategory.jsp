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
    <% 
    String category=request.getParameter("category");
    
    
    String host=session.getAttribute("host").toString() ;
    String username=session.getAttribute("username").toString();
    String password=session.getAttribute("password").toString();
    
    UtilBaseTools orm= new UtilBaseTools(host,username,password);
	IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	
	ReadMySQLValueDescriptionXMLFile  DescriptionXMLFile= new ReadMySQLValueDescriptionXMLFile();
	List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
	
	List <MySQLVariableObject> listS=mmu.showVariblesCommandByCategory(category);
	
			for (int i=0;i<listS.size();i++){
				
				for (int h=0;h<listF.size();h++){
				if(	listS.get(i).getVariable_name().equals(listF.get(h).getVariable_name() ) ){
					 out.print (listS.get(i).getVariable_name()+"   "  ); 
					 out.print ("<b>"+listS.get(i).getValue()+"</b>   "  ); 
					 out.print ("<FONT SIZE='2' COLOR='#006666'> "+listF.get(h).getDescription() +" </FONT>   "  ); 
					 out.print (" <A HREF=showDetailVaribles.jsp?category="+category+"&variable_name="+listS.get(i).getVariable_name()+">edit</A>"  ); 
					 out.print ("<br><br>"  ); 
				}
				}
				 
			}
    %>
    
     <br>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.xml.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body>
    <% 
    if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
    
    String host=session.getAttribute("host").toString() ;
    String username=session.getAttribute("username").toString();
    String password=session.getAttribute("password").toString();
    
    UtilBaseTools orm= new UtilBaseTools(host,username,password);
	IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	
	ReadMySQLValueDescriptionXMLFile  DescriptionXMLFile= new ReadMySQLValueDescriptionXMLFile();
	List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLStatusDescription();
	
	List <MySQLVariableObject> listS=null;
	String category=request.getParameter("category");
	
	if(category==null){
		listS=mmu.showStatusCommand( );
	}
	else{
		listS=mmu.showStatusCommandByCategory(category);
	}
		for (int i=0;i<listS.size();i++){
				
		 for (int h=0;h<listF.size();h++){
		 if(	listS.get(i).getVariable_name().equals(listF.get(h).getVariable_name() ) ){
			 out.print (listS.get(i).getVariable_name()+"   "  ); 
			 out.print ("<b>"+listS.get(i).getValue()+"</b>  "  ); 
		     out.print ("<FONT SIZE='2' COLOR='#006666'> "+listF.get(h).getDescription() +" </FONT>  <br><br>"  ); 
		 }
		 }
	}
    %>
    
     <br>
  </body>
</html>

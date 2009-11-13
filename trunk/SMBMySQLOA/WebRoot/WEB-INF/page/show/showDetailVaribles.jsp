<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.handler.xml.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body> 
  
  <FORM METHOD="POST" ACTION="updateDetailVariblesAction.do?category=<%=request.getParameter("category")%>">
	

    <% 
    //String variable_name=request.getParameter("variable_name");
    
   //  if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
    
   // String host=session.getAttribute("host").toString() ;
   // String username=session.getAttribute("username").toString();
   // String password=session.getAttribute("password").toString();
    
   // UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
	//IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
	
	//ReadMySQLValueDescriptionXMLFile  DescriptionXMLFile= new ReadMySQLValueDescriptionXMLFile();
//	List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
	
	//MySQLVariableObject listS=mmu.showDetailVaribles(variable_name);
	MySQLVariableObject listS=(MySQLVariableObject)request.getAttribute("listS");
	List <MySQLVariableDescription> listF=(List)request.getAttribute("listF");
	
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

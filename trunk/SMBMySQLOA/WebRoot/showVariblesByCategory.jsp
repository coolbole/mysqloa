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
  <a href="javascript:history.back(-1)">返回上一页</a> <br>
    <% 
    String category=request.getParameter("category");
    
    if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
    
    String host=session.getAttribute("host").toString() ;
    String username=session.getAttribute("username").toString();
    String password=session.getAttribute("password").toString();
    
    
    
    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
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
					 if (listF.get(h).getIsEdit()!=-1){
						 out.print (" <b><A HREF=showDetailVaribles.jsp?category="+
						 category+"&variable_name="+listS.get(i).getVariable_name()+">Edit</A> </b>"  ); 
					 }
					 else{ out.print (" 此值不允许编辑 "); }
					 out.print ("<br><br>"  ); 
				}
				}
				 
			}
    %>
     <a href="javascript:history.back(-1)">返回上一页</a> <br>
     <br>
  </body>
</html>

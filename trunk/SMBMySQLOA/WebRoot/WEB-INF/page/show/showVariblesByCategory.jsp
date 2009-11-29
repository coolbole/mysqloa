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
  
    <% 
    String category=request.getParameter("category");
    %>
    
    
    <CENTER>
    <b><FONT SIZE="6" COLOR="#993333">查看 MySQL数据库 当前<%=category%>配置参数  </FONT></b>
    </CENTER>
    <br>
    <a href="MMUPortletAction.do">返回上一页</a> <br>
    <%
	
	List <MySQLVariableObject> listS=(List)request.getAttribute("listS");
	List <MySQLVariableDescription> listF=(List)request.getAttribute("listF");
	
			for (int i=0;i<listS.size();i++){
				
				for (int h=0;h<listF.size();h++){
				if(	listS.get(i).getVariable_name().equals(listF.get(h).getVariable_name() ) ){
					 out.print (listS.get(i).getVariable_name()+"   "  ); 
					 out.print ("<b>"+listS.get(i).getValue()+"</b>   "  ); 
					 out.print ("<FONT SIZE='2' COLOR='#006666'> "+listF.get(h).getDescription() +" </FONT>   "  ); 
					 if (listF.get(h).getIsEdit()!=-1){
						 out.print (" <b><A HREF=showDetailVariblesAction.do?category="+
						 category+"&variable_name="+listS.get(i).getVariable_name()+">Edit</A> </b>"  ); 
					 }
					 else{ out.print (" 此值不允许编辑 "); }
					 out.print ("<br><br>"  ); 
				}
				}
				 
			}
    %>
     <a href="MMUPortletAction.do">返回上一页</a> <br>
     <br>
     <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>

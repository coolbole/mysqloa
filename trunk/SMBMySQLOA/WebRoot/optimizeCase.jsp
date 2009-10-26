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
  您优化了系统了里面的如下配置信息：<br><br>
    <% 
      if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
	    String host=session.getAttribute("host").toString() ;
	    String username=session.getAttribute("username").toString();
	    String password=session.getAttribute("password").toString();
	    
	    
	    String optimizeCase=request.getParameter("OptimizeCaseAlias");
	    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
		IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		//ReadMySQLValueDescriptionXMLFile  read= new ReadMySQLValueDescriptionXMLFile();
		//List <MySQLVariableDescription> listF=read.getMySQLVariableDescription();
		
		List listS=mmu.MySQLOptimize( optimizeCase);
		
		for (int i=0;i<listS.size();i++){
			//String value=listS.get(i).toString().split("=")[0];
			out.println(listS.get(i)+"<br>");
		//for (int h=0;h<listF.size();h++){
		
			// if (value.equals( listF.get(h).getVariable_name() ) ){
				//out.println(value);
				//out.println(listF.get(h).getDescription());
			// }
			//}
			
		}
		
		
		 
    %>
	  
	 
	
 <br>
  </body>
</html>

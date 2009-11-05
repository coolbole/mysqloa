<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    
    <title>My JSP 'deepOptimizeCasePrepare.jsp' starting page</title>
    
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
    This is my JSP page. <br> 
    <a href="deepOptimizeCaseListAction.do?step=3">返回上一页</a> <br> <br>
   
    <br> <br> 
    	请确认您需要优化的选项：<br>
    	
    	<FORM METHOD="POST" ACTION="deepOptimizeCaseFinishAction.do">
   		 
   		 ..................<br>
   		 ..................<br>
   		 ..................<br>
   		 ..................<br>
   		 ..................<br>
   		 ..................<br>
   		 ..................<br>
    	<br> <br>
    
    
    <INPUT TYPE="text" NAME="optimizeName" value="<%=request.getAttribute("optimizeName")%>">
			
			<INPUT TYPE="submit"  name="yes" value="确定"> <br>
			<INPUT TYPE="submit"  name="cancel" value="取消"> <br>
	
 	  </FORM>
     
     
  </body>
</html>

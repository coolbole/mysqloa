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
  <a href="showProcessListAction.do">返回上一页</a> <br> <br>
  
  	第<b>一</b></>步
  <FORM METHOD="POST" ACTION="deepOptimizeCaseListAction.do?step=2">
    	
    <INPUT TYPE='checkbox' NAME='optimizeName' value='1'>您的业务环境查询大于插入？<br><br>
    	
    <INPUT TYPE='checkbox' NAME='optimizeName' value='2'>您的系统是否使用InnoDB引擎<br><br>
    
    <INPUT TYPE='checkbox' NAME='optimizeName' value='3'>您的系统是否还使用MyISAM引擎<br><br>
     
    <INPUT TYPE='checkbox' NAME='optimizeName' value='4'>您的客户端连接数是否过于频繁，一分钟超过 
    <SELECT NAME=""> 
	<OPTION VALUE="#" SELECTED>请选择</OPTION>
	<OPTION>500</OPTION><OPTION>1500</OPTION><OPTION>2500</OPTION>
 	</SELECT>
 	次连接？
 	<br><br>
     
    <INPUT TYPE='checkbox' NAME='optimizeName' value='2'>您的系统是否存在大数据量的存储<br><br>
    
     
    <INPUT TYPE="submit" value="下一步" name="下一步" >
</FORM>

 <a href="showProcessListAction.do">返回上一页</a> <br>
 <br>
  </body>
</html>

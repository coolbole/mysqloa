<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body>
  <A HREF="recentHostListAction.do">返回</A> <br><br>


 	<FORM METHOD=POST ACTION="recentHostAddAction.do">
		 
		Alias:<INPUT TYPE="text" NAME="alias"  value="Alias"  > <br>
		ServerIP:<INPUT TYPE="text" NAME="serverIP" value="192.168.1 "> <br>
		Port:<INPUT TYPE="text" NAME="port" value="3306"> <br>
		Username:<INPUT TYPE="text" NAME="username" value="Username"> <br>
		Password:<INPUT TYPE="text" NAME="password" value="Password"> <br><br>
		<INPUT TYPE="submit"  value="添加" >
	</FORM>
 	
 	</body>
 	</html>
 	
 
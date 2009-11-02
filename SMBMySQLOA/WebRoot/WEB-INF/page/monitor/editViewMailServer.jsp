<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
<%@page import="com.smb.MMUtil.handler.monitor.*"%>
<%@page import="com.smb.MMUtil.pojo.email.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>
  
  <body>
    <%
    	Email email=(Email)request.getAttribute("mailnfo");
    %>
    
   
     <A HREF="monitorHostListAction.do">返回</A><br>
     
    <br>   <br>
    
    <FORM METHOD="POST" ACTION="mailHostConfigUpdateAction.do">
		 发送邮件eMail地址<INPUT TYPE="text" NAME="emailAccount" value="<%=email.getEmailAccount()%>"> <br>
		 发送邮件主机地址(SMTP)：<INPUT TYPE="text" NAME="mailServer" value="<%=email.getMailServer()%>"> <br>
		 发送邮件主机用户名：<INPUT TYPE="text" NAME="username" value="<%=email.getUsername()%>"> <br>
		 发送邮件主机密码：<INPUT TYPE="text" NAME="password" value="<%=email.getPassword()%>"> <br>
		 发送邮件主机端口号<INPUT TYPE="text" NAME="port" value="25"> <br>
		 发送的指定邮箱<INPUT TYPE="text" NAME="recipient" value="<%=email.getRecipient()%>"> <br><br><br>
		
		<INPUT TYPE="submit">
	</FORM>
 <br>
  </body>
</html>

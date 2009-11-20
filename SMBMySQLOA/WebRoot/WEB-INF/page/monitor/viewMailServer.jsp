<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
     <A HREF="showProcessListAction.do">返回</A> &nbsp;&nbsp;
     <A HREF="mailHostConfigUpdateViewAction.do">修改</A><br>
     
    <br>   <br>
    
    <FORM METHOD="POST" ACTION="mailHostConfigUpdateAction.do">
    
		 发送邮件eMail地址:<%=email.getEmailAccount()%> <br>
		 发送邮件主机地址(SMTP)：<%=email.getMailServer()%> <br>
		 发送邮件主机用户名：<%=email.getUsername()%> <br>
		 发送邮件主机密码：<%=email.getPassword()%> <br>
		 发送邮件主机端口号:25  <br>
		 发送的指定邮箱:<%=email.getRecipient()%> <br><br><br>
		 
	</FORM>
 <br>
 
 <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>

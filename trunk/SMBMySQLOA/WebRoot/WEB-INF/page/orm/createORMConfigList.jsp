<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.base.UtilBaseTools"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>
	<body>
		<A HREF="showProcessListAction.do">返回</A>
		<br>
		<br>

		<FORM METHOD="POST" ACTION="createORMConfigSelectDBAction.do">
			
			输入您的Package名称: <INPUT TYPE="text" NAME="packageName" size="60"><BR>(例如: com.you.project.name)
			<FONT SIZE="3" COLOR="#FF0000"><%=request.getAttribute("warn")%></FONT>
			
			<BR><BR>
			
			<INPUT  TYPE="radio" NAME="createORMID" value="Hibernate" checked> Hibernate
			<BR>
		
			<INPUT TYPE="radio" NAME="createORMID" value="Hibernate+Spring">Hibernate+Spring
			<BR>
			
			<INPUT TYPE="radio" NAME="createORMID" value="iBATIS">iBATIS
			<BR>
			
			<INPUT TYPE="radio" NAME="createORMID" value="iBATIS+Spring">iBATIS+Spring
			<BR><BR><BR>
			
			

			<INPUT TYPE="submit" name="" value="下一步">
		</FORM>

	</body>
</html>

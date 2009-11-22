<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
 
<html>
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>

	<body>
		<br>
		<% 
			String err=request.getParameter("err");
			if (err!=null){
				out.println(err);
			}
			
			Integer recently=(Integer)request.getAttribute("recently");
			List <RecentHost> recentlyList=(List)request.getAttribute("recentlyList");
			Object username=request.getAttribute("username");if (username==null){username="";}
			Object password=request.getAttribute("password");if (password==null){password="";}
			Object host=request.getAttribute("host");if (host==null){host="";}
			
		%>
	
		
		<% if (host.equals("")){
			out.println ("请选择一个您最近登录过的主机，您也可以添加或者修改一个需要登录的主机地址");
		}
		else{
			out.println ("您选择的主机地址是: "+ host);
		}
		%>
		
		<br><br>
		
		<FORM METHOD="POST" ACTION="<%=request.getContextPath()%>/showProcessListAction.do">
			
			<% 
			if (recently==0){%>
			ServerIP:<INPUT TYPE="text" NAME="host" value="">   (mysql主机地址)  
			<%} else{%>
			recently:<SELECT NAME="recenthost" onchange="javascript:location.href=this.value;">
				<OPTION VALUE="#" SELECTED>--最近登录过的主机---
				<%for (int i=0;i<recentlyList.size();i++) {%>
				<OPTION VALUE="?id=<%=recentlyList.get(i).getId()%>">
				<%=recentlyList.get(i).getAlias()%>/<%=recentlyList.get(i).getServerIP()%>
				<% }%>
			</SELECT> <A HREF="recentHostListAction.do">添加/修改</A>
			<% }%>
			<br>
			
			<INPUT TYPE="hidden" NAME="host" value="<%=host%>" >
			username:<INPUT TYPE="text" NAME="username" value="<%=username%>" > (需要root用户登录)
			(用户名)
			<br>
			password:<INPUT TYPE="password" NAME="password" value="<%=password%>">
			(密码)
			<br>
			<INPUT TYPE="submit">
		</FORM>

	</body>
</html>

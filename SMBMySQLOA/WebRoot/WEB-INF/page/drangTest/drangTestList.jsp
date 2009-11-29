<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>
<%@page import="com.smb.MMUtil.handler.monitor.*"%>

<html>
	<head>
		<title>Mysql Optimize Analysis</title>
	</head>

	<body>
		<br> <A HREF="MMUPortletAction.do">返回</A><br>
		<br>
		查询压力测试
		<br><br><br>
<!-- 
	打算采用 Cp30+ 多线程技术 实现 压力测试，

	JDBC 的线程打算开启 20个 线程数，和 C3P0的启动的默认输入相等
	
	还需要考虑怎么回收C3P0创建的默认连接
 -->
		插入压力侧
	</body>
</html>
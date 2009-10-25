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
  
  
    <% 
      if(session.getAttribute("host")==null){response.sendRedirect("index.jsp");}
	    String host=session.getAttribute("host").toString() ;
	    String username=session.getAttribute("username").toString();
	    String password=session.getAttribute("password").toString();
	    
	    
	    String optimizeCase=request.getParameter("OptimizeCaseAlias");
	    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
		IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		mmu.MySQLOptimize( optimizeCase);
	
    %>
	 
	您优化了系统了里面的如下配置信息：<br><br>
		   set global max_connections=1500 <br>
		   set global max_allowed_packet=4000000000<br>
		   set global table_cache=512<br>
		   set global connect_timeout=5<br>
		   set global wait_timeout=5<br>
		   set global key_buffer_size=402649088 <br>
		   set global sort_buffer_size=1280000<br>
		   set global myisam_sort_buffer_size=640000000<br>
		   set global thread_cache_size=16 <br>
		   set global sort_buffer_size=1280000<br>
		   set global innodb_thread_concurrency=8<br>
		   set global max_binlog_cache_size=6294963200<br>
		   set global query_cache_min_res_unit=63200<br>
		   set global query_alloc_block_size=131072<br>
		   set global profiling_history_size=100<br>
		   set global table_cache=1024<br>
	
 <br>
  </body>
</html>

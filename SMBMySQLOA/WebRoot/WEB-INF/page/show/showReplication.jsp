<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smb.MMUtil.handler.*"%>
<%@page import="com.smb.MMUtil.pojo.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 
  <head>
     <title>Mysql Optimize Analysis</title>
  </head>

  <body>
    <A HREF="showProcessListAction.do">返回</A> <br><br>
  
  <%=request.getAttribute("status")%><br>  <br>
  
  <% 
  		ReplicationStatusPojo variableM=(ReplicationStatusPojo)request.getAttribute("masterStatus");
 		ReplicationStatusPojo variable=(ReplicationStatusPojo)request.getAttribute("slaveStatus");
  		if (variableM!=null){
 			out.print("MasterFile: "+ variableM.getMasterFile(  )+"<br>" );
			out.print("MasterBinlog_Do_DB: "+variableM.getMasterBinlog_Do_DB() +"<br>");
			out.print("MasterPosition: "+variableM.getMasterPosition() +"<br>");
			out.print("MasterBinlog_Ignore_DB:"+variableM.getMasterBinlog_Ignore_DB()+"<br>" );
			
		 }
		 
		if (variable!=null){
			out.print("Slave_IO_State:"+variable.getSlave_IO_State() +"<br>");
			out.print("Connect_Retry:"+variable.getConnect_Retry()+"<br>" );
			out.print("Last_Errno:"+variable.getLast_Errno() +"<br>");
			out.print("Last_Error:"+variable.getLast_Error() +"<br>");
			out.print("Last_IO_Errno:"+variable.getLast_IO_Errno() +"<br>");
			out.print("Last_IO_Error:"+variable.getLast_IO_Error()+"<br>");
			out.print("Master_Bind:"+variable.getMaster_Bind()+"<br>");
			out.print("Master_Host:"+variable.getMaster_Host()+"<br>");
			out.print("Master_Port:"+variable.getMaster_Port()+"<br>");
			
			//out.print("Master_SSL_Allowed:"+variable.getMaster_SSL_Allowed()+"<br>");
			//out.print("Master_SSL_CA_File:"+variable.getMaster_SSL_CA_File()+"<br>");
			//out.print("Master_SSL_CA_Path:"+variable.getMaster_SSL_CA_Path()+"<br>");
			//out.print("Master_SSL_Cert:"+variable.getMaster_SSL_Cert()+"<br>");
			//out.print("Master_SSL_Cipher:"+variable.getMaster_SSL_Cipher()+"<br>");
			//out.print("Master_SSL_Key:"+variable.getMaster_SSL_Key()+"<br>");
			//out.print("Master_SSL_Verify_Server_Cert:"+variable.getMaster_SSL_Verify_Server_Cert()+"<br>" );
			
			
			out.print("Master_User:"+variable.getMaster_User()+"<br>" );
			out.print("Replicate_Do_Table:"+variable.getReplicate_Do_Table()+"<br>" );
			out.print("Seconds_Behind_Master:"+variable.getSeconds_Behind_Master() +"<br>");
		}
  
  %>
  
  
    <A HREF="showProcessListAction.do">返回</A> <br><br>
    <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
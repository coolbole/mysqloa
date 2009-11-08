package com.smb.MMUtil.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.pojo.ReplicationStatusPojo;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;

public class ShowReplicationAction   implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(ShowReplicationAction.class);
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {
		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
		HttpSession session=  request.getSession();
	
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
	    String host=session.getAttribute("host").toString() ;
	    String username=session.getAttribute("username").toString();
	    String password=session.getAttribute("password").toString();
	    
	     UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
		 IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		 
		 ReplicationStatusPojo masterStatus=mmu.showMasterReplicationStatus();
		 ReplicationStatusPojo slaveStatus=mmu.showSlaveReplicationStatus();
		
		 if(slaveStatus!=null &&masterStatus!=null ){
			 request.setAttribute("masterStatus",masterStatus);  
			 request.setAttribute("slaveStatus",slaveStatus);  
			 request.setAttribute("status"," 您查看的这台机器配置了 <b>双主数</b> 据同步 。");
		 }
		 else if(slaveStatus!=null){
			 request.setAttribute("slaveStatus",slaveStatus);  
			 request.setAttribute("status","您查看的这台机器配置数据同步，这台机器为从(Salve)。");
		 }
		 else if( masterStatus!=null ){
			 request.setAttribute("masterStatus",masterStatus);  
			 request.setAttribute("status","您查看的这台机器配置数据同步，这台机器为主(Master)。");
		 }
		 
		 else{
			 request.setAttribute("status","您查看的这台机器 <b>没有</b> 配置数据同步。");  
		 }
		 
		 
		return new ModelAndPage( request ,"/WEB-INF/page/show/showReplication.jsp" );
	}
}
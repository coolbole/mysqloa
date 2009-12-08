package com.smb.framework.web.action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
public class DispatcherUtils {
	
	private static Log logger = LogFactory.getLog(DispatcherUtils.class);
	 
	private static Map<Object, Object>  actionMap=ReadActionConfigFile.getControllerConfigFile();
	
	private  static ControllerAction action=null;
	
	public   synchronized   ControllerAction getControllerAction(HttpServletRequest request ) throws  Exception{
		try{
			
			int endPoint=request.getServletPath().lastIndexOf(".");
			String requestURL=request.getServletPath().substring(1,  endPoint);
			
			if (actionMap.get(  requestURL ) ==null){
				 throw  new ControllerActionException(
					 "\n\n没有找到对应action，请检查您输入的url或者系统配置的ActionsMapping.properties文件.请注意当您修改了ActionsMapping.properties文件需要重启web容器才能生效 \n" +
					 "Did not find the corresponding action, please check the url you entered or system configuration files ActionsMapping.properties\n\n");
					}
		 
			requestURL=actionMap.get(  requestURL ).toString() ;
			Class<?> clazz= Class.forName( requestURL );  // 配置文件和url对应的类名
			
			Object object =clazz.newInstance();
 			action=(ControllerAction) object;
		}
		catch(Exception e){
			logger.error(e);
			throw  new ControllerActionException(e);
		}
		return action;
	
	}
	
	 
}
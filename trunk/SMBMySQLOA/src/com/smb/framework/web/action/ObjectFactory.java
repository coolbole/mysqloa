package com.smb.framework.web.action;

import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;


public class ObjectFactory {

	public static  Object getObjectFactory (Object  newobj, HttpServletRequest  request  )
				throws Exception{
	
		 
		HashMap<String, Object> map = new HashMap<String, Object>();    
		Enumeration<?> names = request.getParameterNames();    
		while (names.hasMoreElements())    {      
			String name = (String) names.nextElement();    
//			System.out.print (name +"     ");
//			System.out.println (request.getParameterValues(name)[0]);
			map.put(name,request.getParameterValues(name)[0] );    
		}
		 
		BeanUtils.copyProperties(newobj, map); 
		
		return newobj;
	}
	

}

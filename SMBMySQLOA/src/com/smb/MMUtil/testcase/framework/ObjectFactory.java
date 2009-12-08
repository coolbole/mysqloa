package com.smb.MMUtil.testcase.framework;

import java.util.Map;

//import org.apache.commons.beanutils.BeanUtils;

 

public class ObjectFactory {

	public static  Object getObjectFactory (Object  newobj, Map<?, ?>  request  ) throws Exception{
	
		/*	
		HashMap map = new HashMap();    
		Enumeration names = request.getParameterNames();    
		while (names.hasMoreElements())    {      
		  String name = (String) names.nextElement();    
		  map.put(name, request.getParameterValues(name));    
		}
		BeanUtils.populate(newobj, map); 
		*/
		
//		BeanUtils.copyProperties(newobj, request); 
		
		return newobj;
	}
	

}
